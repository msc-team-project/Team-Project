package commandline;

import java.util.Arrays;

/**
 * This class represents a single card  in the top trumps game
 * and holds all associated information
 */
public class Card {

	/** The name of the card **/
	private String description;
	/** The card attributes */
	private int size, speed, range, firepower, cargo;
	/** Array of the names of all attributes */
	private String[] attributes;
	
	/**
	 * Empty constructor used by the online version
	 */
	public Card() {}
	
	/**
	 * Main constructor used by the command line version
	 * @param parameters A single line from the deck text file
	 * containing the card attributes
	 */
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
	
	/**
	 * Returns the corresponding integer value of an attribute
	 * @param att the name of the attribute
	 * @return the value associated with the attribute <br>
	 * or -1 in the case of an invalid attribute parameter
	 */
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
}