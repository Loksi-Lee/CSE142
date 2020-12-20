// Lesi Li
// 06/25/2020
// CSE 142
// TA: Joe Lang
// Assignment #1
//
/*To avoid redundancy as much a possible, I assigned each paragraph 
to each method and combine all the paragraphs in the main part.
Since I realize for each paragraph there must be something similar 
to the previous paragraph. Therefore, I first put the repeated part 
in the first paragraph as a single method called "repeated" and combine 
it with paragraph1. Then for the following paragraph, I create a branch 
such as paragraph22, paragraph33, etc as a single method that is repeated 
in the following paragraph. Besides print in the method in paragraph22 or
paragraph33 etc, I print the line that only belongs to that paragraph in the 
method paragraph2, paragraph3, and so on.
In the end, I combine all those paragraphs in the main.
*/

public class Song {
   public static void main (String[] args) {
      paragraph1();
      paragraph2();
      paragraph3();
      paragraph4();
      paragraph5();
      paragraph6();
      end();
   }
   
   public static void paragraph1() {
      System.out.println ("There was an old woman who swallowed a fly.");
      repeated ();
      System.out.println();
   }
   
   public static void paragraph2() {
      System.out.println ("There was an old woman who swallowed a spider,");
      System.out.println ("That wriggled and iggled and jiggled inside her.");
      paragraph22();
      System.out.println();
   }
   
   public static void paragraph22() {
      System.out.println ("She swallowed the spider to catch the fly,");
      repeated ();
   }
   
   public static void paragraph3() {
      System.out.println ("There was an old woman who swallowed a bird,");
      System.out.println ("How absurd to swallow a bird.");
      paragraph33();
      System.out.println();
   }
   
   public static void paragraph33() {
      System.out.println ("She swallowed the bird to catch the spider,");
      paragraph22();
   }
   
   public static void paragraph4() {
      System.out.println ("There was an old woman who swallowed a cat,");
      System.out.println ("Imagine that to swallow a cat.");
      paragraph44();
      System.out.println();
   }
   
   public static void paragraph44() {
      System.out.println ("She swallowed the cat to catch the bird,");
      paragraph33();
   }
   
   public static void paragraph5() {
      System.out.println ("There was an old woman who swallowed a dog,");
      System.out.println ("What a hog to swallow a dog.");
      paragraph55();
      System.out.println();
   }
   
   public static void paragraph55() {
      System.out.println ("She swallowed the dog to catch the cat,");
      paragraph44();
   }
   
   public static void paragraph6() {
      System.out.println ("There was an old woman who swallowed a pig,");
      System.out.println ("Where did she find a pig?");
      paragraph66();
      System.out.println();
   }
   
   public static void paragraph66() {
      System.out.println ("She swallowed the pig to catch the dog");
      paragraph55();
   }

   public static void repeated(){
      System.out.println ("I don't know why she swallowed that fly,");
      System.out.println ("Perhaps she'll die.");
   }
   
   public static void end(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
}