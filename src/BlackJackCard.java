package src;


public class BlackJackCard extends Card
{
	  //constructors
	public BlackJackCard(){
		super();
	}
	public BlackJackCard(int face, String suit){
		super(face,suit);
	}
	public BlackJackCard(int face){
		super(face);
	}
	public BlackJackCard(String suit){
		super(suit);
	}


  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
		if(getFace() == 1){
			return 11;
		}
		else if(getFace() > 10){
			return 10;
		}
		else{
			return getFace();
		}
  	}
  	
 }