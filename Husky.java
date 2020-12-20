import java.awt.*;

public class Husky extends Critter {
   
   private int moves;

   public Husky() {
   moves=0;
   }

   public Action getMove(CritterInfo info) {
    
      moves++;
      
      if (info.getFront() == Neighbor.OTHER) {
          return Action.INFECT;
       } else if (info.getFront() == Neighbor.WALL 
       || info.getFront() == Neighbor.SAME) {
          return Action.RIGHT;
       } else if (info.getFront() == Neighbor.EMPTY) {
          return Action.HOP;
       } else {
          return Action.LEFT;
       }
   }
    
   public Color getColor() {
   
      if (moves % 2 == 0) {
         return Color.MAGENTA;
      } else {
         return Color.YELLOW;
      }
   }

   public String toString() {
      if (moves % 2 == 0) {
         return "U";
      } else {
         return "W";
      }
   }
}