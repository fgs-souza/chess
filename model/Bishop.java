	package model;

public class Bishop extends Piece{

	Bishop(int team){
		hasMoved = false;
		value = 3;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		if(!isDiagonal(rowIni, colIni, rowTarg, colTarg))
			return false;

		if(pathContainsPiece(rowIni, colIni, rowTarg, colTarg, board))
			return false;

		if(board[rowTarg][colTarg].containsAllyPiece(team))
			return false;

		
		return true;

	}

	private boolean isDiagonal(int rowIni, int colIni, int rowTarg, int colTarg){

		if((colIni+rowIni == colTarg+rowTarg) ^ (colIni-rowIni == colTarg-rowTarg))
			return true;
		
		return false;
	}

	private boolean pathContainsPiece(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){  // Checa se existe alguma peça no caminho de board[rowIni][colIni]
																											// até board[rowTarg][colTarg], excludente.
		if(Math.abs(rowIni-rowTarg) <= 1 && Math.abs(colIni - colTarg) <= 1)
			return false;							
		// Determina se o movimento é para cima ou para baixo
		boolean movingRight = colTarg > colIni;
		boolean movingDown = rowTarg > rowIni;

		// Determina se é uma diagonal na direção principal ou secundária
		int diagonal = (movingRight ^ movingDown) ? 1 : -1;

		// Determina de que linha à que linha o bispo irá se mover
		int lower = movingDown ? rowIni+1 : rowIni-1; 
		int upper = movingDown ? rowTarg-1 : rowTarg+1; 

		// Itera pelas linhas que ele irá se mover e compara a soma/diferença da linha e coluna (baseado na diagonal)
		// para descobrir se pertence ao caminho do movimento da peça. Se pertencer e possuir uma peça no quadrado, retorna true
		for(int row = lower; row <= upper; row++){
			for(int col = 0; col < 8; col++){

				if(rowIni+colIni*diagonal == row+col*diagonal){
					if(!board[row][col].isEmpty())
						return true;
				}
			}
		}


		// Passou pelos testes, retorna false
		return false;
	}



}