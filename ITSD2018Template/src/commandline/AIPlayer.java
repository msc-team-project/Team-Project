package commandline;


public class AIPlayer extends Player{
	
	private String name;
	public AIPlayer(String name)
	{
		//calls the Player superclass constructor
		super();
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
}