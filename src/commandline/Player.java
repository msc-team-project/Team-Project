package commandline;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private ArrayList<Card> deck;
	protected Card cardInPlay;
	public int roundsWon;
	
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
	
	//TODO
	//this will be moved to the AIPlayer class as there is no need for
	//HumanPlayer to inherit this behaviour
	//just was too lazy and didn't want to change the code
	public String pickAttribute()
	{
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
	
	//TODO
	//this has been moved to the Card class
	//should be accessed with Player.getCardInPlay().getValueOfAtt()
	//will remove this and update code
	public int getValueOfAtt(String att)
	{
		switch(att)
		{
		case "size":
			return cardInPlay.getSize();
		case "speed":
			return cardInPlay.getSpeed();
		case "range":
			return cardInPlay.getRange();
		case "firepower":
			return cardInPlay.getFirepower();
		case "cargo":
			return cardInPlay.getCargo();
		}
		return -1;
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