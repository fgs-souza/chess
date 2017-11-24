package view;
import model.*;
import control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class InitialPanel extends JPanel{

	ArrayList<Player> registeredPlayers = new ArrayList<Player>();
	String[] nomes;
	JComboBox<String> selectWhite;
	JComboBox<String> selectBlack;


	public InitialPanel(ActionListener handler){

		setLayout(new BorderLayout());

		JPanel selectPlayers = new JPanel();
		loadPlayers();

		selectWhite = new JComboBox<String>(nomes);
		selectBlack = new JComboBox<String>(nomes);

		selectPlayers.add(new JLabel("Jogador 1 (peças brancas):"));
		selectPlayers.add(selectWhite);
		selectPlayers.add(new JLabel("Jogador 2 (peças pretas):"));
		selectPlayers.add(selectBlack);

		JButton startGame = new JButton("Começar");
		startGame.setSize(100,200);

		JButton cadastrarJogadores = new JButton("Cadastrar jogadores");
		cadastrarJogadores.setSize(100,200);
		cadastrarJogadores.addActionListener(new CadastroHandler());

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(startGame);
		buttonPanel.add(cadastrarJogadores);

		add(selectPlayers, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		startGame.addActionListener(handler);
		startGame.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				Player selectedBlack = registeredPlayers.get(selectBlack.getSelectedIndex());
				Player selectedWhite = registeredPlayers.get(selectWhite.getSelectedIndex());

				GameControl.playerWhite = selectedWhite;
				GameControl.playerBlack = selectedBlack;
			}
		});

		
	}


	public class CadastroHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event){
			String nome = JOptionPane.showInputDialog(null, "Digite o nome do novo jogador: ");

			Player cadastro = new Player(nome);
			
			File[] files = new File("players/").listFiles();
			for(File file : files){
				if(file.getName().equals(nome + ".ser")){
					JOptionPane.showMessageDialog(null, "Já existe um jogador com esse nome!");
					return;
				}

			}
			
			JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");

			selectWhite.addItem(nome);
			selectBlack.addItem(nome);

			loadPlayers();
		}
	}


	public void loadPlayers(){

		File[] files = new File("players/").listFiles();

		for(File file : files){

			try{
				FileInputStream FIS = new FileInputStream(file);
	            ObjectInputStream OIS = new ObjectInputStream(FIS);
	            
	            registeredPlayers.add( (Player) OIS.readObject());
	            OIS.close();

        	}catch(IOException e){
        		e.printStackTrace();
        	}catch(ClassNotFoundException CNFe){
        		CNFe.printStackTrace();
        	}

		}

		nomes = new String[registeredPlayers.size()];

		for(int i = 0; i < nomes.length; i++){
			nomes[i] = registeredPlayers.get(i).getName();
		}




	}
}