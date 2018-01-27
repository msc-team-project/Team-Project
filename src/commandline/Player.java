package commandline;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Player {
	
	private ArrayList<Card> deck;
	protected Card cardInPlay;
	public int roundsWon;
	public String name;
	
	public Player(){
		deck = new ArrayList<Card>();
		roundsWon = 0;
	}
	
	public void addCardToDeck(Card card)
	{
		deck.add(card);
	}
	
	//decided to shuffle hands when adding them to the players deck after
	//a round win so that the order of a players cards cannot be determined
	public void addHandToDeck(ArrayList<Card> hand)
	{
		Collections.shuffle(hand);
		deck.addAll(hand);
	}
	
	//removes the first card from the player's deck and returns it
	//to Game.cardsInPlay
	public Card playCard()
	{
		cardInPlay = deck.remove(0);
		return cardInPlay;
	}
	
	public abstract String pickAttribute();
	
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
	
	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void printCardInPlay()
	{
		System.out.println(cardInPlay.getDescription() + " [" + 
							"size: " + cardInPlay.getSize() + 
							" speed: " + cardInPlay.getSpeed() +
							" range: " + cardInPlay.getRange() +
							" firepower: " + cardInPlay.getFirepower() +
							" cargo: " + cardInPlay.getCargo() + "]");
	}
	
	public void printDeck()
	{
		for(Card c : deck)
			System.out.println(c.getDescription());
	}
	
	//creates a log entry for the players current deck
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