package model;

public class Queen extends Piece{

	Queen(int team){
		hasMoved = false;
		value = 10;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		// Movimento da rainha é a composição dos movimentos da torre e do bispo

		Rook queenRook = new Rook(team);
		Bishop queenBishop = new Bishop(team);

		if(!(queenRook.canMove(rowIni, colIni, rowTarg, colTarg, board) ||
		   queenBishop.canMove(rowIni, colIni, rowTarg, colTarg, board)))
			return false;

		return true;	
	}


	public static void main(String[] args){



		Game game = new Game(new Player(""), new Player(""));

		Square[][] board = game.getBoard();

		game.printBoard();

		System.out.println("Consegue se mover 1 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 5, 4, board));
		System.out.println("Consegue se mover 1 pra cima: " + board[4][4].getPiece().canMove(4, 4, 3, 4, board));
		System.out.println("Consegue se mover 1 pra esquerda: " + board[4][4].getPiece().canMove(4, 4, 4, 3, board));
		System.out.println("Consegue se mover 1 pra direita: " + board[4][4].getPiece().canMove(4, 4, 4, 5, board));
		System.out.println("Consegue se mover 2 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 6, 4, board));
		System.out.println("Consegue se mover 1 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 5, 5, board));
		System.out.println("Consegue se mover 4 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 0, 0, board));
	}

}