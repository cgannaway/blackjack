package src;

import java.util.ArrayList;


public abstract class AbstractPlayer implements Playerable
{
   private ArrayList<Card> hand;
   private int winCount;
   private String name;

   //constructors
   AbstractPlayer(){
      winCount = 0;
      hand = new ArrayList<Card>();
   }

   public void addCardToHand( Card temp )
   {
      hand.add(temp);
   }

   public void resetHand( )
   {
      hand.clear();
   }

   public void setWinCount( int numwins )
   {
      winCount = numwins;
   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public void setName(String Name){
      name = Name;
   }
   public String getName(){
		return name;
	}

   public int getHandValue()
   {
		//great example of polymorphism
      int total=0;
      for(int i=0; i<hand.size(); i++){
         total += hand.get(i).getValue();
      }
      return total;
   }

   public String getSpecificCard(int location){
      return hand.get(location).toString();
   }
   public String getHand(){
      return hand.toString();
   }

   public String toString()
   {
      return "hand = " + hand.toString() + " \n-  # wins " + winCount;
   }
}