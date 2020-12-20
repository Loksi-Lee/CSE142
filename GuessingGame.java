// Lesi Li
// 07/27/2020
// CSE 142
// TA: Joe Lang
// Assignment #5 Guessing Game
/*descriptions: User can play a game in this program.
The program first choose a random number, users can
win the game only if they input the number that is
exactly match the number that produce in random. If
the number that users choose is not matching with the
system, computer will give user hint correspondingly.
For example, if users choose a number lower than the
actual one, computer with print out "It's higher" as 
a hint, vice versa.
*/

import java.util.*;

public class GuessingGame {
// Class constant. This is the maximum value of the guessing
   public static final int MAX = 100;

   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
      // Set seed    
      Random gues = new Random(42);
   
      poem();
      
      // count is the total guess in the first game
      int count = singleGame(console, gues);
      
      //minGuess is use to record the minimum time 
      //of guessing in one game.
      int minGuess = count;
      
      System.out.print("Do you want to play again? ");
      String cho = console.next();
      char firstLetter = cho.charAt(0);
      System.out.println();
      
      //After the first single game, the total game would
      //first initialize as 1.
      int tolGame = 1;
      
      int guess = 0;
      
      while (firstLetter =='y'|| firstLetter =='Y') {
         guess = singleGame(console, gues);
         count = count + guess;
      
         if (minGuess > guess) {
            minGuess = guess;
         } 
      
         System.out.print("Do you want to play again? ");
         cho = console.next();
         firstLetter = cho.charAt(0);
         System.out.println();
         tolGame++;
      }
      
      report(tolGame, count, minGuess);
      
   }

   // The haiku poem part before the game  
   public static void poem() {
      System.out.println("Density is in your hands");
      System.out.println("Shorter time of guessing helps you win.");
      System.out.println("Now, let's start the game");
      System.out.println();
   }
   
   // This method is for the first round of playing.(A single game)
   //Scanner console is a parameter that help to input something.
   //Random gues is a parameter with the set seed of random number.
   //counting here is to calculate how many times that user use
   //to guess out the correct number.
   //I use the return statement to rercord the total counting here.
   public static int singleGame(Scanner console, Random gues){
      System.out.println("I'm thinking of a number between 1 and " + MAX + "...");
      
      int num = gues.nextInt(MAX)+1;
   
      System.out.print("Your guess? ");
      int g = console.nextInt();
   
      int counting = 1;
   
      while(g!=num) {
      
         if (g<num) {
            System.out.println("It's higher.");
         } else {
            System.out.println("It's lower.");
         }
         System.out.print("Your guess? ");
         g = console.nextInt();
      
         counting++;
      }
   
      if (counting == 1) {
         System.out.println("You got it right in " + counting +" guess!");
      } else {
         System.out.println("You got it right in " + counting +" guesses!");
      }
         
      return counting;
   }
   
   //The report method here is to print out the result once the users
   //don't want to play the game again.
   //int gameTol is a parameter of the Total game.
   //int guessTol is a parameter of the Total guess within the total game.
   //int bestGuess is a parameter of the minimum guess when every time
   //the user to play the game.
   public static void report(int gameTol, int guessTol, int bestGuess) {
      System.out.println("Overall results:");
      System.out.println("Total games   = " + gameTol);
      System.out.println("Total guesses = " + guessTol);
      double guessPerGame = (double)guessTol / (double)gameTol;
      System.out.println("Guesses/game  = " + round(guessPerGame));
      System.out.println("Best game     = " + bestGuess );
   }
   
   //This is a method mainly help to round a number to the nearest tenth.
   //double num is a paramter that repersent the number that need
   //to be round.
   //The rounded number would be return.
   public static double round(double num) {
      return Math.round(num * 10.0) / 10.0;
   
   }
}