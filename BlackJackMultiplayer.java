import java.util.ArrayList;

/**
 * Multiplayer Version of Blackjack
 */
public class BlackJackMultiplayer extends BlackJack {
    
    private ArrayList<AbstractPlayer> playerlist;
    private Dealer dealer;
    public BlackJackMultiplayer(){
        playerlist = new ArrayList<AbstractPlayer>();
        dealer=new Dealer();
        addPlayers();
    }

    public void playGame(){
        while(playAgain == true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            ascii();

            ((Dealer)playerlist.get(0)).shuffle();

            firstDeal();
            
            playerHits();
            dealerHits(playerlist.get(0), ((Dealer)playerlist.get(0)));

            showAll();
            compareHands();

            gameOverHandler();

        }
    }

    /**
     * add Players to the player arraylist
     */
    public void addPlayers(){
        playerlist.add(dealer);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ascii();
        System.out.print("\nEnter Player 1's name: ");
        playerlist.add(new Player(kb.next()));
        while(true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            ascii();
            System.out.println("\nEnter another name to add another player, or");
            System.out.print("type \"continue\" to continue: ");
            String temp = kb.next();
            if(temp.equalsIgnoreCase("continue")){
                break;
            }
            else{
                playerlist.add(new Player(temp));
            }
        }
    }
    
    public void firstDeal(){
        for(int i = 0; i < playerlist.size(); i++){
            dealTwo(playerlist.get(i), ((Dealer)playerlist.get(0)));
        }
        
    }

    /**
     * reset hands of every player
     */
    public void resetAllHands(){
        for(int i = 0; i<playerlist.size(); i++){
            playerlist.get(i).resetHand();
        }
    }

    public void resetAllWins(){
        for(int i = 0; i<playerlist.size(); i++){
            playerlist.get(i).setWinCount(0);
        }
    }

    public void playerHits(){
        for(int i=1; i<playerlist.size(); i++){
            while(true){
                if(checkPlayer(playerlist.get(i)) == true){
                    break;
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                ascii();
                System.out.println("" + playerlist.get(i).getName() + " is current player");
                printPlayer(playerlist.get(i), playerlist.get(0));
                if(playerlist.get(i).hit() == true){
                    playerlist.get(i).addCardToHand(dealer.deal());
                    if(checkPlayer(playerlist.get(i)) == true){
                        break;
                    }
                }
                else{
                    break;
                }
            }
        }
    }

    public void showAll(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        ascii();
        for(int i = 0; i < playerlist.size(); i++){
            System.out.println("\n" + playerlist.get(i).getName() + "'s Hand: (Value: " + playerlist.get(i).getHandValue() + ")");
            System.out.println(playerlist.get(i).getHand());
        }
    }

    public void compareHands(){
        System.out.println();
        for(int i = 1; i < playerlist.size(); i++){
            System.out.print("Player: " + playerlist.get(i).getName() + ". ");
            super.compareHands(playerlist.get(i), playerlist.get(0));
        }
    }

    public void gameOverHandler(){
        super.gameOverHandler();
        if(playAgain == true){
            System.out.println("Would you like to change players? (yes/no");
            if(kb.nextLine().equalsIgnoreCase("yes")){
                resetAllHands();
                resetAllWins();
                playerlist.clear();
                addPlayers();
            }
            else{ /////////////////////////////////////////////////////////////////////////////////////////////error
                resetAllHands();
            }
        }
    }


    public static void main(String[] args) {
        BlackJackMultiplayer game = new BlackJackMultiplayer();
        game.playGame();
    }

}