package control;

import model.*;
import view.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameControl{

	public static JFrame janelaInicial;
	public static JFrame janelaGame;
	public static JFrame janelaFinal;

	public static void main(String[] args){
		firstPanel();	

	}

	public static void startGame(){

		janelaInicial.setVisible(false);
		Game game = new Game();
		BoardPanel boardPanel = new BoardPanel(game);
		janelaGame = new JFrame();
		janelaGame.setVisible(true);
		janelaGame.add(boardPanel);
		janelaGame.setSize(800,600);
		

	}

	public static void firstPanel(){

		janelaInicial = new JFrame();
		janelaInicial.setVisible(true);
		janelaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaInicial.setLayout(new BorderLayout());
		janelaInicial.setSize(600,300);


		InitialPanel IP = new InitialPanel(new startHandler());
		janelaInicial.add(IP, BorderLayout.CENTER);
	}

	public static void endGame(){

		janelaGame.setEnabled(false);
		janelaFinal = new JFrame();
		janelaFinal.setVisible(true);
		janelaFinal.setSize(400,200);
		janelaFinal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janelaFinal.add(new FinalPanel(new restartHandler()));

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