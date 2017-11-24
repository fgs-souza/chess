package control;

import model.*;
import view.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameControl{

	private static JFrame janelaInicial;
	private static JFrame janelaGame;
	private static JFrame janelaFinal;

	private static Game game;
	public static Player playerWhite;
	public static Player playerBlack;

	public static void main(String[] args){
		firstPanel();	

	}

	public static void startGame(){


		System.out.println(playerWhite.getName() + ": Wins: " + playerWhite.getWins() + " Games: " + playerWhite.getGames());
		System.out.println(playerBlack.getName() + ": Wins: " + playerBlack.getWins() + " Games: " + playerBlack.getGames());

		janelaInicial.setVisible(false);
		game = new Game();
		BoardPanel boardPanel = new BoardPanel(game);
		janelaGame = new JFrame("Xadrez: " + playerWhite.getName() + " vs " + playerBlack.getName());
		janelaGame.add(boardPanel);
		janelaGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaGame.setSize(800,600);
		janelaGame.setVisible(true);
		

	}

	public static void firstPanel(){

		janelaInicial = new JFrame("Xadrez");
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaInicial.setLayout(new BorderLayout());
		janelaInicial.setSize(800,150);

		InitialPanel IP = new InitialPanel(new startHandler());
		janelaInicial.add(IP, BorderLayout.CENTER);
		janelaInicial.setVisible(true);
	}

	public static void endGame(){

		int winner = game.getWinner();
		String winnerString = "";

		if(winner == 0){
			playerWhite.won();
			playerBlack.lost();
			winnerString = playerWhite.getName();
		} else{
			playerWhite.lost();
			playerBlack.won();
			winnerString = playerBlack.getName();
		}

		playerWhite.serialize();
		playerBlack.serialize();

		janelaGame.setEnabled(false);
		janelaFinal = new JFrame("Xadrez");
		janelaFinal.setSize(400,200);
		janelaFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaFinal.add(new FinalPanel(new restartHandler(),winnerString));
		janelaFinal.setVisible(true);

	}


	public static class startHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){
			startGame();
		}
	}

	public static class restartHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){
			janelaGame.setVisible(false);
			janelaFinal.setVisible(false);
			firstPanel();
		}
	}

	
}