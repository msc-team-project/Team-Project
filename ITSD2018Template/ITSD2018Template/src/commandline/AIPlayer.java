package commandline;


public class AIPlayer extends Player{
	
	public AIPlayer(String name)
	{
		//calls the Player superclass constructor
		super();
		this.name = name;
	}

	@Override
	public String pickAttribute() {
		String[] atts = cardInPlay.getAttributes();
		int[] values = {cardInPlay.getSize(), cardInPlay.getSpeed(), cardInPlay.getRange(), cardInPlay.getFirepower(), cardInPlay.getCargo()};
		String att = "";
	
		int max = 0;
		for(int i = 0; i < 5; i++)
		{
			int value = values[i];
			if(value > max)
			{
				max = value;
				att = atts[i];
			}
		}
		return att;
	}
}
