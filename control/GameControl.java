package control;

import model.*;
import view.*;
import java.util.Scanner;

public class GameControl{

	public static void main(String[] args){

		System.out.println("Novo jogo iniciado!");
		Player player1 = new Player("joao");
		Player player2 = new Player("jose");

		Game game = new Game(player1, player2);
		Scanner s = new Scanner(System.in);

		game.printBoard();

		game: while(true){

			Square[][] board = game.getBoard();

			String currentTeam = game.getCurrentTeam() == 0 ? "White" : "Black";
			System.out.println(currentTeam + " turn. Type the row, then column of the piece you want to move: ");

			int rowIni = s.nextInt();
			int colIni = s.nextInt();

			if(board[rowIni][colIni].containsAllyPiece(game.getCurrentTeam())){
				System.out.println("Peça selecionada. Agora, digite a row e a column para que deseja movê-la: ");

				int rowTarg = s.nextInt();
				int colTarg = s.nextInt();

				if(board[rowIni][colIni].getPiece().canMove(rowIni,colIni,rowTarg,colTarg,board))
					game.movePiece(rowIni,colIni,rowTarg,colTarg);
				else{
					System.out.println("Quadrado-alvo inválido!");
					continue;
				}
			}
			else{
				System.out.println("Peça inválida! Seu time é: " + currentTeam);
				continue;
			}

			String winner = "";
			switch(game.status()){
				case -1:
					game.printBoard();
					break;
				case 0:
				case 1:
					System.out.println("Checkmate!");
					break game;
				case 2:
					System.out.println("Não é mais possível ganhar! Empate.");
					break game;
			}


		}
	}
}