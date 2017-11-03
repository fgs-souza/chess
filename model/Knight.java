package model;

public class Knight extends Piece{

	Knight(int team){
		hasMoved = false;
		value = 4;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		if(!(Math.abs(rowTarg-rowIni) == 2 && Math.abs(colTarg-colIni) == 1 || Math.abs(rowTarg-rowIni) == 1 && Math.abs(colTarg-colIni) == 2))
			return false;

		if(board[rowTarg][colTarg].containsAllyPiece(team))
			return false;

		return true;	
	}


	public static void main(String[] args){

		Game game = new Game();

		game.printBoard();

		Square[][] board = game.getBoard();

		System.out.println(board[0][1].getPiece().canMove(0,1,2,0,board));
		System.out.println(board[0][1].getPiece().canMove(0,1,2,2,board));
		System.out.println(board[0][1].getPiece().canMove(0,1,2,1,board));
		System.out.println(board[0][1].getPiece().canMove(0,1,1,3,board));
		game.movePiece(0,1,4,4);
		game.printBoard();
		System.out.println(board[4][4].getPiece().canMove(4,4,2,0,board));
		System.out.println(board[4][4].getPiece().canMove(4,4,6,3,board));
		System.out.println(board[4][4].getPiece().canMove(4,4,6,5,board));
	}
}