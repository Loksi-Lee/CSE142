// Ayaz Latif
// 07/10/2020
// CSE142
// TA: Grace Hopper
// Car Lecture Example

// Produces an image of multiple black cars with red wheels and a blue window on a grey background
// of various sizes.  

/* DEVELOPMENT NOTES:
((Note: this is not something you should include in your own programs; this is included here to aid
         in your understanding and to provide additional context for the program.))
This is another version of the Car Example but with animation. Using a combination of clearing the
panel and sleeping the panel we could draw a car in a slightly different location production
an animation of the car driving to the right.
*/

import java.awt.*;
public class Car4 {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(400, 200);
      panel.setBackground(Color.LIGHT_GRAY);

      
      Graphics g = panel.getGraphics(); // paintbrush

      drawCar(g, 10, 30, 100);
      drawCar(g, 150, 10, 50);
      
      // NOTE: this for loop starts at 0!  This is not something that is required, but 
      // often times for loops with the loop variable initialized to 0 can make coordinate / pixel 
      // math a little bit simpler!
      for (int i = 0; i < 50; i++) {
         // draws next frame
         panel.clear();
         drawCar(g, 10 + 20 * i, 130, 40);
         panel.sleep(50);
      }

   }
   
   // Draws a car with a black body, a cyan window, and red wheels at the given loction. 
   // Graphics g: the Graphics object to use when drawing
   // int x: the x-coordinate of the top-left corner of the drawn car
   // int y: the y-coordinate of the top-left corner of the drawn car
   // int size: the size of the drawn car (must be a multiple of 10)
   public static void drawCar(Graphics g, int x, int y, int size) {
      // remember: we needed to both scale the size of each element of the figure (the body of the 
      //             van, the window, both wheels) as well as the distance from the corner of the 
      //             van! See the inked drawings on the course website for intuition about how we 
      //             worked out this coordinate / pixel math. 
   
      // draw body black rectangle
      g.setColor(Color.BLACK);
      g.fillRect(x, y, size, size / 2);
      
      // draw window cyan rectangle
      g.setColor(Color.CYAN);
      g.fillRect(x + size * 7 / 10, 
            y + size / 10, 
            size * 3 / 10, 
            size * 2 / 10);
      
      // draw wheels red circles
      g.setColor(Color.RED);
      g.fillOval(x + size / 10, y + size * 4 / 10, size * 2 / 10, size * 2 / 10);
      g.fillOval(x + size * 7 / 10, y + size * 4 / 10, size * 2 / 10, size * 2 / 10);
   }

}