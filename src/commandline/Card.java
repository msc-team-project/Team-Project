package commandline;

public class Card {

	private String description;
	private int size, speed, range, firepower, cargo;
	
	public Card(String parameters)
	{
		String[] params = parameters.split(" ");
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
	
	public String getCard()
	{
	String playtext = String.format("%s (Size: %d Speed: %d Range: %d Firepower: %d Cargo: %d)", description, size, speed, range, firepower, cargo);
	return playtext;
	}

	
}
