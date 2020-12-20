import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   
   // Create the variable that is only
   // for this program.
   private int moves;
   private Random rand;
   private int color;
   private Color choice;
   
   //Constructor
   //Define the variable with the initial value.
   public Lion() {
      moves = 0;
      rand = new Random();
      color = 0;
   }
   
   
   //This is the method that determine the move of 
   //the action with different situation. 
   //moves will be add 1 when each moves.
   //When the front of lion is other species,
   //it will infect them.
   //When wall is in front of the lion or in the right,
   //it will turn left.
   //When the same species in front of them,
   //it will turn right.
   //otherwise, it will hop.
   //The action will be returned.
   public Action getMove(CritterInfo info) {
  
      moves++;
      
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.WALL 
                    || info.getRight() == Neighbor.WALL) {
         return Action.LEFT;
      } else if (info.getFront() == Neighbor.SAME) {
         return Action.RIGHT;
      } else {
         return Action.HOP;
      }
      
   }
    
   //Since there are three colors in three moves,
   //and they appear randomly.
   //So I use variable color to get random number of 
   //0, 1, 2 and each of them represent one color.
   //Since three moves for one color,
   //So, every three steps I get into the outer if loop,
   //then randomly pick a number and get color.
   //The color will be returned.
   public Color getColor() {
   
      color = rand.nextInt(3); 
   
      if (moves % 3 == 0) {
         if (color == 0) {
            choice = Color.GREEN;
         } else if (color == 1){
            choice = Color.RED;
         } else {
            choice = Color.BLUE;
         }
      }
     
      return choice;
   }
   
   //The shape representing this animal is being returned.
   public String toString() {
      return "L";
   }
}