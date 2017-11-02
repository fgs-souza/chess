package model;

public class Bishop extends Piece{

	Bishop(int team){
		hasMoved = false;
		value = 3;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		if(!isDiagonal(rowIni, colIni, rowTarg, colTarg))
			return false;

		if(pathContainsAlly(rowIni, colIni, rowTarg, colTarg, board))
			return false;

		
		return true;

	}

	private boolean isDiagonal(int rowIni, int colIni, int rowTarg, int colTarg){

		if((colIni+rowIni == colTarg+rowTarg) ^ (colIni-rowIni == colTarg-rowTarg))
			return true;
		
		return false;
	}

	private boolean pathContainsAlly(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){


		boolean movingRight = colTarg > colIni;
		boolean movingDown = rowTarg > rowIni;

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				boolean cond1, cond2, cond3, cond4;

				if(movingDown){
					cond1 = row > rowIni;
					cond3 = row < rowTarg;
				}else{
					cond1 = row < rowIni;
					cond3 = row > rowTarg;
				}

				if(movingRight){
					cond2 = col > colIni;
					cond4 = col < colTarg;
				} else{
					cond2 = col < colIni;
					cond4 = col > colTarg;
				}

				boolean isInPath = cond1 && cond2 && cond3 && cond4;


				if(isDiagonal(rowIni, colIni, row, col) && isInPath && board[row][col].containsAllyPiece(team))
					return true;
			}
		}

		return false;
	}


	public static void main(String[] args){

		Game game = new Game();

		game.printBoard();

		Square[][] board = game.getBoard();
		System.out.println(board[1][0].getPiece().canMove(1, 0, 4, 3, board));
		game.movePiece(1, 0, 4, 3);
		game.printBoard();
		System.out.println(board[4][3].getPiece().canMove(4, 3, 2, 5, board));
		game.movePiece(4, 3, 2, 5);
		game.printBoard();
		System.out.println(board[2][5].getPiece().canMove(2, 5, 0, 3, board));
		game.movePiece(2,5,1,0);
		game.movePiece(1,2,0,1);
		game.printBoard();
		System.out.println(board[0][1].getPiece().canMove(0, 1, 3, 4, board));

	}

}