// Lesi Li
// 06/25/2020
// CSE 142
// TA: Joe Lang
// Assignment #2 AsciiArt
/*descriptions: In this program, I draw a Christmas tree.
I seperate this program into 6 part.
Although the first branch and first line are similar to 
the second branch and second line, they are slightly different
with the number.
I use for loop to reduce redundancy.
*/


public class AsciiArt{

    
   public static void main (String[] args) {
      Decoration();
      FirstBranch();
      FirstLine();
      SecondBranch();
      SecondLine();
      SupportBranch();
   }
   public static void Decoration() {
      for (int space = 1; space <= 6*4; space++) {
         System.out.print(" ");
      }
      System.out.println(".");
   }
   
   public static void FirstBranch() {
      for (int line = 1; line <= 3; line++) {
         for (int space = 1; space <=6*4-line; space++) {
            System.out.print(" ");
         }
         for (int i = 1; i <= line + 1; i++) {
            System.out.print("/");
         }
         for (int j = 1; j <= line; j++) {
            System.out.print("\\");
         }
         System.out.println(" ");

      }
   } 
 
   public static void FirstLine() {
      for (int space = 1; space <= 5 * 4+1; space++) {
         System.out.print(" ");
      }
      System.out.print("*");
      for (int i = 1; i <= 4 + 1; i++) {
         System.out.print("=");
      }
      System.out.println("*");
   }

   public static void SecondBranch() {
      for (int line = 1; line <= 4; line++) {
         for (int space = 1; space <=6*4-line; space++) {
            System.out.print(" ");
         }
         for (int i = 1; i <= line + 1; i++) {
            System.out.print("/");
         }
         for (int j = 1; j <= line; j++) {
            System.out.print ("\\");
         }
         System.out.println(" ");
      }
   }
   public static void SecondLine() {
      for (int space = 1; space <= 5 * 4; space++) {
         System.out.print(" ");
      }
      System.out.print("*");
      for (int i = 1; i <= 2*4 - 1; i++) {
         System.out.print("=");
      }
      System.out.println("*");
   }
   public static void SupportBranch() {
      for (int line = 1; line <= 2; line++) {
         for (int space = 1; space <= 6*4 - 1; space++) {
            System.out.print(" ");
         }
         System.out.println("| |");
      }
   
   } 
}