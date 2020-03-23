package src;


//define Dealer class here
public class Dealer extends AbstractPlayer{
	
	//instance variable - Deck 
	private Deck deck;

	//constructors
	public Dealer(){
		super();
		deck = new Deck();
		setName("Dealer");
	}

	//method to shuffle
	public void shuffle(){
		deck.shuffle();
	}


	//method to deal a card
	public Card deal(){
		return deck.nextCard();
	}

	//hit method goes here
	public boolean hit(){
		if(getHandValue() <= 16){return true;}
		else {return false;}
	}
}
