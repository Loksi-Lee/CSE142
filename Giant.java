import java.awt.*;

public class Giant extends Critter {
   
   // Create the variable that is only
   // for this program.
   private int moves;
   private String gMove;
   
   //Define the number of that variable here.
   public Giant() {
   moves=0;
   }

   //This is the method that determine the move of 
   //the action with different situation. 
   //moves here is recording for each turn.
   //When other species in front of giant, giant will 
   //infect them
   //When nothing in front of giant, it hops.
   //Otherswise, it turns rights.
   //The action of moves will be returned.
   public Action getMove(CritterInfo info) {
          
      moves++;
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.RIGHT;
      }
      
   }
   
   //The color of giant is gray.
   //The color will be returned.
   public Color getColor() {     
      return Color.GRAY;
   }
  
  // For 6 steps will represent different word.
  // So here I set each 24 is a round.
  // For one round, we counts for 6 steps.
  // Then I set the word for every 6 steps in order.
  // The action will be returned.
   public String toString() {
   
       if (moves == 24) {
         moves = 0;
      }  

      if (moves / 6 == 0) {
         gMove = "fee";
      } else if (moves / 6 == 1) {
         gMove = "fie";
      } else if (moves / 6 == 2) {
         gMove = "foe";
      } else if (moves / 6 == 3) {
         gMove = "fum";
      }
         
           return gMove; 
   }
}