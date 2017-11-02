package model;

public class King extends Piece{

	King(int team){
		hasMoved = false;
		value = 100;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		Square target = board[rowTarg][colTarg];

		if(target.containsAllyPiece(team))
			return false;

		int rowDiff = Math.abs(rowTarg - rowIni);
		int colDiff = Math.abs(rowTarg - rowIni);

		if(rowDiff > 1 || colDiff > 1)
			return false;

		return true;	
	}

	public static void main(String[] args){

		Game game = new Game();

		Square[][] board = game.getBoard();

		game.printBoard();

		System.out.println("Consegue se mover 1 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 5, 4, board));
		System.out.println("Consegue se mover 1 pra cima: " + board[4][4].getPiece().canMove(4, 4, 3, 4, board));
		System.out.println("Consegue se mover 1 pra esquerda: " + board[4][4].getPiece().canMove(4, 4, 4, 3, board));
		System.out.println("Consegue se mover 1 pra direita: " + board[4][4].getPiece().canMove(4, 4, 4, 5, board));
		System.out.println("Consegue se mover 2 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 6, 4, board));
		System.out.println("Consegue se mover 1 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 5, 5, board));
		System.out.println("Consegue se mover 2 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 2, 2, board));
	}
}