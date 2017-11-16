package view;
import model.*;
import control.*;

import javax.swing.*;
import java.awt.*;

public class InitialPanel extends JPanel{


	public InitialPanel(){

		setLayout(new BorderLayout());

		JPanel greetings = new JPanel();

		greetings.add(new JLabel("Bem vindo! Selecione abaixo os jogadores, ou cadastre novos."));
		
		add(greetings, BorderLayout.NORTH);

		JPanel selectPlayers = new JPanel();

		selectPlayers.add(new JLabel("Jogador 1 (peças brancas):"));
		selectPlayers.add(new JTextField(20));
		selectPlayers.add(new JLabel("Jogador 2 (peças pretas):"));
		selectPlayers.add(new JTextField(20));

		add(selectPlayers,BorderLayout.CENTER);

		
	}

	public static void main(String[] args){
		JFrame app = new JFrame("xd");
		app.setSize(600,300);
		app.setVisible(true);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(new InitialPanel());
	}

}