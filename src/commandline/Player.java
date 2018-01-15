package commandline;

import java.util.ArrayList;

public class Player {
	
	private ArrayList<Card> deck;
	private Card cardInPlay;
	
	public Player(){
		deck = new ArrayList<Card>();
	}
	
	public void addCardToDeck(Card card)
	{
		deck.add(card);
	}
	
	public void addHandToDeck(ArrayList<Card> hand)
	{
		deck.addAll(hand);
	}
	
	public Card playCard()
	{
		cardInPlay = deck.remove(0);
		return cardInPlay;
	}
	
	public String pickAttribute()
	{
		String[] atts = {"size", "speed", "range", "firepower", "cargo"};
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
	
	public void printDeck()
	{
		for(Card c : deck)
		{
			String playtext = String.format("%s (Size: %d Speed: %d Range: %d Firepower: %d Cargo: %d)", c.getDescription(), c.getSize(), c.getSpeed(), c.getRange(), c.getFirepower(), c.getCargo());
			System.out.println(playtext);
		}
	}
	
}
