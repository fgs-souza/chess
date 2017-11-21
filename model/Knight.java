package model;

public class Knight extends Piece{

	Knight(int team){
		hasMoved = false;
		value = 4;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		// Pode se mover para quadrados que estejam a 2 colunas e 1 linha ou 2 linhas e 1 coluna de distancia.
		if(!(Math.abs(rowTarg-rowIni) == 2 && Math.abs(colTarg-colIni) == 1 || Math.abs(rowTarg-rowIni) == 1 && Math.abs(colTarg-colIni) == 2))
			return false;

		if(board[rowTarg][colTarg].containsAllyPiece(team))
			return false;

		return true;	
	}

}