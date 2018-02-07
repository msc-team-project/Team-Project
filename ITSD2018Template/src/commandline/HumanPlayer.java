package commandline;

public class HumanPlayer extends Player{

	//prompts player to select an attribute
	//takes a scanner as an argument so that the main scanner can be reused
	//having multiple scanners open at once seems to cause errors
	
	@Override
	public String pickAttribute() {
		String att = "";
		String[] atts = cardInPlay.getAttributes();
		boolean valid = false;
		String message = "Select attribute: ";
		while(!valid)
		{
			//checks that the input is one of the card's attribute names
			System.out.println(message);
			att = TopTrumpsCLIApplication.scanner.nextLine();
			for(String s : atts)
			{
				if(att.toLowerCase().equals(s))
					valid = true;
				else if (att.equals("quit") || att.equals("exit"))
					return "exit";
			}
			message = "Select an attribute or type \'quit\' to quit";
		}		
		//returns the attribute as a String
		return att;
	}
	
}