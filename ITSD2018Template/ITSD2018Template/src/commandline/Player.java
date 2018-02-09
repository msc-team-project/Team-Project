package commandline;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Player {
	
	private ArrayList<Card> deck;
	protected Card cardInPlay;
	private int roundsWon;
	public String name;
	
	public Player(){
		deck = new ArrayList<Card>();
		roundsWon = 0;
	}
	
	/**
	 * Adds Card to the back of the Player object's hand
	 * @param card the Card to be added
	 */
	public void addCardToDeck(Card card)
	{
		deck.add(card);
	}
	
	/**
	 * Shuffles and adds an ArrayList of Card Objects
	 * to the Player's current deck
	 * @param hand the cards to be added to the deck
	 */
	public void addHandToDeck(ArrayList<Card> hand)
	{
		Collections.shuffle(hand);
		deck.addAll(hand);
	}
	
	/**
	 * Removes the first Card object from the Player 
	 * object's deck and stores a reference to this
	 * in cardInPlay
	 * @return Card
	 */
	public Card playCard()
	{
		cardInPlay = deck.remove(0);
		return cardInPlay;
	}
	
	/**
	 * Abstract method for selecting a Card attribute
	 * @see
	 * @see
	 */
	public abstract String pickAttribute();
	
	/**
	 * @return reference to current Card in play
	 * for this Player object
	 */
	public Card getCardInPlay(){
		return cardInPlay;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getDeckSize()
	{
		return deck.size();
	}
	
	/** returns reference to the Player's current deck<br>
	 * required for testLog
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	/** shortcut to increment roundsWon after a round is won by the Player*/
	public void incrementRoundsWon(){
		roundsWon++;
	}
	
	public int getRoundsWon(){
		return roundsWon;
	}
	
	/**
	 * Prints attributes of the Player's current
	 * card to standard output stream
	 */
	public void printCardInPlay()
	{
		System.out.println(cardInPlay.getDescription() + " [" + 
							"size: " + cardInPlay.getSize() + 
							" speed: " + cardInPlay.getSpeed() +
							" range: " + cardInPlay.getRange() +
							" firepower: " + cardInPlay.getFirepower() +
							" cargo: " + cardInPlay.getCargo() + "]");
	}
	
	/**
	 * creates a log entry for the Player's current deck
	 * @return String containing log entry
	 */
	public String logDeck()
	{
		String log = "";
		for(Card c : deck)
		{
			log += c.getDescription() + " [" + 
					"size:" + c.getSize() + 
					" speed:" + c.getSpeed() +
					" range:" + c.getRange() +
					" firepower:" + c.getFirepower() +
					" cargo:" + c.getCargo() + "]\n";
		}
		return log;
	}
	
}