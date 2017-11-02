package model;

public class Square{

	private Piece piece;

	public boolean isEmpty(){
		if(piece == null){
			return true;
		}
		return false;
	}

	public boolean containsEnemyPiece(int team){
		return piece.getTeam() != team ? true : false;
	}

	public Piece getPiece(){
		return piece;
	}

	public void setPiece(Piece piece){
		this.piece = piece;
	}

}