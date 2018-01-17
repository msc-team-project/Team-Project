package commandline;

import java.util.ArrayList;
import java.util.Arrays;

public class Card {

	private String description;
	private int size, speed, range, firepower, cargo;
	private String[] attributes;
	
	public Card(String parameters)
	{
		String[] params = parameters.split(" ");
		attributes = new String[] {"size", "speed", "range", "firepower", "cargo"};
		description = params[0];
		size = Integer.parseInt(params[1]);
		speed = Integer.parseInt(params[2]);
		range = Integer.parseInt(params[3]);
		firepower = Integer.parseInt(params[4]);
		cargo = Integer.parseInt(params[5]);
	}

	public String getDescription() {
		return description;
	}

	public int getSize() {
		return size;
	}

	public int getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public int getFirepower() {
		return firepower;
	}

	public int getCargo() {
		return cargo;
	}
	
	public String[] getAttributes() {
		return attributes;
	}
	
	//this was originally in the player class but i needed it here for the log file
	//it is still in the player class
	//probably good practice to remove it from player and access it with player.cardinplay.getvalueofatt()
	//so we are not duplicating code unnecessarily
	//tbh i couldn't be bothered having to change the code but can maybe do it later
	public int getValueOfAtt(String att)
	{
		switch(att)
		{
		case "size":
			return size;
		case "speed":
			return speed;
		case "range":
			return range;
		case "firepower":
			return firepower;
		case "cargo":
			return cargo;
		}
		return -1;
	}

	//this returns all of the attribute names as an arraylist
	//needed it for the player select attribute to check that valid attribute is entered
	public ArrayList<String> getAttributesAsList() {
		ArrayList<String> atts = new ArrayList<String>(Arrays.asList(attributes));
		return atts;
	}
	
}