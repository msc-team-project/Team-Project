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
	private static ArrayList<Card> deck, communalDeck;
	/** maintains a count of the number of players currently active in the game */
	private static int numberPlayers;
	
	/** list of all players added at the beginning of the game */
	private static ArrayList<Player> allPlayers;
	/** list of all players not yet eliminated from play */
	private static ArrayList<Player> players;
	
	protected static Scanner scanner;
	
	/** whether the user is in debug mode */
	private static boolean writeGameLogsToFile;
	
	private static TestLog log;
	
	/** the current round */
	private static int round;
	/** maintains a count of the draws in a single game */
	private static int draws;
	
	/** the name of the overall winner */
	private static String winner;
	
	/** whether the user wants to skip to their next turn */
	private static boolean skip;

	/**
	 * This main method is called by TopTrumps.java when the user specifies that they want to run in
	 * command line mode. 
 	 * @param args The contents of args[0] is whether we should write game logs to a file.
	 */
	public static void main(String[] args) 
	{

		writeGameLogsToFile = false; // Should we write game logs to file?
		if (args[0].equalsIgnoreCase("true")) writeGameLogsToFile=true; // Command line selection
		
		scanner = new Scanner(System.in);
		
		//prompt the user to either play the game, view stats or exit the game
		while(true)
		{
			String message = "";
			if(round > 0)
				message = " again";
			System.out.println("type 'play' to play" + message + ", 'stats' for stats, 'exit' to exit");
			String s = scanner.nextLine();
			if(s.equals("play"))
				playGame();
			if(s.equals("stats"))
				printStats();
			if(s.equals("exit"))
				System.exit(0);
		}
	}
	
	/**
	 * Sets up the game and contains the main game loop
	 */
	private static void playGame()
	{
		boolean userWantsToQuit = false; // flag to check whether the user wants to quit the game
		boolean gameOver = false; // flag to check whether the current game has finished
		skip = false;
		
		// build the deck from the text file
		deck = buildDeck();
		
		if (writeGameLogsToFile)
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
		if(writeGameLogsToFile)
			log.logDeck(deck, true);
		
		
		// set up the players and divide deck between them
		players = setUpPlayers();
		//maintains list of all players including those eliminated
		allPlayers = new ArrayList<Player>(players);
		divideDeck();
		
		// initialise round number and draws count to 0
		round = 0;
		draws = 0;
		
		// select a random player to begin the game
		int startPlayer = new Random().nextInt(numberPlayers);
		Player currentPlayer = players.get(startPlayer);
		
		//the main game loop
		while (!userWantsToQuit) 
		{
			// increment round counter and display round details
			round++;
			System.out.println("\nRound " + round);
			
			//log the current round
			if(writeGameLogsToFile)
				log.logRound(round);
			
			//each player plays their top card
			ArrayList<Card> cardsInPlay = playNextHand();
			
			// this will store the chosen attribute for this round
			String attribute;
			
			//if current player is the human player inform them
			//and prompt them to pick an attribute via the scanner input
			//user can quit the game by entering 'exit'
			if (currentPlayer instanceof HumanPlayer)
			{
				skip = false;
				System.out.println("Your Turn");
				attribute = currentPlayer.pickAttribute();
				//if the user quits in debug mode invoke TestLog to make a log entry
				if(attribute.equals("exit"))
				{
					if(writeGameLogsToFile)
					{
						log.logUserQuit();
						log.writeLog();
					}
					userWantsToQuit = true;
					continue;
				}
			}
			//if the current player is AI invoke AIPlayer.pickAttribute() on the current
			//player and print the selection to screen
			else
			{
				attribute = currentPlayer.pickAttribute();
				String name = currentPlayer.getName();
				System.out.println(name + "'s Turn");
				System.out.println(name + " picked " + attribute);
			}
			
			//log the selection
			if(writeGameLogsToFile)
				log.logSelection(currentPlayer, attribute, cardsInPlay);
			
			//print each player's selection to standard out
			for(int i = 1; i < players.size(); i++)
			{
				Player p = players.get(i);
				System.out.print(p.getName() + " plays ");
				p.printCardInPlay();
			}
			
			//create a list of the winners of that round
			ArrayList<Player> winners = compareCards(attribute);
			
			//if there is only 1 winner, they win that round and get all cards in play + in communal deck
			if (winners.size() == 1)
			{
				Player winner = winners.get(0);
				currentPlayer = winner;
				int newCards = cardsInPlay.size() + communalDeck.size();
				winner.addHandToDeck(cardsInPlay);
				winner.addHandToDeck(communalDeck);
				
				winner.incrementRoundsWon();
				
				//log changes to communal deck if any
				if(writeGameLogsToFile && communalDeck.size() > 0)
					log.logCommunalDeck();
				
				//check if winner is human player or ai player
				if (winner instanceof HumanPlayer)
				{
					System.out.println("You win round " + round);
					System.out.println(newCards + " added to your hand");
				} 
				else
				{
					System.out.println(winner.getName() + " wins round " + round);
					System.out.println(newCards + " added to " + winner.getName() +"'s hand");
				}
				
				//log the winner of the round
				if(writeGameLogsToFile)
					log.logRoundWinner(winner, round);
				
				//reset the communal deck
				communalDeck = new ArrayList<Card>();
			}
			//if the round is a draw
			else
			{
				draws++;
				communalDeck.addAll(cardsInPlay);
				
				//log draw and changes to communal deck
				if(writeGameLogsToFile)
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
				// get the names of all AIPlayer's in the draw
				for (; i < winners.size(); i++)
				{
					System.out.print(winners.get(i).getName() + " ");
				}
				System.out.println("\n" + communalDeck.size() + " cards in communal deck");
			}
			
			//log the updated decks
			if(writeGameLogsToFile)
				log.logAllocatedDecks(players);
			
			//display the number of cards remaining in each player's repective deck
			printRemainingCards();
			
			//if the user has not chosen to skip to their turn
			//prompt them to advance to the next round
			//or skip to their next turn
			//the user can quit the game by entering 'quit'
			if(!skip)
			{
				String response = waitForUser();
				if(response.equals("skip"))
					skip = true;
				else if(response.equals("quit"))
					break;
			}
				
			
			//if the round is over, write the log to file
			if(writeGameLogsToFile)
				log.writeLog();
			
			if ((gameOver) || checkWinConditions())
			{
				//update the database
				DataBaseCon.inputGameInfo(round, draws, allPlayers, winner);
				//exit the main game loop
				break;
			}
		}
	}
	
	/**
	 * Reads the deck from StarCitizenDeck.txt <br>
	 * Stores each card as a Card object in an ArrayList of Cards
	 * @return an ArrayList of all cards in the text file
	 */
	private static ArrayList<Card> buildDeck() {
		
		//an ArrayList to store all Cards
		ArrayList<Card> deck = new ArrayList<Card>();
		try
		{
			//open the text file
			BufferedReader reader = new BufferedReader(new FileReader("StarCitizenDeck.txt"));
			
			//skip the first line because it is just the names of attributes
			String line = reader.readLine();
			
			//read the file line by line
			line = reader.readLine();
			while (line != null)
			{
				//create a new Card for each line
				Card card = new Card(line);
				deck.add(card);
				line = reader.readLine();
			}
			reader.close();
			//return the built deck as and arraylist of cards
			return deck;
		} catch (IOException e)
		{
			System.out.println("Could not read \"StarCitizenDeck.txt\"");
			System.exit(0);
			return null;
		}
	}

	/**
	 * Prompts the user to enter the desired number of AI opponents <br>
	 * Creates player objects for each player in an ArrayList
	 * @return ArrayList of players
	 */
	private static ArrayList<Player> setUpPlayers() {
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
			} catch (NumberFormatException e)
			{
				//this catch handles integer parsing errors by re-prompting the user
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
	
	/**
	 * Divides the deck of all cards among players in the players ArrayList
	 */
	private static void divideDeck() {
		//sequentially divides the deck among players
		int i = 0;
		for (Card card : deck)
		{
			players.get(i % numberPlayers).addCardToDeck(card);
			i++;
		}
	}
	
	/**
	 * Checks which players are out of cards and eliminates them from play
	 * then checks the number of remaining players. <br>
	 * If there is only one player left they are declared the winner <br>
	 * If all remaining players are eliminated the game is declared a draw
	 * @return boolean representing whether the game is over according to
	 * the win conditions
	 */
	private static boolean checkWinConditions()
	{
		//checks if a player is out of cards
		//if so removes them from play
		//if there is only 1 player left game is over and remaining player is winner
		//if there are no players left game is over and results in a draw
		//should be called at the end of each round
		boolean gameOver = false;
		for(Player p : allPlayers)
		{
			if(p.getDeckSize() == 0)
			{
				if(p instanceof HumanPlayer)
				{
					System.out.println("You have no cards remaining");
				}
				else
				{
					System.out.println(p.getName() + " has no cards remaining");
				}
				
				//log player eliminations
				if(writeGameLogsToFile && players.contains(p))
					log.logEliminatedPlayer(p);
				
				//remove players with no cards and decrement number of players
				players.remove(p);
				numberPlayers--;
			}
		}		
		
		// a player has won the game
		if(players.size() == 1)
		{
			gameOver = true;
			System.out.println("Game Over");
			//log game winner
			if(writeGameLogsToFile)
				log.logGameWinner(players.get(0));
			if(players.get(0) instanceof HumanPlayer)
			{
				System.out.println("You Win!!!");
				winner = "Player";
			}
			else
			{
				//cast to ai player and get player name
				winner = players.get(0).getName();
				System.out.println(winner + " Wins");				
			}
		}
		//the game is a draw
		if(players.size() == 0)
		{
			gameOver = true;
			System.out.println("Draw");
			//log game draw
			//calling logWinner with no arguments logs a draw
			if(writeGameLogsToFile)
				log.logWinner();
		}
		
		//if the game is over, write the log to file
		if(gameOver && writeGameLogsToFile)
			log.writeLog();
		
		//return true if game is over, false if multiple players remain
		return gameOver;
	}
	
	/**
	 * Prompts the user to advance to the next round or
	 * skip to their next turn
	 * @return String containing the users response
	 */
	public static String waitForUser(){
		String message = "Press \"ENTER\" to continue";
		if(skip == false)
			message += " or type 'skip' to skip to your next turn";
		System.out.println(message);
		return scanner.nextLine();
			   		   
	}
	
	private static void printRemainingCards() {
		for (Player p : players)
		{
			if (p instanceof HumanPlayer)
			{
				System.out.println("You have " + p.getDeckSize() + " cards remaining");
			} else
			{
				System.out.println(p.getName() + " has " + p.getDeckSize() + " cards remaining");
			}
		}
	}
	
	/**
	 * prints out the number of cards in each active player's respective deck
	 */
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
		if(writeGameLogsToFile)
			log.logCardsInPlay(cards);
		return cards;
	}
	
	/**
	 * Compares the chosen attribute of all cards in play to determine round winner
	 * @param attribute String representing the name of the chosen attribute
	 * @return ArrayList of players with the maximum value for the chosen attribute
	 */
	private static ArrayList<Player> compareCards(String attribute) {
		ArrayList<Player> winners = new ArrayList<Player>();
		int max = 0;
		//find the max value for the chosen attribute for all cards in play
		for (Player p : players)
		{
			if (p.getCardInPlay().getValueOfAtt(attribute) > max)
				max = p.getCardInPlay().getValueOfAtt(attribute);
		}
		//get all players whose card has that value for the attribute
		//and add them to the list of winners
		for (Player p : players)
		{
			if (p.getCardInPlay().getValueOfAtt(attribute) == max)
				winners.add(p);
		}
		//return the winners as an arraylist of players
		return winners;
	}

	/**
	 * Print stats from the database to the command line interface
	 */
	public static void printStats(){
		DataBaseCon.connect();
		System.out.println(String.format("Number of games played overall: %d", DataBaseCon.numGames()));
		System.out.println(String.format("How many times the computer has won: %s", DataBaseCon.aiWins()));
		System.out.println(String.format("How many times the human has won: %s", DataBaseCon.humanWins()));
		System.out.println(String.format("The average number of draws: %.1f ", DataBaseCon.avgDraws()));
		System.out.println(String.format("The largest number of rounds played in a single game: %d", DataBaseCon.maxRounds()));
		DataBaseCon.close();
	}
	
}
