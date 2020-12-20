// Yazzy Latif
// 07/17/2020
// CSE142
// TA: Grace Hopper

// A short program that simulates a login system, and counts the number of characters typed by the 
// user until they choose to logout.

import java.util.*;

public class LoginSystem2 {
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      System.out.print("What is your name? ");
      String myName = console.nextLine();
      
      // something with index of --> spaceIndex
      int spaceIndex = myName.indexOf(" ");
      
      // something with substring --> chop up string
      String firstName = myName.substring(0, spaceIndex);
      
      System.out.println("Hello, " + firstName);
      
      String realPassword = "password";
      System.out.print("Enter your password please: ");
      String userPassword = console.nextLine();
      
      // NOTE: We *must* use the .equals() method here to compare Strings to see if they are
      //       equivalent (contain the same characters in precisely the same order).  
      //       In general, when testing objects for equivalence, we should use the .equals() method
      //       not the == operator (which works as expected for *primitive* types). 
      
      // NOTE: that using the ! operator in front of this method call essentially *flips* the test 
      //       so now instead of "while the real password equals the user's password", it can be read
      //       as "while the real password does *not* equal the user's password"
      while (!userPassword.equals(realPassword)) {
         System.out.print("Incorrect password, please try again: ");
         userPassword = console.nextLine();
      }
      
      System.out.println("Welcome back, here are some cookies");
      
      int letterSum = 0;
      
      // post: prompt/read
      // wire: add to the sum
      System.out.print("Type something or type logout to logout: ");
      String next = console.nextLine(); // priming
      // an example of a "sentinel" loop (see posted slides) where there is a particular value 
      //    "guarding" the loop, a specific value that we're looking for in the loop test.
      while (!next.equals("logout")) {
         letterSum = letterSum + next.length();
         System.out.print("Type something or type logout to logout: "); // post (part 1)
         next = console.nextLine();                                     // post (part 2)
      }
      
      // NOTE: It was suggested by someone in lecture to just have a line like "letterSum -= 6" 
      //       after our loop, rather than restructuring the loop to account for the fencepost 
      //       problem.  While this would functionally work, this is something I would consider 
      //       a "kludge" (definition: A kludge or kluge is a workaround or quick-and-dirty 
      //       solution that is clumsy, inelegant, inefficient, difficult to extend and hard to 
      //       maintain).  
      //       In other words, while this works, it sort of works for the wrong reasons...this is
      //       effectively "undoing" the addition of "logout"'s character count to letterSum, when
      //       really it should have never been added in in the first place!
      System.out.println("You typed " + letterSum + " letters!");
   }
}