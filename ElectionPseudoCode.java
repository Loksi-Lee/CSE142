// Yazzy Latif
// 07/15/2020
// CSE 142
// TA: Grace Hopper
// Election Good Example

// A program to read in the number of votes each of two candidates received
//   in a number of precincts, then compute the winner of the election.
//

/* DEVELOPMENT NOTES:
((Note: this is not something you should include in your own programs; this is included here to aid
         in your understanding and to provide additional context for the program.))

 This version of the program demonstrates good information flow by making
   proper use of parameters and return values. Notice how main is a concise
   summary of the program and major methods return their results to main.

 Notice also the factoring of common code out of the branches of the if/else
   statement in printResults.
   */
import java.util.*;

public class ElectionGood {
   public static final int NUM_VOTERS = 807;

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
   
      intro();
      int votes1 = getVotes(console, "Pizza Party");
      int votes2 = getVotes(console, "Pajama Party");
      printResults(votes1, votes2);
      reportTurnout(votes1 + votes2);
   }
   
   // Prints out an introduction to the program.
   public static void intro() {
      System.out.println("This program reads in data for two candidates");
      System.out.println("and computes the result of an election");
      System.out.println();   
   }
   
   // Reads in and computes the total votes for one candidate.
   //
   // Scanner console - the Scanner to use for input   
   public static int getVotes(Scanner console, String party) {
      System.out.println("Enter " + party + " candidate's totals:");
      System.out.print("How many precincts? ");
      int numPrecincts = console.nextInt();

      int totalVotes = 0;
      for (int i = 1; i <= numPrecincts; i++) {    
         System.out.print("   Votes in next precinct? ");
         int votes = console.nextInt();
         totalVotes += votes;
      }
      System.out.println();
      
      return totalVotes;
   }
   
   // Computes and prints the final results of the election.
   //
   // int firstVotes - the number of votes the first candidate received
   // int secondVotes - the number of votes the second candidate received   
   public static void printResults(int firstVotes, int secondVotes) {
      int totalVotes = firstVotes + secondVotes;
      double pct1 = getPercentage(firstVotes, totalVotes);
      double pct2 = getPercentage(secondVotes, totalVotes);
      
      System.out.println("Pizza Party received " + round2(pct1) + "% of the votes cast");
      System.out.println("Pajama Party received " + round2(pct2) + "% of the votes cast");
      
      if (pct1 > pct2) {
         System.out.println("Pizza Party wins!");
      } else if (pct2 > pct1) {
         System.out.println("Pajama Party wins!");
      } else {    // pct2 == pct1
         System.out.println("It's a tie!");
      }
   }
   
   // Compute and print the precentage of eligible voters 
   //   who cast a vote.
   //
   // int totalVotes - the total number of votes cast
   public static void reportTurnout(int totalVotes) {
      double turnoutPct = getPercentage(totalVotes, NUM_VOTERS);
      System.out.println("Turnout was " + round2(turnoutPct) + "%");
   }

   // Computes and returns the percentage of votes earned.
   //
   // int myVotes - number of votes earned
   // int totalVotes - total votes cast
   public static double getPercentage(int myVotes, int totalVotes) {
      return 100.0 * myVotes / totalVotes;
   }
   
   // Returns the given number rounded to two decimal places.
   //
   // double num - the number to round
   public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
}