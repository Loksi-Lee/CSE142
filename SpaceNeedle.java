// Lesi Li
// 06/25/2020
// CSE 142
// TA: Joe Lang
// Assignment #2
/*descriptions: In this program, a Space Needle was created. 
The size of this graph can be change by only change the statement
of the SIZE number.
In this program, I seperate the space Needle into 5 part.
This can help redundancy by using the same statement when combining 
them into the main method.
Also using inner for loop can help redundancy.
*/

public class SpaceNeedle{
   public static final int SIZE = 10;
   
   public static void main (String[] args) {
      drawNeedle();
      drawHeadTop();
      drawLine();
      drawHeadBottom();
      drawNeedle();
      drawBody();
      drawHeadTop();
      drawLine();
   }


//Print the top and body needle part
// of the spaec needle
   public static void drawNeedle() {
      for (int line = 1; line<=SIZE; line++) {
         for (int i = 1; i <= 3*SIZE; i++) {
            System.out.print(" ");
         }
         System.out.println("||");
      }  
   }
   
//Print the first part of the head from 
//Space Needle, this part also construct the bottom.
   public static void drawHeadTop() {
      for (int line = 1; line<=SIZE; line++) {
         for (int space = 1; space <= -3 * line + (3 * SIZE); space++) {
            System.out.print(" ");
         }
         System.out.print("__/");
         //System.out.print("/");
         for (int colon = 1; colon <= 3*line-3; colon++) {
            System.out.print(":");
         }
         System.out.print("||");
         for (int colon = 1; colon <= 3*line-3; colon++) {
            System.out.print(":");
         }
         System.out.println("\\__");
      }
   }
   
   //This line seperate the head of the space
   //needle into two part and also construct 
   //the bottom line of the space needle
   public static void drawLine() {
      System.out.print("|");
      for (int i = 1; i <= 6*SIZE; i++) {
         System.out.print("\"");
      }
      System.out.println("|");
   }
   
   //This part print the lower part of the space needle head.
   public static void drawHeadBottom() {
      for (int line = 1; line<=SIZE; line++) {
         for (int space = 1; space <= 2* line -2; space++) {
            System.out.print(" ");
         }
         System.out.print("\\_");
         for (int i = 1; i <= -2 * line + 3 * SIZE + 1; i++) {
            System.out.print("/");
            System.out.print("\\");
         }
         System.out.println("_/");
      
      }
   }
   
   //This is the body part of the space needle
   public static void drawBody() {
      for (int line = 1; line <= SIZE * SIZE ; line++) {
         for (int space = 1; space <= 2* SIZE + 1; space++) {
            System.out.print(" ");
         }
         System.out.print("|");
         for (int p = 1; p <= SIZE - 2; p++) {
            System.out.print("%");
         }
         System.out.print("|");
         System.out.print("|");
         for (int p = 1; p <= SIZE - 2; p++) {
            System.out.print("%");
         }
            System.out.println("|");
      }
   }
  
}