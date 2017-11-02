package model;
import java.util.Arrays;

public class Pawn extends Piece{

	Pawn(int team){
		hasMoved = false;
		value = 1;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		int maxSteps = hasMoved ? 1 : 2; // podem se mover 2 passos na primeira vez que se movem

		Square target = board[rowTarg][colTarg];

		if(target.isEmpty()){

			if(colIni != colTarg) // sem captura, peoes so podem se mover na mesa coluna
				return false;

			if(team == 0){ // dependendo do time, podem andar para cima ou para baixo
				if((rowTarg <= rowIni) || rowTarg > rowIni+maxSteps)
					return false;
			}else{
				if(rowTarg >= rowIni || rowTarg < rowIni-maxSteps)
					return false;
			}

		}else{
			if(target.containsEnemyPiece(team)){
				if(team == 0){
					if(rowTarg != rowIni+1 || colTarg != colIni+1) //para captura, peoes so podem se mover 1 passo na diagonal
						return false;
				} else{
					if(rowTarg != rowIni-1 || colTarg != colIni-1) //para captura, peoes so podem se mover 1 passo na diagonal
						return false;
				}
			}else{
				return false;
			}

		}

		return true;
	}


	public static void main(String[] args){
		
		Game game = new Game();

		Square[][] board = game.getBoard();

		System.out.println("Consegue se mover 2 para frente no primeiro turno: " + board[1][0].getPiece().canMove(1, 0, 3, 0, board));
		game.movePiece(1, 0, 3, 0);
		game.printBoard();
		System.out.println("Consegue se mover 2 para frente no segundo turno: " + board[3][0].getPiece().canMove(3, 0, 5, 0, board));
		System.out.println("Consegue se mover 1 para frente normalmente: " + board[3][0].getPiece().canMove(3, 0, 4, 0, board));
		game.movePiece(3, 0, 5, 0);
		game.printBoard();
		System.out.println("Consegue capturar andando para frente: " + board[5][0].getPiece().canMove(5, 0, 6, 0, board));
		System.out.println("Consegue capturar na diagonal: " + board[5][0].getPiece().canMove(5, 0, 6, 1, board));
		game.movePiece(5, 0, 4, 4);
		game.printBoard();
		System.out.println("Consegue andar na diagonal sem captura: " + board[4][4].getPiece().canMove(4, 4, 5, 5, board));
		System.out.println("Consegue capturar em coluna muito longe: " + board[4][4].getPiece().canMove(5, 0, 6, 2, board));
		System.out.println("Consegue movimento aleatorio: " + board[4][4].getPiece().canMove(5, 0, 4, 3, board));


	}
}