package model;

public class King extends Piece{

	King(int team){
		hasMoved = false;
		value = 100;
		this.team = team;
	}

	public boolean canMove(int rowIni, int colIni, int rowTarg, int colTarg, Square[][] board){

		Square target = board[rowTarg][colTarg];

		if(target.containsAllyPiece(team))
			return false;

		int rowDiff = Math.abs(rowTarg - rowIni);
		int colDiff = Math.abs(colTarg - colIni);
		if(rowDiff > 1 || colDiff > 1)
			return false;

		if(isChecked(rowTarg, colTarg, board))
			return false;

		return true;	
	}

	public boolean isChecked(int kingRow, int kingCol, Square[][] board){

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){

				if(board[row][col].containsEnemyPiece(team) && board[row][col].getPiece().getValue() != 1){
					if(board[row][col].getPiece().canMove(row, col, kingRow, kingCol, board))
						return true;
				} else if(board[row][col].containsEnemyPiece(team) && board[row][col].getPiece().getValue() != 1){
					int direction = board[row][col].getPiece().getTeam() == 0 ? 1 : -1;

					if(kingRow == row+1*direction && (kingCol == col-1 || kingCol == col+1))
						return true;
				}


			}
		}

		return false;
	}

	public boolean isCheckmated(int kingRow, int kingCol, Square[][] board){

		
		if(!isChecked(kingRow, kingCol, board))
			return false;		

		for(int row = 0; row < 8; row++){
			for(int col = 0; col < 8; col++){
				if(canMove(kingRow, kingCol, row, col, board))
					if(!isChecked(row, col, board))
						return false;


			}
		}

		return true;
	}

	public static void main(String[] args){

		Player p1 = new Player("");
		Player p2 = new Player("");
		
		Game game = new Game(p1,p2);

		Square[][] board = game.getBoard();

		game.printBoard();
		game.movePiece(0,4,4,4);
		game.printBoard();

		System.out.println("Consegue se mover 1 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 5, 4, board));
		System.out.println("Consegue se mover 1 pra cima: " + board[4][4].getPiece().canMove(4, 4, 3, 4, board));
		System.out.println("Consegue se mover 1 pra esquerda: " + board[4][4].getPiece().canMove(4, 4, 4, 3, board));
		System.out.println("Consegue se mover 1 pra direita: " + board[4][4].getPiece().canMove(4, 4, 4, 5, board));
		System.out.println("Consegue se mover 2 pra baixo: " + board[4][4].getPiece().canMove(4, 4, 6, 4, board));
		System.out.println("Consegue se mover 1 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 5, 5, board));
		System.out.println("Consegue se mover 2 pra diagonal: " + board[4][4].getPiece().canMove(4, 4, 2, 2, board));
	}
}