package commandline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
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
	private static int numberPlayers, gamesPlayed;
	private static ArrayList<Player> players;
	
	//for the debug test log
	
	private static boolean logMode;
	private static TestLog log;
	
	public static void main(String[] args) 
	{

		//logMode = true;
		logMode = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) logMode=true; // Command line selection
		
		// States
		
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the application
		boolean gameOver = false; // flag to check whether the current game has finished (only one player left)
		
		// build the deck from the text file
		
		deck = buildDeck();
		
		if (logMode)
		{
			// create a new log and log the deck in its current state
			log = new TestLog();
			//'false' means the deck hasn't been shuffled yet
			log.logDeck(deck, false);
		}
		
		//create a new empty ArrayList for the communal deck
		
		communalDeck = new ArrayList<Card>();
		
		// shuffle the deck and log its contents
		
		Collections.shuffle(deck);
		if(logMode)
			log.logDeck(deck, true);
		
		// set up the players and divide deck between them
		
		Scanner scanner = new Scanner(System.in);
		players = setUpPlayers(scanner);
		divideDeck();
		
		// select a random player to serve as the current player
		
		int currentPlayer = new Random().nextInt(numberPlayers);
		int round = 0;
		
		// Loop until the user wants to exit the game (main game loop)
		
		while (!userWantsToQuit) 
		{
			
			// loop through list of players, assigning next player the current player for the round
			
			//currentPlayer = (currentPlayer + round) % numberPlayers;
			
			// increment round counter and display round details
			
			round++;
			System.out.println("\nRound " + round);
			
			//log the current round
			
			if(logMode)
				log.logRound(round);
			
			//each player plays their top card
			
			ArrayList<Card> cardsInPlay = playNextHand();
			
			String attribute;
			if (players.get(currentPlayer) instanceof HumanPlayer)
			{
				System.out.println("Your Turn");
				HumanPlayer p = (HumanPlayer) players.get(currentPlayer);
				attribute = p.playerSelectAttribute(scanner);
			} 
			else
			{
				//have to cast the player to AIPlayer
				AIPlayer p = (AIPlayer) players.get(currentPlayer);
				attribute = p.pickAttribute();
				String name = p.getName();
				System.out.println(name + "'s Turn");
				System.out.println(name + " picked " + attribute);
			}
			
			//log the selection
			
			if(logMode)
				log.logSelection(players.get(currentPlayer), attribute, cardsInPlay);
			
			//print out each players selection
			
			for(int i = 1; i < players.size(); i++)
			{
				AIPlayer p = (AIPlayer) players.get(i);
				System.out.print(p.getName() + " plays ");
				p.printCardInPlay();
			}
			
			//create a list of the winners of that round
			
			ArrayList<Player> winners = compareCards(attribute);
			
			//if there is only 1 winner, they win that round and get all cards in play + in communal deck
			
			if (winners.size() == 1)
			{
				Player winner = winners.get(0);
				int newCards = cardsInPlay.size() + communalDeck.size();
				winner.addHandToDeck(cardsInPlay);
				winner.addHandToDeck(communalDeck);
				
				currentPlayer = players.indexOf(winner);
				
				//log changes to communal deck if any
				if(logMode && communalDeck.size() > 0)
					log.logCommunalDeck();
				
				//check if winner is human player or ai player
				if (winner instanceof HumanPlayer)
				{
					System.out.println("You win round " + round);
					System.out.println(newCards + " added to your hand");
				} 
				else
				{
					AIPlayer w = (AIPlayer) winner;
					System.out.println(w.getName() + " wins round " + round);
					System.out.println(newCards + " added to " + w.getName() +"'s hand");
				}
				
				//log the winner of the round
				if(logMode)
					log.logRoundWinner(winner, round);
				
				//reset the communal deck
				communalDeck = new ArrayList<Card>();
			}
			//if the round is a draw
			else
			{
				communalDeck.addAll(cardsInPlay);
				
				//log draw and changes to communal deck
				if(logMode)
				{
					log.logRoundDraw(winners, round);
					log.logCommnalDeck(cardsInPlay, communalDeck);
				}
					
				System.out.print("Draw between ");
				int i = 0;
				//check if instance of human player
				//because the human player is always added to this list first
				// we only need to check at index 0 for a human
				if (winners.get(0) instanceof HumanPlayer)
				{
					System.out.print("You ");
					i++;
				}
				for (; i < winners.size(); i++)
				{
					AIPlayer p = (AIPlayer) winners.get(i);
					System.out.print(p.getName() + " ");
				}
				System.out.println("\n" + communalDeck.size() + " cards in communal deck");
			}
			
			//log the updated decks
			
			if(logMode)
				log.logAllocatedDecks(players);
			
			printRemainingCards();
			
			
		if ((gameOver) || checkWinConditions())
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
	
	
	private static ArrayList<Card> buildDeck() {
		//reads in the deck from the txt file
		ArrayList<Card> deck = new ArrayList<Card>();
		try
		{
			//I had to give the absolute path for this to work in command prompt
			// eg "C:\\Users\\Roddy\\workspace\\Trumps\\StarCitizenDeck.txt"
			BufferedReader reader = new BufferedReader(new FileReader("StarCitizenDeck.txt"));
		
			
			String line = reader.readLine();
			//skip the first line because it is just the names of attributes
			//will maybe read this line in and change card constructor
			//so decks with more/less/different attributes can be used
			line = reader.readLine();
			while (line != null)
			{
				//read each line in and create new card
				Card card = new Card(line);
				deck.add(card);
				line = reader.readLine();
			}
			reader.close();
			//return the built deck as and arraylist of cards
			return deck;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static ArrayList<Player> setUpPlayers(Scanner scanner) {
		//create an arraylist for players and add a human player
		ArrayList<Player> players = new ArrayList<Player>();
		Player player = new HumanPlayer();
		players.add(player);
		numberPlayers = 1;
		//prompt the user to enter number of ai players
		while (numberPlayers < 2 || numberPlayers > 5)
		{
			try
			{
				System.out.println("How many opponents (1-4)");
				int aiplayers = Integer.parseInt(scanner.nextLine());
				numberPlayers = 1 + aiplayers;
			} catch (Exception e)
			{
				//this catch handles any integer parsing errors (eg user enters "two" instead of 2 etc)
				//by re-prompting the user
				//probably not good practice to handle any and all exceptions by ignoring them
				//but this can be fixed later
				continue;
			}
		}
		for (int i = 1; i < numberPlayers; i++)
		{
			//create new ai players with the names ai player1, ai player2, etc
			//and adds to players list
			String name = String.format("AI Player %d", i);
			AIPlayer aiPlayer = new AIPlayer(name);
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
	
	private static void divideDeck() {
		//sequentially divides the deck among players
		//not the most efficient way of doing it but it works and was easy to implement
		int i = 0;
		for (Card card : deck)
		{
			players.get(i % numberPlayers).addCardToDeck(card);
			i++;
		}
	}
	
	private static boolean checkWinConditions()
	{
		//checks if a player is out of cards
		//if so removes them from play
		//if there is only 1 player left game is over and remaining player is winner
		//if there are no players left game is over and results in a draw
		//should be called at the end of each round
		boolean gameOver = false;
		
		for(int i = 0; i < numberPlayers; i++)
		{
			Player p = players.get(i);
			if(p.getDeckSize() == 0)
			{
				if(p instanceof HumanPlayer)
				{
					System.out.println("You have no cards remaining");
				}
				else
				{
					AIPlayer player = (AIPlayer) p;
					System.out.println(player.getName() + " has no cards remaining");
				}
				
				//remove players with no cards and decrement number of players
				players.remove(p);
				numberPlayers--;

				//log player eliminations
				if(logMode)
					log.logEliminatedPlayer(p);
			}
		}		
		
		if(players.size() == 1)
		{
			gameOver = true;
			System.out.println("Game Over");
			//log game winner
			if(logMode)
				log.logGameWinner(players.get(0));
			if(players.get(0) instanceof HumanPlayer)
			{
				System.out.println("You Win!!!");
			}
			else
			{
				//cast to ai player and get player name
				AIPlayer p = (AIPlayer) players.get(0);
				System.out.println(p.getName() + " Wins");
			}
		}
		if(players.size() == 0)
		{
			gameOver = true;
			System.out.println("Draw");
			//log game draw
			//calling logWinner with no arguments logs a draw
			if(logMode)
				log.logWinner();
		}
		
		//if the game is over, write the log to file
		if(gameOver && logMode)
			log.writeLog();
		
		//return true if game is over, false if multiple players remain
		return gameOver;
	}
	
	private static void printRemainingCards() {
		for (Player p : players)
		{
			if (p instanceof HumanPlayer)
			{
				System.out.println("You have " + p.getDeckSize() + " cards remaining");
			} else
			{
				//have to cast to ai player
				AIPlayer q = (AIPlayer) p;
				System.out.println(q.getName() + " has " + p.getDeckSize() + " cards remaining");
			}
		}
	}
	

	public static ArrayList<Card> playNextHand() {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Player p : players)
		{
			cards.add(p.playCard());
		}

		System.out.println(cards.size() + " cards in play");
		if (players.get(0) instanceof HumanPlayer)
		{
			System.out.println("Your Card:");
			players.get(0).printCardInPlay();
		}
		if(logMode)
			log.logCardsInPlay(cards);
		return cards;
	}
	
	private static ArrayList<Player> compareCards(String attribute) {
		ArrayList<Player> winners = new ArrayList<Player>();
		int max = 0;
		//find the max value for the chosen attribute for all cards in play
		for (Player p : players)
		{
			if (p.getValueOfAtt(attribute) > max)
				max = p.getValueOfAtt(attribute);
		}
		//get all players whose card has that value for the attribute
		//and add them to the list of winners
		for (Player p : players)
		{
			if (p.getValueOfAtt(attribute) == max)
				winners.add(p);
		}
		//return the winners as an arraylist of players
		return winners;
	}

}