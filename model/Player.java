package model;
import java.io.*;

public class Player implements Serializable{
	
	private int wins;
	private int games;
	private String name;

	public Player(String name){
		this.wins = 0;
		this.games = 0;
		this.name = name;
	}

	public void serialize() throws IOException{

		File file = new File("players/" + this.name + ".ser");


		FileOutputStream FOS = new FileOutputStream("players/" + this.name + ".ser");
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		OOS.writeObject(this);
		OOS.close();



	}

	public int getWins(){
		return wins;
	}

	public int getGames(){
		return games;
	}

	public int getLosses(){
		return games - wins;
	}

	public String getName(){
		return name;
	}

	public void won(){
		wins++;
		games++;
	}

	public void setWins(int wins)
	{
		this.wins = wins;
	}

	public void lost(){
		games++;
	}

}