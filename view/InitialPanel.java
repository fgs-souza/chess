package view;
import model.*;
import control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitialPanel extends JPanel{


	public InitialPanel(ActionListener handler){

		setLayout(new GridLayout(2,2));

		JPanel selectPlayers = new JPanel();

		selectPlayers.add(new JLabel("Jogador 1 (peças brancas):"));
		selectPlayers.add(new JTextField(20));
		selectPlayers.add(new JLabel("Jogador 2 (peças pretas):"));
		selectPlayers.add(new JTextField(20));

		JButton startGame = new JButton("Começar");

		add(selectPlayers);
		add(startGame);

		startGame.addActionListener(handler);

		
	}
}