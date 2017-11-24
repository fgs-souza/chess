package model;
import java.util.Arrays;

import control.*;

public class Game{

	private Square[][] board;
	private int currentTeam;
	int winner;

	public Game(){

		board = new Square[8][8];
		currentTeam = 0;

		for(int row = 0; row < 8; row++){

			int team = (row < 3) ? 0 : 1;

			for(int col = 0; col < 8; col++){

				board[row][col] = new Square();

				if(row == 0 || row == 7)
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

				} else if (row == 1 || row == 6)
					board[row][col].setPiece(new Pawn(team));
				else
					board[row][col].setPiece(null);

			}
		}
	}

	public Square[][] getBoard(){
		return board;
	}

	public int getCurrentTeam(){
		return currentTeam;
	}

	public void movePiece(int row1, int col1, int row2, int col2){
		Piece moving = board[row1][col1].getPiece();
		moving.moved();

		if(!board[row2][col2].isEmpty()){
			if(board[row2][col2].getPiece().getValue() == 100){
				winner = moving.getTeam();
				GameControl.endGame();
			}
		}

		board[row2][col2].setPiece(moving);
		board[row1][col1].setPiece(null);
		currentTeam = (currentTeam+1) % 2;
	}

	public int getWinner(){
		return winner;
	}

}