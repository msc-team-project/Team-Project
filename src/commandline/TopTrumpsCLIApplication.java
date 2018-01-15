package commandline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Top Trumps command line application
 */
public class TopTrumpsCLIApplication 
{

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. The contents of args[0] is whether we should write game logs to a file.
 	 * @param args
	 */
	
	private static ArrayList<Card> deck, communalDeck;
	private static int numberPlayers, gamesPlayed, round;
	private static ArrayList<Player> players;
	private static boolean valid;
	
	public static void main(String[] args) 
	{

		boolean writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		// States
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		boolean gameOver = false; // flag to check whether the current game has finished (only one player left)
		
		// build and shuffle the deck
		
		Scanner scanner = new Scanner(System.in);
		deck = buildDeck();
		communalDeck = new ArrayList<Card>();
		Collections.shuffle(deck);
		
		// set up the players and divide deck between them
		
		setUpPlayers(scanner);
		divideDeck();
		
		// Loop until the user wants to exit the game
		
		while (!userWantsToQuit) 
		{
			
			// increment current round counter
			round++;
			
			// display current round details
			System.out.println("\nROUND "+round);
			System.out.println("Active Player: \n"); // TODO: implement functionality to randomly select a player to start, display here
			
			// each player plays a card
			
			ArrayList<Card> cardsInPlay = new ArrayList<Card>();
			for(int i = 0; i < players.size(); i++)
					cardsInPlay.add(players.get(i).playCard());
			
			// user picks an attribute
			
			System.out.println(String.format("Your card is: %s", cardsInPlay.get(0).getCard()));
			System.out.println("\nWhich attribute would you like to play?");
			
			String attribute = scanner.next();
			checkAttributeInput(attribute);
			while (!valid)
			{
				System.out.println("Please enter a valid attribute (or 'quit' to quit)");
				attribute = scanner.next();
				checkAttributeInput(attribute);
			}
			
			System.out.println("");
			
			// AI players play their cards
			
			for (int i = 0; i < players.size(); i++)
			{
				Card c = cardsInPlay.get(i);
				String playtext = "";
				if (i == 0)
					playtext = String.format("You played %s (Size: %d Speed: %d Range: %d Firepower: %d Cargo: %d)", c.getDescription(), c.getSize(), c.getSpeed(), c.getRange(), c.getFirepower(), c.getCargo());
				else if (i > 0)
					playtext = String.format("Player %d played %s (Size: %d Speed: %d Range: %d Firepower: %d Cargo: %d)", i+1, c.getDescription(), c.getSize(), c.getSpeed(), c.getRange(), c.getFirepower(), c.getCargo());
				System.out.println(playtext);
			}
			
			System.out.println("");
			
			// determine what the highest attribute value is of all played cards
			
			int max = -1;
			for(Player p : players)
			{
				int x = p.getValueOfAtt(attribute);
				if(x > max)
					max = x;
			}
			
			// determine round winner
			
			ArrayList<Integer> roundwinners = new ArrayList<Integer>();
			for(Player p : players)
			{
				if(p.getValueOfAtt(attribute) == max)
					roundwinners.add(players.indexOf(p));
			}
			
			// if there is one round winner, declare the winner, else declare a draw
			
			if (roundwinners.size() == 1)
			{
				int w = roundwinners.get(0);
				if (w == 0) // if user is the winner
					System.out.println("You win this round!\n");
				else if (w > 0) // if another player is the winner
					System.out.println("Player " + (w+1) + " wins this round\n");
				players.get(w).addHandToDeck(cardsInPlay); // round winner adds cards in play to their own deck
				players.get(w).addHandToDeck(communalDeck); // round winner adds communal deck to their own deck
				communalDeck = new ArrayList<Card>(); // create a new communal deck
			}
			else if (roundwinners.size() > 1)
			{
				String message = "Round ended in draw between ";
					int w = roundwinners.get(0);
					if (w == 0) // if user is part of draw, output "you and Player X"
						message += "you and Player " + Integer.toString(roundwinners.get(1)+1); 
					else if (w > 0) // if user is not part of draw, output "Player X and Player Y"
					{
						message += "Player " + Integer.toString(w+1);
						if (roundwinners.get(-1) != roundwinners.size()-1)
							message += " and ";
					}
				
				communalDeck.addAll(cardsInPlay); // all cards in play are added to communal deck
				System.out.println(message); // print draw message
				System.out.println(communalDeck.size() + " cards in communal deck\n"); // print number of cards in communal deck
			}
		
			// print how many cards each player has in their deck
			
			printPlayerDeckSizes();
			
			// remove any player with an empty deck from the game
			
			for (int i = 0; i < players.size(); i++)
				if (players.get(i).getDeckSize() == 0)
				{
					System.out.println("\nPlayer "+(i+1)+" has been removed from the game.\n");
					players.remove(i);
				}
			
			// if only one player is left, they win the game - add them to array list of game winners
			
			ArrayList<Integer> gamewinners = new ArrayList<Integer>();
				if (players.size() == 1)
				{
					for(Player p : players)
						gamewinners.add(players.indexOf(p));
					System.out.println("\nPlayer "+gamewinners.get(0)+1+" wins the game!\n");
					gamesPlayed++; // increment count of games won
					gameOver = true; // set flag to indicate game has ended
				}

			
			// if the game is over, ask if the player wants to play again
				
			if (gameOver)
			{
				System.out.println("Do you want to play again?");
				String response = scanner.next();
				if (response.equals("no") || response.equals("exit"))
				{
					scanner.close();
					userWantsToQuit=true; // quit the game 
				}
				else // start a new game
				{
					deck = buildDeck(); // build a new deck
					communalDeck = new ArrayList<Card>(); // make a new communal deck
					Collections.shuffle(deck); // shuffle the deck
					round = 0; // reset round counter (will be incremented to 1 at the start of Round 1)
				}

			}

		}


	}
	
