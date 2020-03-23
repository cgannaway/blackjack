
import static java.lang.System.*;
import java.util.Scanner;
import src.*;

/**
 * Main Class for Single Player BlackJack
 */
public class BlackJack
{
	//add in Player instance variable
	//add in Dealer instance variable
	private Player player;
	private Dealer dealer;
	public boolean playAgain = true;
	public Scanner kb;

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
			dealTwo(player, dealer);
			dealTwo(dealer, dealer);
			printPlayer(player, dealer);
			playerHits();
			
			dealerHits(dealer, dealer);
			printBoth();
			compareHands(player, dealer);
			gameOverHandler();
		}
		exit(0);
	}
	
	/**
	 * deals two cards
	 */
	public void dealTwo(AbstractPlayer obj, Dealer dealer){
		obj.addCardToHand(dealer.deal());
		obj.addCardToHand(dealer.deal());
	
	}
	

	/**
	 * Print Player Hand (for use before Dealer's turn)
	 */
	public void printPlayer(AbstractPlayer player, AbstractPlayer dealer){
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
		System.out.println("\n\nPlayer: (Wins: " + player.getWinCount() + ")");
		System.out.println("Value: " + player.getHandValue());
		System.out.println("Cards: " + player.getHand());
		System.out.println("\nDealer: (Wins: " + dealer.getWinCount() + ")");
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
				printPlayer(player,dealer);
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
	public void dealerHits(AbstractPlayer player, Dealer dealer){
		while(true){
			if(checkPlayer(player) == true){
				break;
			}
			if(player.hit() == true){
				player.addCardToHand(dealer.deal());
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
	 * print winner and add to win int
	 * @param player hand to compare to dealer
	 * @param x player number
	 */
	public void compareHands(Playerable player, Playerable dealer){
		int dv = dealer.getHandValue();
		int pv = player.getHandValue();

		//blackjacks
		if(pv == 21 && dv != 21){
			System.out.println("Blackjack! Player Wins\n");
			player.setWinCount(player.getWinCount() + 1);
		}
		else if(pv == 21 && dv == 21){
			System.out.println("Both Players Blackjack! Tie!\n");
		}
		else if(pv != 21 && dv == 21){
			System.out.println("Blackjack! Dealer Wins\n");
			dealer.setWinCount(dealer.getWinCount() + 1);
		}
		//both bust
		else if(pv > 21 && dv > 21){
			System.out.println("Tie! Both Bust\n");
		}
		//one busts
		else if(pv > 21 && dv <= 21){
			System.out.println("Player Bust, Dealer Wins!\n");
			dealer.setWinCount(dealer.getWinCount() + 1);
		}
		else if(pv <= 21 && dv > 21){
			System.out.println("Dealer Bust, Player Wins!\n");
			player.setWinCount(player.getWinCount() + 1);
		}
		//standard
		else if(pv < dv && pv <= 21 && dv <=21){
			System.out.println("Dealer Wins!\n");
			dealer.setWinCount(dealer.getWinCount() + 1);
		}
		else if(pv == dv && pv <= 21 && dv <=21){
			System.out.println("Tie!\n");
		}
		else if(pv > dv && pv <= 21 && dv <=21){
			System.out.println("Player Wins!\n");
			player.setWinCount(player.getWinCount() + 1);
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
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("______ _            _    _            _    \n| ___ \\ |          | |  (_)          | |   \n| |_/ / | __ _  ___| | ___  __ _  ___| | __\n| ___ \\ |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n| |_/ / | (_| | (__|   <| | (_| | (__|   < \n\\____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n	               _/ |\n	              |__/");
	}

	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		game.playGame();
	}
}
