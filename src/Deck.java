package src;

import java.util.ArrayList;
import java.util.Collections;


public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		topCardIndex = 51;
		stackOfCards = new ArrayList<Card>();
		addCards();
	}

	//modifiers
	public void addCards(){
		for(int i = 0; i < NUMSUITS; i++ ){
			for(int j=0; j < NUMFACES; j++){
				stackOfCards.add(new BlackJackCard(j, SUITS[i]));
			}
		}
	}
    public void shuffle ()
	{
		//shuffle the deck
		//reset variables as needed
		Collections.shuffle(stackOfCards);
	}

   //accessors
	public int  size ()
	{
		return stackOfCards.size();
	}

	public int numCardsLeft()
	{
		return topCardIndex + 1;
	}

	public Card nextCard()
	{
		try {
			return stackOfCards.get(topCardIndex--);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("deck empty, adding cards");
			addCards();
			shuffle();
			topCardIndex = 51;
			return stackOfCards.get(topCardIndex--);

		}
		
		
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}