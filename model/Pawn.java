package model;
import java.util.Arrays;

public class Pawn extends Piece{

	Pawn(int team){
		hasMoved = false;
		value = 1;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		int maxSteps = hasMoved ? 1 : 2; // podem se mover 2 passos na primeira vez que se movems

		Square target = board[rowTarg][colTarg];

		if(target.isEmpty()){ // Caso de movimento sem captura

			if(colIni != colTarg) // sem captura, peoes so podem se mover na mesa coluna
				return false;

			if(team == 0){ // peoes só podem se movimentar em uma direção, dependendo do seu time
				if((rowTarg <= rowIni) || rowTarg > rowIni+maxSteps)
					return false;
			}else{
				if(rowTarg >= rowIni || rowTarg < rowIni-maxSteps)
					return false;
			}

		}else{ // Movimento com captura
			if(target.containsEnemyPiece(team) && Math.abs(colTarg - colIni) == 1){ // para capturar, precisa de peça inimiga e apenas 1 coluna de diferença
				if(team == 0){
					if(rowTarg != rowIni+1)
						return false;
				} else{
					if(rowTarg != rowIni-1)
						return false;
				}
			}else{
				return false;
			}

		}

		return true;
	}


	public static void main(String[] args){
		Player p1 = new Player("");
		Player p2= new Player("");
		
		
		Game game = new Game(p1,p2);

		Square[][] board = game.getBoard();

		System.out.println("tests: ");

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