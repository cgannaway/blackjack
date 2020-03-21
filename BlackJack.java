
import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
	private Player player;
	private Dealer dealer;
	private boolean playAgain = true;
	private Scanner kb;

	public BlackJack()
	{
		player = new Player();
		dealer = new Dealer();
		kb = new Scanner(System.in);

	}

	/**
	 * Main Game Loop
	 */
	public void playGame()
	{
		while(playAgain == true){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			ascii();
			dealer.resetHand();
			player.resetHand();

			dealer.shuffle();
			firstDeal();
			printPlayer();
			playerHits();
			
			dealerHits();
			printBoth();
			compareHands();
			gameOverHandler();
		}

	}
	
	/**
	 * initial deal
	 */
	public void firstDeal(){
		dealer.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());
	}

	/**
	 * Print Player Hand (for use before Dealer's turn)
	 */
	public void printPlayer(){
		System.out.println("\nHand Value : " + player.getHandValue());
		System.out.println("You have: " + player.getHand());
		System.out.println("\nDealer has: " + dealer.getSpecificCard(0) + "  and [hidden]");
	}

	/**
	 * Print both Player and Dealer hands. For use at end of game.
	 */
	public void printBoth(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		ascii();
		System.out.println("\n\nPlayer:");
		System.out.println("Value: " + player.getHandValue());
		System.out.println("Cards: " + player.getHand());
		System.out.println("\nDealer:");
		System.out.println("Value: " + dealer.getHandValue());
		System.out.println("Cards: " + dealer.getHand());
	}

	/**
	 * returns true if player has gone over 21
	 * @param obj player or dealer
	 */
	public boolean checkPlayer(Playerable obj){
		if(obj.getHandValue() >= 21){ return true;}
		else{return false;}
	}
	/**
	 * loop for player hit or stand
	 */
	public void playerHits(){
		while(true){
			if(checkPlayer(player) == true){
				break;
			}
			if(player.hit() == true){
				player.addCardToHand(dealer.deal());
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				ascii();
				printPlayer();
				if(checkPlayer(player) == true){
					break;
				}
			}
			else{
				break;
			}
		}
	}

	/**
	 * loop for dealer to hit or stand
	 */
	public void dealerHits(){
		while(true){
			if(checkPlayer(dealer) == true){
				break;
			}
			if(dealer.hit() == true){
				dealer.addCardToHand(dealer.deal());
				if(checkPlayer(dealer) == true){
					break;
				}
			}
			else{
				break;
			}
		}
	}

	/**
	 * print winner and add to win int
	 */
	public void compareHands(){
		int dv = dealer.getHandValue();
		int pv = player.getHandValue();

		//blackjacks
		if(pv == 21 && dv != 21){
			System.out.println("\nBlackjack! Player Wins");
		}
		else if(pv == 21 && dv == 21){
			System.out.println("\nBoth Players Blackjack! Tie!");
		}
		else if(pv != 21 && dv == 21){
			System.out.println("\nBlackjack! Dealer Wins");
		}
		//both bust
		else if(pv > 21 && dv > 21){
			System.out.println("\nTie! Both Bust");
		}
		//one busts
		else if(pv > 21 && dv <= 21){
			System.out.println("\nPlayer Bust, Dealer Wins!");
		}
		else if(pv <= 21 && dv > 21){
			System.out.println("\nDealer Bust, Player Wins!");
		}
		//standard
		else if(pv < dv && pv <= 21 && dv <=21){
			System.out.println("\nDealer Wins!");
		}
		else if(pv == dv && pv <= 21 && dv <=21){
			System.out.println("\nTie!");
		}
		else if(pv > dv && pv <= 21 && dv <=21){
			System.out.println("\nPlayer Wins!");
		}
	}


	public void gameOverHandler(){
		while(true){
			System.out.println("\n\nGame over\nWould you like to play again? (yes/no)");
			String response = kb.nextLine().toLowerCase();
			if(response.equals("no")){
				playAgain = false;
				break;
			}
			else if(response.equals("yes")){
				playAgain = true;
				break;
			}
			else {
				System.out.println("Error. Try Again");
			}
		}
		
	}

	public void ascii(){
		System.out.println("______ _            _    _            _    \n| ___ \\ |          | |  (_)          | |   \n| |_/ / | __ _  ___| | ___  __ _  ___| | __\n| ___ \\ |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n| |_/ / | (_| | (__|   <| | (_| | (__|   < \n\\____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n	               _/ |\n	              |__/");
	}

	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}
