
import static java.lang.System.*;
import java.awt.Color;

public class DeckTestOne
{
	public static void main( String args[] )
	{
		Deck deck = new Deck();	
		
		out.println("\n\nshuffling");
		deck.shuffle();
		out.println("num cards left in the deck == " + deck.numCardsLeft());
		
		
		out.println("\n\ntoString");
		out.println(deck);
		
		
		out.println("\n\n" + deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());
		out.println(deck.nextCard());


	}
}