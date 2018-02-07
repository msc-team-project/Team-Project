package commandline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/** This class is for creating a log of the game  */
public class TestLog {

	/** The game log */
	private String log;
	
	public TestLog(){
		log = "";
	}
	
	/**
	 * logs "The contents of the complete deck once it has been read in and constructed"
	 * and "The contents of the complete deck after it has been shuffled"
	 * @param deck the complete game deck
	 * @param shuffled whether the deck has been shuffled
	 */
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
	
	/**
	 * logs "The contents of the user’s deck and the computer’s deck(s) once they have been allocated."
	 * and "which the user’s deck is and which the computer’s deck(s) is."<br>
	 * Should be called after divideDeck() and at the end of each round
	 * @param players the arraylist of players
	 */
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
	
	/**
	 * Logs "The contents of the communal pile when cards are added"
	 * <br> Call this after a round draw
	 * @param cardsInPlay
	 * @param communalDeck
	 */
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
	
	/**
	 * Logs "The contents of the communal pile when cards are removed"
	 * <br> Call this after a round won if there are cards in the communal deck
	 */
	public void logCommunalDeck()
	{
		log += String.format("%nCOMMUNAL DECK UPDATED%nCOMMUNAL DECK NOW EMPTY");
		lineBreak();
	}
	
	/**
	 * Logs "The contents of the current cards in play"
	 * <br> Call this after playNextHand()
	 * @param cardsInPlay
	 */
	public void logCardsInPlay(ArrayList<Card> cardsInPlay)
	{
		log += String.format("%nCARDS IN PLAY%n");
		for(Card c : cardsInPlay)
		{
			log += String.format("%s%n", c.getDescription());
		}
		lineBreak();
	}
	
	/**
	 * Logs "The category selected and corresponding values when a user or computer selects a category"
	 * <br> Call this after a player selects an attribute
	 * @param player the player who made the selection
	 * @param attribute the chosen attribute
	 * @param cardsInPlay all cards currently in play
	 */
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
	
	/**
	 * Logs when a player is eliminated from the game
	 * @param p The eliminated player
	 */
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
	
	/** Logs the winner of the game */
	public void logGameWinner(Player p){
		if(p instanceof HumanPlayer)
			log += String.format("%nUSER WINS GAME");
		else
		{
			AIPlayer ai = (AIPlayer) p;
			log += String.format("%n%s WINS GAME", ai.getName().toUpperCase());
		}
		lineBreak();
	}
	
	/** Logs the winner of a round */
	public void logRoundWinner(Player player, int round){
		if(player instanceof HumanPlayer)
			log += String.format("%nUSER WINS ROUND %d", round);
		else
		{
			AIPlayer ai = (AIPlayer) player;
			log += String.format("%n%s WINS ROUND %d", ai.getName().toUpperCase(), round);
		}
		lineBreak();
	}
	
	/** Logs a round draw */
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
	
	/** Logs a game draw if there are no winners */
	public void logWinner(){
		log += String.format("%nDRAW");
		lineBreak();
	}
	

	/** Logs each round number
	 * <br> Call this at the beginning of each round before the cards are played
	 * @param round the round number
	 */
	public void logRound(int round){
		log += String.format("ROUND %d", round);
		lineBreak();
	}
	
	/** separates log entries with dashed line */
	private void lineBreak()
	{
		log += String.format("%n");
		for(int i = 0; i < 25; i++)
			log += "-";
		log += String.format("%n");
	}
	

	/** Logs a user quit */
	public void logUserQuit(){
		log += "USER QUITS";
		lineBreak();
	}
	
	/** writes the log to file */
	public void writeLog(){
		try
		{
			FileWriter writer = new FileWriter("toptrumps.log");
			writer.write(log);
			writer.close();
			System.out.println("toptrumps.log updated");
		} catch (IOException e)
		{
			System.out.println("Error updating toptrumps.log");
		}
	}
}