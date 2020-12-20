// Lesi Li
// 07/11/2020
// CSE 142
// TA: Joe Lang
// Assignment #3 Doodle
/*descriptions: In this assignment, I draw
a house and with pink background
*/

import java.awt.*;

   
public class Doodle {

public static final int mortar = 2;

   public static void main (String[] args) {
      DrawingPanel panel = new DrawingPanel (350, 200);
      panel.setBackground (Color.PINK);
      Graphics g = panel.getGraphics();
      drawHouse(g,120,40,60);
      
      
   }
   
  // In this method, I first define x, y, and size
  //and then I set up different line, square,
  //rectangle and circle to construct a house. 
  //Their size can change according to rhe base number
  //set in the main.
  
   //int x: the x-coordinate of the top corner of the triangle
   //int y: the y-coordinate of the top corner of the triangle
   //int size: the size of each shape
    public static void drawHouse(Graphics g, int x, int y, int size) {
    g.setColor(Color.BLACK);
    g.drawLine(x,y,x-30,y+50);
    g.drawLine(x,y,x+30,y+50);
    g.drawLine(x-30,y+50,x+30,y+50);
    
    g.setColor(Color.BLUE);
    g.fillOval(x,y+150,size/10,size/10);
    
    g.setColor(Color.WHITE);
    g.drawRect(x-30,y+50+mortar,size,size+90);
    g.drawRect(x-20,y+80,size/6,size/6);
    g.drawRect(x+10,y+80,size/6,size/6);
    g.drawRect(x-5,y+140,size/6,size/3);

    }

}