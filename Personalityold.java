// Lesi Li
// 8/9/2020
// CSE 142
// TA: Joe Lang
// Assignment 6 
/*descriptions: 
*/

import java.util.*;
import java.io.*;

public class Personalityold {
   public static final int SIZE = 4;

   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner console = new Scanner(System.in);
   
      intro();
   
      System.out.print("input file name? ");
      String fileName = console.next();
      Scanner inputFile = new Scanner (new File(fileName));
      
      System.out.print("output file name? ");
      String newName = console.next();
      PrintStream output = new PrintStream(new File(newName));
      
      while (inputFile.hasNextLine()) {
         String name=inputFile.nextLine();
         String line=inputFile.nextLine();
         
         int[] counts = countsResult(line);
         System.out.println(Arrays.toString(counts));
         getResults(line,name,output);
      }   
   }
   
   public static void intro(){
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   public static int[] countsResult (String l) {
      
      int[] countsA = new int[SIZE];
      int[] countsB = new int [SIZE];
      
      for (int i=0; i < l.length(); i++) {
      
         String w = l.charAt(i) + "";
         
         if (w.equalsIgnoreCase("A")) {
         
            int[] a = new int[SIZE];
            a = process(l,i); 
            
            for (int j=0; j < SIZE; j++) {
            countsA[j] += a[j];
            }
          
         } else if(w.equalsIgnoreCase("B")) {
         
            int[] b = new int[SIZE];

            b = process(l,i);
            
            for (int j=0; j < SIZE; j++) {
            countsB[j] += b[j];
            }
            
         } 
      }
      
      int[] result = new int[SIZE];
      
      for (int i=0; i< countsB.length; i++) {
         result[i] =(int)Math.round(countsB[i]/(double) (countsA[i]+countsB[i]) * 100);
      }
      return result;
   } 
   
   public static int[] process (String l, int times) {
   
      int[] countsSingle = new int [SIZE];  
      
         if (times % 7 == 0) {
            countsSingle[0]++;
         } else if (times % 7 == 1 || times % 7 == 2) {
            countsSingle[1]++;
         } else if (times % 7 == 3 || times % 7 == 4) {
            countsSingle[2] ++;
         } else { 
            countsSingle[3] ++;
         }
      
      return countsSingle;
   }
   
   
   public static void getResults (String l, String n, PrintStream output) {
      int[] resultArray = countsResult(l);
   
      String typeF = "";
      if (resultArray[0] < 50) {
         typeF = "E";
      } else if (resultArray[0] > 50) {
         typeF = "I";
      } else {
         typeF = "X";
      }
    
      String typeS = "";
      if (resultArray[1] < 50) {
         typeS = "S";
      } else if (resultArray[1] > 50) {
         typeS = "N";
      } else {
         typeS = "X";
      }
      
      String typeT = "";
      if (resultArray[2] < 50) {
         typeT = "T";
      } else if (resultArray[2] > 50) {
         typeT = "F";
      } else {
         typeT = "X";
      }
      
      String typeFo = "";
      if (resultArray[3] < 50) {
         typeFo = "J";
      } else if (resultArray[3] > 50) {
         typeFo = "P";
      } else {
         typeFo = "X";
      }
   
      output.println(n + ": " + Arrays.toString(countsResult) + " = " + typeF 
        + typeS + typeT + typeFo);
   }

}
   
   
