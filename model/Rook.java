package model;

public class Rook extends Piece{

	Rook(int team){
		hasMoved = false;
		value = 5;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){


		if(!(colTarg == colIni ^ rowTarg == rowIni))
			return false;

		boolean isVertical = colIni == colTarg;


		int moveLineIni = isVertical ? rowIni : colIni;
		int moveLineTarg = isVertical ? rowTarg : colTarg;

		boolean movingDown = moveLineTarg > moveLineIni;

		int upper = movingDown ? moveLineTarg : moveLineIni-1;
		int lower = movingDown ? moveLineIni+1 : moveLineTarg;

		for(int i = lower; i <= upper; i++){
			Square square = isVertical ? board[i][colIni] : board[rowTarg][i];

			if(!square.isEmpty() && !square.containsEnemyPiece(team))
				return false;
		}

		return true;	
	}


	public static void main(String[] args){

		Game game = new Game();

		Square[][] board = game.getBoard();

		game.printBoard();
		System.out.println(board[7][0].getPiece().canMove(7, 0, 5, 0, board));
		game.movePiece(6, 0, 4, 4);
		game.printBoard();	
		System.out.println(board[7][0].getPiece().canMove(7, 0, 5, 0, board));
		game.movePiece(4, 4, 4, 0);
		game.printBoard();
		System.out.println(board[7][0].getPiece().canMove(7, 0, 5, 0, board));
		System.out.println(board[7][0].getPiece().canMove(7, 0, 4, 0, board));
		System.out.println(board[7][0].getPiece().canMove(7, 0, 3, 0, board));
		game.movePiece(7,0,5,0);
		game.printBoard();
		System.out.println(board[5][0].getPiece().canMove(5, 0, 5, 5, board));
		game.movePiece(4,0,5,3);
		game.printBoard();
		System.out.println(board[5][0].getPiece().canMove(5, 0, 5, 7, board));

	}

}