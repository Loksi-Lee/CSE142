// Lesi Li
// 07/11/2020
// CSE 142
// TA: Joe Lang
// Assignment #3 CafeWall
/*descriptions: This program draw a cafe wall. Since the 
pattern are the same and the only difference is the position 
and their size. So I create a method of drawing a main box
and use for loop in the main to create the patterns. This
can help reduce redundancy.
*/


import java.awt.*;

public class CafeWall {

//We set the mortar which can change
//the mortar of the grid from C to F
//by changing the constant number
   public static final int mortar = 2;

   public static void main (String[] args) {
   // Create a Window
      DrawingPanel panel = new DrawingPanel (650, 400);
      panel.setBackground (Color.GRAY);
   // get the pen object
      Graphics g = panel.getGraphics(); 
   //This part of statement create the image of row A
   //To reduce redundancy, we use a for loop here
   //The initial value starts from 0, and then increase
   //for 4 times including the 0
   //so we get the total of 4 Boxes
   //inside the for loop, in the x position
   //I use the formula 0+40*i because the x-position of
   //the next boxes will change.
   //The amount of changes are the 2 boxes length
   //So 40 equals to 2 boxes' size 20+20
      drawBox(g, 0, 0, 20); 
      for (int i=0; i<=3; i++) {
         drawBox(g, 0+40*i, 0, 20);  
      }
      
   //This part of statement create the image of row B
   //Both the x,y-coordinate and size is different
   //from row A
   //Since row B gets one more box than row A
   //Therefore, the initial value is still 0
   //and we increase for 5 times 
   //We get 5 boxes at the end
      drawBox(g, 50, 70, 30); 
      for (int i=0; i<=4; i++) {
         drawBox(g, 50+60*i, 70, 30);
      }
      
   //This part of statement create the image of grid C
   //Since grid C has several line with different 
   //x and y coordinate position, 
   //So I use two for loop and two drawBox statement
   //The outside one makes the box have 2 line for each 
   //drawBox statement
   //And the inside one make the horizontal boxes
   //In the first drawBox, since the one square have
   //the size of 35. To create the next box, we must
   //add two square which is 35+35=70, increase from the 
   //initial position. The same as the second drawBox.
   //Since the offset value is 35, therefore, we need to 
   //plus an extra 35 in it x position
   //For the y coordinate, 20 is the initial value,
   //since we get mortal between each line, and considering
   //we have mortar both from the upper one and the lower one
   //Therefore, we need to multiply mortar by 2. 
   //Since the previous boxes and the latter one also have 
   //their own distance, which is the distance of two boxes
   //so, we need to add 2*35 which is 70
   //adding (70+2*mortar) together and then times line is to
   //achieve that they have two lines of this
   //The same priciple apply to the second drawBox's y position
   //The reason to add 35+mortar base on the initial y value
   //is to draw the box under one square box which have the 
   //size of 35 and plus the mortar
      drawBox(g, 400, 20, 35); 
      for (int line=0; line<=1; line++) {
         for (int i=0; i<=1; i++) {
            drawBox(g, 400+70*i, 20+(70+2*mortar)*line, 35);
            drawBox(g, 400+35+70*i, (20+35+mortar)+(70+2*mortar)*line, 35);
         }
      }
      
   //This part of statement create the image of grid D
   //We have one drawBox in the inside for loop is that
   //the offset value is 0, therefore, we only need to 
   //take the change of the x position and the y position
   //into account. 
   //The outside for loop is mainly to draw different lines.
   //The inside for loop is the paint the box in one line
   //In the x place, we add 50*i base on the initial value 
   //is because the next x position need to paint after
   //two squares which have the size of 25 and the total is 50
   //with i times.
   //Same priciple in y position.
   //25 is the size of one square and the distance between
   //two lines is the size and mortar
      drawBox(g, 10, 150, 25); 
      for (int line=0; line<=7; line++) {
         for (int i=0; i<=3; i++) {
            drawBox(g, 10+50*i, 150+(25+mortar)*line, 25);
         }
      }
      
   //This part of statement create the image of grid E
   //Two drawBox statement with the offset of value 10
   //in the second one.
   //All steps have the similar priciple with previous.
   //The second drawBox x coordinate we add an extra 10
   //value to add the offset value.
   //For the y position, (200+25+mortar) means the 
   //distance with the initial value is one square 
   //plus the mortar.
   //(50+2*mortar) means the next graph of this statement
   //is the two square with the size of 25 and the 2 mortar
   //respectively are the mortar with the previous line and 
   //the mortar with the lower line
      drawBox (g, 250, 200, 25); 
      for (int line=0; line <= 2; line++) {
         for (int i=0; i <= 2; i++) {
            drawBox(g, 250+50*i, 200+(50+2*mortar)*line, 25);
            drawBox(g, 50*i+250+10, (200+25+mortar)+(50+2*mortar)*line, 25);
         
         }
      }
      
            
   //This part of statement create the image of grid F
   //Two drawBox statement with the offset of value 10
   //in the second one.
   //All steps have the similar priciple with previous.
   //The second drawBox x coordinate we add an extra 10
      drawBox (g, 425, 180, 20); 
      for (int line = 0; line <= 4; line++) {
         for (int i=0; i <= 4; i++) {
            drawBox(g, 425+40*i, 180+(40+2*mortar)*line, 20);
            drawBox(g, 425+10+40*i, (180+20+mortar)+(40+2*mortar)*line,20);
         }
      }
      
      
   }
   
   //This method help draw a back square with blue line inside
   //and a white square. Combining those two squares create a 
   //box. by defining int x, y, and size in the method, we can 
   //draw the box with different position and size by putting
   //different number inside.
   
   //int x: the x-coordinate of the top left corner of the drawn square
   //int y: the y-coordinate of the top left corner of the drawn square
   //int size: the size of the square
   public static void drawBox(Graphics g, int x, int y, int size) {
      g.setColor(Color.BLACK);
      g.fillRect(x, y, size, size);
   
      g.setColor(Color.BLUE);
      g.drawLine(x, y, x+size, y+size);
      g.drawLine(x+size, y, x, y+size);
   
      g.setColor(Color.WHITE);
      g.fillRect(x+size,y,size,size);
      
   }

public static void intro() {


}


}