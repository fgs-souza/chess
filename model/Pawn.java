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

}