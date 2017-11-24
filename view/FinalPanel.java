package view;
import model.*;
import control.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class FinalPanel extends JPanel{

	public FinalPanel(ActionListener handler, String winner){

		setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();

		JButton restart = new JButton("Jogar novamente");

		restart.addActionListener(handler);
		buttonPanel.add(restart);

		JPanel messagePanel = new JPanel();

		JLabel message = new JLabel("Fim de jogo! " + winner + " venceu.");

		messagePanel.add(message);

		add(messagePanel, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.CENTER);
	}

}