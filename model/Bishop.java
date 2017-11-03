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

		if(pathContainsPiece(rowIni, colIni, rowTarg, colTarg, board))
			return false;

		if(board[rowTarg][colTarg].containsAllyPiece(team))
			return false;

		
		return true;

	}

	private boolean isDiagonal(int rowIni, int colIni, int rowTarg, int colTarg){

		if((colIni+rowIni == colTarg+rowTarg) ^ (colIni-rowIni == colTarg-rowTarg))
			return true;
		
		return false;
	}

	private boolean pathContainsPiece(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){


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


				if(isDiagonal(rowIni, colIni, row, col) && isInPath && !board[row][col].isEmpty())
					return true;
			}
		}

		return false;
	}


	public static void main(String[] args){

		Game game = new Game();

		game.printBoard();

		Square[][] board = game.getBoard();
		System.out.println(board[1][0].getPiece().canMove(0, 0, 2, 2, board));
		game.printBoard();
		game.movePiece(0,0,4,4);
		game.printBoard();
		System.out.println(board[4][4].getPiece().canMove(4, 4, 1, 1, board));


	}

}