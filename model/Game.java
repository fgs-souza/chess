package model;
import java.util.Arrays;

public class Game{

	private Square[][] board;

/*
	Board(){
		board = new Square[8][8];

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){

				int team = (col < 3) ? 0 : 1;

				board[row][col] = new Square();

				if(col == 0 || col == 7)
				{
					switch(col){
						case 0:
						case 7:
							board[row][col].setPiece(new Rook(team));
							break;
						case 1:
						case 6:
							board[row][col].setPiece(new Knight(team));
							break;
						case 2:
						case 5:
							board[row][col].setPiece(new Bishop(team));
							break;
						case 3:
							board[row][col].setPiece(new Queen(team));
							break;
						case 4:
							board[row][col].setPiece(new King(team));
							break;
					}

				} else if (col == 1 || col == 6)
					board[row][col].setPiece(new Pawn(team));
				else
					board[row][col].setPiece(null);


			}
		}
	}
	*/

	Game(){

		board = new Square[8][8];

		int team = 0;
		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				board[row][col] = new Square();
			}
		}

		board[4][4].setPiece(new Queen(0));

	}

	public void movePiece(int row1, int col1, int row2, int col2){
		Piece moving = board[row1][col1].getPiece();
		int currTeam = moving.getTeam();

		board[row2][col2].setPiece(moving);
		board[row1][col1].setPiece(null);
		moving.moved();
	}

	public Square[][] getBoard(){
		return board;
	}


	public void printBoard(){

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){

				if(board[row][col].isEmpty()){
					System.out.printf(" . ");
					continue;
				}

				Square currSquare = board[row][col];

				String team = (currSquare.getPiece().getTeam() == 0) ? "W" : "B";

				switch(board[row][col].getPiece().getValue()){
					case 1:
						System.out.printf("P");
						break;
					case 3:
						System.out.printf("B");
						break;
					case 5:
						System.out.printf("R");
						break;
					case 10:
						System.out.printf("Q");
						break;
					case 100:
						System.out.printf("K");
						break;
				}

				System.out.printf(team + " ");
			}
			System.out.println();
		}
	}
}