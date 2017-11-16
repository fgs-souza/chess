package model;
import java.util.Arrays;

public class Game{

	private Square[][] board;
	private int currentTeam ;
	private Player playerWhite;
	private Player playerBlack;

	public Game(Player playerWhite, Player playerBlack){

		board = new Square[8][8];
		this.playerWhite = playerWhite;
		this.playerBlack = playerBlack;
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

	public Game(){

		this(new Player("Default p1"), new Player("Default p2"));
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

		board[row2][col2].setPiece(moving);
		board[row1][col1].setPiece(null);
		currentTeam = (currentTeam+1) % 2;
	}

	public int status(){ // Retorna -1 se o jogo ainda não acabou, 0 se acabou e o time branco venceu, 
						 // 1 se acabou e o time preto venceu, ((2 se acabou em empate)) - a ser implementado.
/*
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


					if(piece.isCheckmated(row, col, board))
						return (piece.getTeam() + 1) %2;
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
*/
		return -1;
	}

}