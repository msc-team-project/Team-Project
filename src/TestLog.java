import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

//this is the class for creating a log of the game
//if you are using it you need to create a new log in the command line game class
//create a new log with: new TestLog(); - no parameters required

//you need to call the writeLog() function at the end of the game for the log to be written to file
//you should only call writeLog once



public class TestLog {

	private String log;
	
	public TestLog(){
		log = "";
	}
	
	int countRounds=0;
	int[] roundWins = {0,0,0,0,0};
	String winName ="";
	//logs "The contents of the complete deck once it has been read in and constructed"
	//and "The contents of the complete deck after it has been shuffled"
	//
	//call this with the deck and shuffled = false after the deck has been read from file
	//call this with the deck and shuffled = true after the deck has been shuffled
	public void logDeck(ArrayList<Card> deck, boolean shuffled)
	{
		if(!shuffled)
			log += String.format("DECK CONTENTS%n");
		else
			log += String.format("SHUFFLED DECK%n");
		for(Card c : deck)
		{
			log += String.format("%s%n", c.getDescription());
		}
		lineBreak();
	}
	
	//"The contents of the user’s deck and the computer’s deck(s) once they have been allocated. Be sure to
	//indicate which the user’s deck is and which the computer’s deck(s) is."
	//and
	//"The contents of each deck after a round"
	//
	//call this after divideDeck() and at the end of each round
	//the arraylist of players should be given as the parameter
	public void logAllocatedDecks(ArrayList<Player> players)
	{
		log += String.format("ALLOCATED DECKS%n%n");
		log += String.format("USER DECK%n");
		Player p = players.get(0);
		ArrayList<Card> deck = p.getDeck();
		for(Card c : deck)
			log += String.format("%s%n", c.getDescription());
		for(int i = 1; i < players.size(); i++)
		{
			AIPlayer ai = (AIPlayer) players.get(i);
			log += String.format("%n%s's DECK%n", ai.getName().toUpperCase());
			deck = ai.getDeck();
			for(Card c : deck)
				log += String.format("%s%n", c.getDescription());
		}
		lineBreak();
	}
	
	//"The contents of the communal pile when cards are added or removed from it"
	//when cards are added
	//call this after a round draw
	public void logCommnalDeck(ArrayList<Card> cardsInPlay, ArrayList<Card> communalDeck){
		log += String.format("%nCOMMUNAL DECK UPDATED%n");
		for(Card c : cardsInPlay)
			log += c.getDescription() + " ";
		log += String.format("ADDED TO COMMUNAL DECK%n");
		log += String.format("COMMUNAL DECK NO CONTAINS %d CARDS:%n", communalDeck.size());
		for(Card c : communalDeck)
			log += c.getDescription() + " ";
		lineBreak();
	}
	
	//"The contents of the communal pile when cards are added or removed from it"
	//when cards are removed
	//call this after a round won if there are cards in the communal deck
	public void logCommunalDeck()
	{
			log += String.format("%nCOMMUNAL DECK UPDATED%nCOMMUNAL DECK NOW EMPTY");
			lineBreak();
	}
	
	//"The contents of the current cards in play"
	//call this after playNextHand()
	public void logCardsInPlay(ArrayList<Card> cardsInPlay)
	{
		log += String.format("%nCARDS IN PLAY%n");
		for(Card c : cardsInPlay)
		{
			log += String.format("%s%n", c.getDescription());
		}
		lineBreak();
	}
	
	//"The category selected and corresponding values when a user or computer selects a category"
	//call this after a player selects an attribute
	public void logSelection(Player player, String attribute, ArrayList<Card> cardsInPlay)
	{
		if(player instanceof HumanPlayer)
			log += String.format("%nUSER SELECTS %s%n", attribute);
		else
		{
			AIPlayer p = (AIPlayer) player;
			log += String.format("%n%s SELECTS %s%n", p.getName().toUpperCase(), attribute);
		}
		for(Card c : cardsInPlay)
		{
			log += String.format("%n%s : %s %d", c.getDescription(), attribute, c.getValueOfAtt(attribute));
		}
		lineBreak();
	}
	
	//logs when a player is eliminated from the game
	public void logEliminatedPlayer(Player p)
	{
		if(p instanceof HumanPlayer)
			log += String.format("%nUSER ELIMINATED");
		else
		{
			AIPlayer player = (AIPlayer) p;
			log += String.format("%n%s ELIMINATED", player.getName().toUpperCase());
		}
		lineBreak();
	}
	
	//log "The winner of the game"
	public void logGameWinner(Player p){
		
		if(p instanceof HumanPlayer) {
			log += String.format("%nUSER WINS GAME");
			winName ="Human";
		}
		else
		{
			AIPlayer ai = (AIPlayer) p;
			log += String.format("%n%s WINS GAME", ai.getName().toUpperCase());
			winName = ai.getName();
		}
		lineBreak();
	}
	
	//log the winner of a round
	public void logRoundWinner(Player player, int round){
		if(player instanceof HumanPlayer)
			log += String.format("%nUSER WINS ROUND %d", round);
		else
		{
			AIPlayer ai = (AIPlayer) player;
			log += String.format("%n%s WINS ROUND %d", ai.getName().toUpperCase(), round);
			String win = ai.getName();
			if(win.equals("ai player1"))
			{
				roundWins[1]=roundWins[1]+1;
			}
			else if(win.equals("ai player2"))
			{
				roundWins[2]=roundWins[2]+1;
			}
			else if(win.equals("ai player3"))
			{
				roundWins[3]=roundWins[3]+1;
			}
			else if(win.equals("ai player4"))
			{
				roundWins[4]=roundWins[4]+1;
			}
		
		}
		lineBreak();
	}
	
	//logs a round draw
	public void logRoundDraw(ArrayList<Player> winners, int round){
		log += String.format("ROUND %d DRAW BETWEEN ", round);
		int i = 0;
		if (winners.get(0) instanceof HumanPlayer)
		{
			log += "USER ";
			i++;
		}
		for (; i < winners.size(); i++)
		{
			AIPlayer p = (AIPlayer) winners.get(i);
			log += String.format("%s ", p.getName().toUpperCase());
		}
		lineBreak();
	}
	
	//logs a game draw if there are no winners
	public void logWinner(){
		log += String.format("%nDRAW");
		lineBreak();
	}
	
	//log each round number
	//call this at the beginning of each round before the cards are played
	public void logRound(int round){
		countRounds++;
		log += String.format("ROUND %d", round);
		lineBreak();
	}
	
	//separates log entries with dashed line
	private void lineBreak()
	{
		log += String.format("%n");
		for(int i = 0; i < 25; i++)
			log += "-";
		log += String.format("%n");
	}
	
	//writes the log to file
	//call this at the end of the game
	public void writeLog(){
		try
		{
			FileWriter writer = new FileWriter("toptrumps.log");
			writer.write(log);
			writer.close();
			System.out.println("log saved to toptrumps.log");
			
			DataBaseCon.inputGameInfo(winName, countRounds, roundWins);

			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}