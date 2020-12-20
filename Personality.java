// Lesi Li
// 8/9/2020
// CSE 142
// TA: Joe Lang
// Assignment 7
/*descriptions: This program is a personality test.
There are 7 questions and 10 groups of questions in total.
Each questions correspond to the specific type of personality.
This program aim to analysis what kind of personality you have
base on the answer of each of the question.
*/

import java.util.*;
import java.io.*;

public class Personality {

   //This constant is the matrix size.
   public static final int SIZE = 4;

   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner console = new Scanner(System.in);
   
      intro();
   
      System.out.print("input file name? ");
      String fileName = console.nextLine();
      Scanner inputFile = new Scanner (new File(fileName));
      
      System.out.print("output file name? ");
      String newName = console.nextLine();
      PrintStream output = new PrintStream(new File(newName));
      
      //read the input file
      while (inputFile.hasNextLine()) {
         String name=inputFile.nextLine();
         String line=inputFile.nextLine();
         
         int[] counts = countsResult(line);
         getResults(line,name,output);
      }   
   }
   
   
   //This is the introduction part of the program.
   public static void intro(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //This method mainly help to make the final array 
   //which counts the percentage of B answer over total.
   //String l is the parameter which we read the file
   //from the input file in main. 
   //A return statement to return an array of the required array.
   //I first creat Array A and Array B
   //After constructing these two array,
   //I create the require array by using
   //array B to divided by the total of array A + B.
   public static int[] countsResult (String l) {
      
      int[] countsA = new int[SIZE];
      int[] countsB = new int [SIZE];
      
      for (int i=0; i < l.length(); i++) {
      
         String w = l.charAt(i) + "";
         
         if (w.equalsIgnoreCase("A")) {
         
            process(countsA,i); 
           
         } else if(w.equalsIgnoreCase("B")) {
         
            process(countsB,i);
            
         } 
      }
      
      int [] result = new int[SIZE];
      
      for (int i=0; i< countsB.length; i++) {
         result[i] = (int) round ((double) countsB[i]/(double) (countsA[i]+countsB[i]));
      }
      return result;
   } 
   


   //This method main to help to identify 
   //each type of problem.
   //By using mod inside the if/else if loop,
   //we can apply each question to the corresponding index.
   //int[] arr is the parameter that helps to read the A/B array
   //int times is a parameter that helps to read the character place.
   //So, the resule of matrix A and matrix B can bu accumulate by
   //adding each number in the process method by using the parameter.
   public static void process (int[] arr, int times) {
      
      if (times % 7 == 0) {
         arr[0]++;
      } else if (times % 7 == 1 || times % 7 == 2) {
         arr[1]++;
      } else if (times % 7 == 3 || times % 7 == 4) {
         arr[2] ++;
      } else { 
         arr[3] ++;
      }
   
   }
   
   //This method is to help identify the personal type
   //base on the number on the final array.
   //String l is the parameter that read the answer line
   //form the input file.
   //String n is the parameter that helps to the the name 
   //from the input file
   //PrintStream output is a parameter refering to our output  
   //file and help to store what we want in that output txt file.
   public static void getResults (String l, String n, PrintStream output) {
     
      int[] resultArray = countsResult(l);
      String [] bigger = {"I","N","F","P"};
      String [] smaller = {"E","S","T","J"};
      String type = "";
      
      for (int i=0; i<resultArray.length; i++) {
         if (resultArray[i] > 50) {
            type += bigger[i];
         } else if (resultArray[i] < 50) {
            type += smaller[i];
         } else {
            type += "X";
         }
      }
      output.println(n + ": " + Arrays.toString(resultArray) + " = " + type);
   
   }
   
   //This method is to help the number round
   //to whole integer.  
   public static double round (double num) {  
   return Math.round(num * 100);  
   }

}
   
   
