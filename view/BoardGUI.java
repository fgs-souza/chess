package view;

import javax.swing.*;
import java.awt.*;

public class BoardGUI extends JFrame{

	Board board;


	public BoardGUI(Board board;){

		JPanel panel = new JPanel();
		//JLabel xadrez = new JLabel("Xadrez:");
		//frame.add(xadrez);


		panel.setLayout(new GridLayout(8,8,-1,-1));
		add(panel);

		for(int i = 0; i < 64; i++){
			JLabel temp = new JLabel();
			if(i%2 == 0 ^ i%16<8){
				temp.setOpaque(true);
				temp.setBackground(Color.BLACK);
			}	
			panel.add(temp);
		}s
	}

	public static void main(String[] args){

		BoardGUI app = new BoardGUI();

		app.setSize(900,600);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}




