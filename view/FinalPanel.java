package view;
import model.*;
import control.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class FinalPanel extends JPanel{

	public FinalPanel(ActionListener handler){

		setLayout(new GridLayout(2,2));

		JLabel message = new JLabel("Fim de jogo!");

		JButton restart = new JButton("Jogar novamente");

		add(message);
		add(restart);

		restart.addActionListener(handler);
	}
}