package view;
import model.*;	

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardGUI extends JFrame{

	private Game game;
	private JLabel[][] boardLabel;
	private Square[][] board;
	private JPanel panel;


	public BoardGUI(Game game){

		this.game = game;
		board = game.getBoard();
		panel = new JPanel();
		boardLabel = new JLabel[8][8];
		//JLabel xadrez = new JLabel("Xadrez:");
		//frame.add(xadrez);

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				boardLabel[i][j] = new JLabel();
				boardLabel[i][j].setOpaque(true);
				panel.add(boardLabel[i][j]);
			}
		}

		panel.setLayout(new GridLayout(8,8,-1,-1));
		add(panel);

		resetBoard();
	}

	public static void main(String[] args){

		Player p1 = new Player("joao");
		Player p2 = new Player("jose");
		Game game = new Game(p1, p2);
		BoardGUI app = new BoardGUI(game);

		app.setSize(900,600);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	public void resetBoard(){

		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8; j++){

				final int row = i;
				final int col = j;


				if(i%2 == 0 ^ j % 2 == 0){
					boardLabel[i][j].setBackground(Color.GRAY);
				} else{
					boardLabel[i][j].setBackground(Color.WHITE);
				}


				if(!board[i][j].isEmpty()){

					switch(board[i][j].getPiece().getValue()){
						case 1:
							boardLabel[i][j].setText("P");
							break;
						case 3:
							boardLabel[i][j].setText("B");
							break;
						case 4:
							boardLabel[i][j].setText("C");
							break;
						case 5:
							boardLabel[i][j].setText("R");
							break;
						case 10:
							boardLabel[i][j].setText("Q");
							break;
						case 100:
							boardLabel[i][j].setText("K");
							break;
					}
				} else{
					boardLabel[i][j].setText("");
				}

				boardLabel[i][j].addMouseListener(new ListenerBase(i,j));

			}
		}

	}

	public class ListenerBase implements MouseListener {

		int row, col;

		public ListenerBase(int row, int col){
			this.row = row;
			this.col = col;

		}

		public void mousePressed(MouseEvent e) {
													       
	    }

	    public void mouseReleased(MouseEvent e) {
	       
	    }

	    public void mouseEntered(MouseEvent e) {
	      
	    }

	    public void mouseExited(MouseEvent e) {
	      
	    }

	    public void mouseClicked(MouseEvent e) {

			if(board[row][col].isEmpty())
				return;


			Piece peca = board[row][col].getPiece();


		   	for(int a = 0; a < 8; a++){

		   		for(int b = 0; b < 8; b++){

		   			final int row2 = a;
		   			final int col2 = b;

		   			if(boardLabel[a][b].getBackground() == Color.GREEN){

		       		}else{
		       			if(peca.canMove(row,col,a,b,board) && peca.getTeam() == game.getCurrentTeam()){

		       				boardLabel[a][b].setBackground(Color.GREEN);

		       				boardLabel[a][b].addMouseListener(new ListenerVerde(row,col,a,b));

		       			}
		       		}

		   		}
		   	}	
	    	

		}

	}

	public class ListenerVerde implements MouseListener{
		
		int row1, col1, row2, col2;

		public ListenerVerde(int row1, int col1, int row2, int col2){
			this.row1 = row1;
			this.col1 = col1;
			this.row2 = row2;
			this.col2 = col2;

		}

		public void mousePressed(MouseEvent e) {
													       
	    }

	    public void mouseReleased(MouseEvent e) {
	       
	    }

	    public void mouseEntered(MouseEvent e) {
	      
	    }

	    public void mouseExited(MouseEvent e) {
	      
	    }

	    public void mouseClicked(MouseEvent e) {

			if(board[row1][col1].isEmpty())
				return;


			Piece peca = board[row1][col1].getPiece();

			game.movePiece(row1,col1,row2,col2);

			resetBoard();
	    	

		}		
	}


}




