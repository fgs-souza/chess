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
			if(row == 3)
				team = 1;	

			for(int col = 0; col < 8; col++){

				board[row][col] = new Square();

				if (row == 1 || row == 6)
					board[row][col].setPiece(new Pawn(team));

				if (row == 0 || row == 7)
					board[row][col].setPiece(new Rook(team));


			}
		}


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

				if(board[row][col].getPiece().getValue() == 1)
					System.out.printf("P" + team);
				else if(board[row][col].getPiece().getValue() == 5)
					System.out.printf("R" + team);

				System.out.printf(" ");
			}
			System.out.println();
		}
	}
}