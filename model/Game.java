package model;
import java.util.Arrays;

public class Game{

	private Square[][] board;
	private Player playerWhite;
	private Player playerBlack;

	public Game(Player playerWhite, Player playerBlack){
		board = new Square[8][8];
		this.playerWhite = playerWhite;
		this.playerBlack = playerBlack;

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

	public int status(){ // Retorna -1 se o jogo ainda não acabou, 0 se acabou e o time branco venceu, 
						 // 1 se acabou e o time preto venceu, ((2 se acabou em empate)) - a ser implementado.

		boolean whiteHasKing = false;
		boolean blackHasKing = false;

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){

				if(!board[row][col].isEmpty()){
					Piece piece = board[row][col].getPiece();

					if(piece.getValue() == 100){

					int pieceTeam = piece.getTeam();

					if(pieceTeam == 0)
						whiteHasKing = true;
					else if(pieceTeam == 1)
						blackHasKing = true;


					/*if(piece.isCheckmated(row, col, board))
						return (piece.getTeam() + 1) %2*/
					}
				}
			}
		}

		if(!whiteHasKing){
			playerWhite.won();
			playerBlack.lost();
			return 1;
		}

		if(!blackHasKing){
			playerWhite.lost();
			playerBlack.won();
			return 0;
		}

		return -1;
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
					case 4:
						System.out.printf("C");
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