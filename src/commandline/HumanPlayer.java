package commandline;

import java.util.Scanner;

public class HumanPlayer extends Player{

	//prompts player to select an attribute
	//takes a scanner as an argument so that the main scanner can be reused
	//having multiple scanners open at once seems to cause errors
	public String playerSelectAttribute(Scanner scanner)
	{
		String att = "";
		String[] atts = cardInPlay.getAttributes();
		boolean valid = false;
		String message = "Select attribute: ";
		while(!valid)
		{
			//checks that the input is one of the card's attribute names
			System.out.println(message);
			att = scanner.next();
			for(String s : atts)
			{
				if(att.toLowerCase().equals(s))
					valid = true;
				else if (att.toLowerCase().equals("quit") || att.toLowerCase().equals("exit"))
					System.exit(0);
			}
			message = "Please enter a valid attribute (or 'quit' to quit)";
		}		
		//returns the attribute as a String
		return att;
	}
	
}