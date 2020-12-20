import java.awt.*;

// Bear extends the code of Critter method one.
public class Bear extends Critter {
  
   // Create the variable that is only
   // for this program.
   // boolean s is to record true and false.
   // int steps is to record the every times that runs.
   private boolean s;
   private int steps;
   
   //polar is a parameter to determine true or false.
   //when polar is true, it represents polar bears.
   //when polar is false, it represents bears.
   public Bear (boolean polar) {
      s = polar;
   }
   
   //This is the method that determine the move of 
   //the action with different situation. 
   //When the front of bear is other species,
   //it will infect them.
   //if nothing in front of them
   //it will hop.
   //if in front of them is other conditions
   //it will turn left.
   //for every turn, steps will be recorded it.
   //The action will be returned.
   public Action getMove(CritterInfo info) {
      steps++;
      if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else {
         return Action.LEFT;
      }

   }
   
   //When s is true, the color is white.
   //Otherwise, return black.
   //The color will be returned.
   public Color getColor() {
      if(s==true) {
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }

   //The move is changing steps by steps.
   //so steps % 2 = 0 represents the even number
   //steps % 2 = 1 represents the odd number.
   //The shape representing this animal will be returned.
   public String toString() {
    
      if (steps % 2 == 0) {
         return "/";
      } else {
         return "\\";
      }
    
   }

}