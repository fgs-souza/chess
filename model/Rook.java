package model;

public class Rook extends Piece{

	Rook(int team){
		hasMoved = false;
		value = 5;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		// Retorna falso se o movimento não for ou na mesma linha ou na mesma coluna
		if(!(colTarg == colIni ^ rowTarg == rowIni))
			return false;

		if(board[rowTarg][colTarg].containsAllyPiece(team))
			return false;

		// Proximo passo: descobrir se possui peça aliada no caminho:

		// Descobre se o movimento é vertical ou horizontalx para decidir se itera sobre colunas ou linhas
		boolean isVertical = colIni == colTarg;

		int moveLineIni = isVertical ? rowIni : colIni; 
		int moveLineTarg = isVertical ? rowTarg : colTarg;

		// Descobre se o movimento é (cima->baixo) ou o contrário, para saber em que direção iterar
		// No movimento vertical, considera-se esquerda como   e direita como baixo
		boolean movingDown = moveLineTarg > moveLineIni;

		int upper = movingDown ? moveLineTarg-1 : moveLineIni-1;
		int lower = movingDown ? moveLineIni+1 : moveLineTarg+1;

		// Itera pelo caminho a ser percorrido e determina se existe peça aliada
		for(int i = lower; i <= upper; i++){
			Square square = isVertical ? board[i][colIni] : board[rowTarg][i];

			if(!square.isEmpty())
				return false;
		}

		return true;	
	}

}