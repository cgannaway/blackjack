package src;
import static java.lang.System.*;
import java.util.Scanner;



//define Player class here 
public class Player extends AbstractPlayer{

	Scanner playerScanner;
	private String hitchar = "0";
	//constructors
	public Player(){
		super();
		playerScanner = new Scanner(System.in);
	}
	public Player(String n){
		super();
		playerScanner = new Scanner(System.in);
		setName(n);
	}

	
	
	
	public boolean hit(){
		System.out.println("\nPress 0 to hit, or anything else to stand");
		if(playerScanner.nextLine().equals(hitchar)) {return true;}
		else{ return false;}
	}
}
