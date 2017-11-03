package model;

public class Square{

	private Piece piece;

	public boolean isEmpty(){
		if(piece == null){
			return true;
		}
		return false;x
	}

	public boolean containsEnemyPiece(int team){
		if(piece == null)
			return false;

		return piece.getTeam() != team;
	}


	public boolean containsAllyPiece(int team){
		if(piece == null)
			return false;
		
		return piece.getTeam() == team;
	}

	public Piece getPiece(){
		return piece;
	}

	public void setPiece(Piece piece){
		this.piece = piece;
	}

}