package src;

public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

	  //constructors
	public Card(){
		setFace(0);
	}
	public Card(int f){
		setFace(f);
	}
	public Card(String s){
		setSuit(s);
	}
	public Card(int f, String s){
		setFace(f);
		setSuit(s);
	}

	// modifiers
	public void setFace(int f){
		face = f;
	}
	public void setSuit(String s){
		suit = s;
	}
 

  	//accessors
	public String getSuit(){
		return suit;
	}
	public int getFace(){
		return face;
	}
	

  	public abstract int getValue();


	  //toString
	public String toString(){
		return FACES[face] + " of " + getSuit() + " | value = " + getValue();
	}
  	
 }