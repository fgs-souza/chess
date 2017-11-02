package model;

public abstract class Piece{

	int value;
	int team;
	boolean hasMoved;

	abstract boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board);

	public int getValue(){
		return value;
	}

	public int getTeam(){
		return team;
	}

	public void moved(){
		hasMoved = true;
	}
}