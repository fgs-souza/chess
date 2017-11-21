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

}