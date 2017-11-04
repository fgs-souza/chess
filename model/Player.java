package model;

import java.io.Serializable;
public class Player implements Serializable{
	
	private int wins;
	private int games;
	private String name;

	public Player(String name){
		this.wins = 0;
		this.games = 0;
		this.name = name;
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

	public void won(){
		wins++;
		games++;
	}

	public void lost(){
		games++;
	}

}