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

	private boolean pathContainsPiece(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){  // Checa se existe alguma peça no caminho de board[rowIni][colIni]
																											// até board[rowTarg][colTarg], excludente.
		boolean movingRight = colTarg > colIni;
		boolean movingDown = rowTarg > rowIni;

		int signal = (movingRight ^ movingDown) ? 1 : -1;

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){

				if(row+col*signal == rowIni+colIni*signal){
					if(!board[row][col].isEmpty())
						return true;

				}
			}
		}

		return false;
	}


	public static void main(String[] args){

		Game game = new Game();

		game.printBoard();

		Square[][] board = game.getBoard();

		System.out.println(board[0][2].getPiece().canMove(0,2,2,4,board));
		game.movePiece(0,2,4,4);
		game.printBoard();
		System.out.println("true: " + board[4][4].getPiece().canMove(4,4,2,2,board));
		System.out.println("false: " + board[4][4].getPiece().canMove(4,4,1,1,board));
		System.out.println("true: " + board[4][4].getPiece().canMove(4,4,6,6,board));
		System.out.println("false: " + board[4][4].getPiece().canMove(4,4,7,7,board));
		System.out.println("false: " + board[4][4].getPiece().canMove(4,4,5,4,board));
		System.out.println("true: " + board[4][4].getPiece().canMove(4,4,6,2,board));


	}

}