	public static void setUpPlayers(Scanner scanner)
	{
		numberPlayers = 1;
		while(numberPlayers < 2 || numberPlayers > 5)
		{
			System.out.println("How many opponents (1-4)");
			String input = scanner.next();
			if (input.equals("exit") || input.equals("quit"))
				System.exit(0);
			numberPlayers = 1 + Integer.parseInt(input);
		}
		players = setUpPlayers(numberPlayers - 1);
	}
	
	private static ArrayList<Card> buildDeck()
	{
		ArrayList<Card> deck = new ArrayList<Card>();
		try 
		{
			BufferedReader reader = new BufferedReader(new FileReader("StarCitizenDeck.txt"));
			String line = reader.readLine();
			line = reader.readLine();
			while(line != null)
			{
				Card card = new Card(line);
				deck.add(card);
				line = reader.readLine();
			}
			reader.close();
			return deck;
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private static ArrayList<Player> setUpPlayers(int numPlayers)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		Player player = new Player();
		players.add(player);
		for(int i = 0; i < numPlayers; i++)
		{
			AIPlayer aiPlayer = new AIPlayer();
			players.add(aiPlayer);
		}
		return players;
	}
	
	public static void printPlayerDeckSizes()
	{
		for (int i = 0; i < players.size(); i++)
		{
			String text = "";
			if (i == 0)
				text = "You have " + players.get(i).getDeckSize() + " cards.";
			else if (i > 0)
				text = "Player " + (i+1) + " has " + players.get(i).getDeckSize() + " cards.";
			System.out.println(text);
		}
	}
	
	private static void divideDeck()
	{
		int i = 0;
		for(Card card : deck)
		{
			players.get(i % numberPlayers).addCardToDeck(card);
			i++;			
		}
	}
	
	public static void checkAttributeInput(String attribute)
	{
		if (attribute.equals("exit") || attribute.equals("quit"))
		{
			System.out.println("You chose to exit the program.");
			System.exit(0);
		}
		else if (attribute.equals("size") || attribute.equals("speed") || attribute.equals("range") || attribute.equals("firepower") || attribute.equals("cargo"))
		{
			valid = true;
			System.out.println("You picked " + attribute);
		}
		else valid = false;
	}

}
