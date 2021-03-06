package view;
import model.*;	

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BoardPanel extends JPanel{

	private Game game;
	private JLabel[][] boardLabel;
	private Square[][] board;
		
	public BoardPanel(Game game){

		this.game = game;
		board = game.getBoard();
		boardLabel = new JLabel[8][8];

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				boardLabel[i][j] = new JLabel();
				boardLabel[i][j].setOpaque(true);
				add(boardLabel[i][j]);
			}
		}

		setLayout(new GridLayout(8,8,-1,-1));

		resetBoard();
		addMouseListener(new BoardListener());
	}

	public static void main(String[] args){

		Game game = new Game();
		BoardPanel board = new BoardPanel(game);

		JFrame app = new JFrame("Chess");

		app.add(board);
		app.setSize(900,600);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}

	public void resetBoard(){

		for(int i = 0; i < 8; i++){
			for(int j = 0; j<8; j++){

				if(i%2 == 0 ^ j % 2 == 0){
					boardLabel[i][j].setBackground(Color.GRAY);
				} else{
					boardLabel[i][j].setBackground(Color.WHITE);
				}


				if(!board[i][j].isEmpty()){

					switch(board[i][j].getPiece().getValue()){
						case 1:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "pawn.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
						case 3:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "bishop.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
						case 4:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "knight.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
						case 5:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "rook.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
						case 10:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "queen.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
						case 100:
							boardLabel[i][j].setIcon(new ImageIcon(new ImageIcon("icons/" + board[i][j].getPiece().getTeam() + "king.png").getImage().getScaledInstance(67, 70, Image.SCALE_DEFAULT)));
							break;
					}
				} else{
					boardLabel[i][j].setIcon(null);
				}

			}
		}

	}

	private class BoardListener implements MouseListener{

		int selectedRow, selectedCol;

		public BoardListener(){

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

	    	int row = e.getY()/(getHeight()/8) % (getHeight()/8); 
	    	int col = e.getX()/(getWidth()/8) % (getWidth()/8); 

	    	if(row > 7 || row < 0 || col > 7 || col < 0)
	    		return;

	    	Color BGColor = boardLabel[row][col].getBackground();
			

			if(BGColor != Color.GREEN && BGColor != Color.RED){

				if(board[row][col].isEmpty())
					return;

				resetBoard();
				selectedRow = row;
				selectedCol = col;
				
				Piece peca = board[row][col].getPiece();

			   	for(int a = 0; a < 8; a++){

			   		for(int b = 0; b < 8; b++){

			       		if(peca.canMove(row,col,a,b,board) && peca.getTeam() == game.getCurrentTeam()){

			       			if(board[a][b].containsEnemyPiece(game.getCurrentTeam()))
			       				boardLabel[a][b].setBackground(Color.RED);
			       			else
			       				boardLabel[a][b].setBackground(Color.GREEN);

			       		}
			       		

			   		}
			   	}
			}else{
				game.movePiece(selectedRow,selectedCol,row,col);
				resetBoard();

			}
	    	

		}

		
	}


}




