package view;
import model.*;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{

	Game game;
	BoardPanel boardPanel;

	public GameFrame(){
		game = new Game();
		boardPanel = new BoardPanel(game);

		setSize(900,600);
		setTitle("Chess");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
		setBoardView();

	}

	public void setBoardView(){
		add(boardPanel, BorderLayout.CENTER);
	}

	public void setInitialView(){
		//add(initalPanel, BorderLayout.CENTER);

	}

	public void setGameOverView(){
		//add(gameOverPanel, BorderLayout.CENTER);

	}

	public static void main(String[] args){
		GameFrame game = new GameFrame();
	}

}