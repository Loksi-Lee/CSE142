// Lesi Li
// 8/1/2020
// CSE 142
// TA: Joe Lang
// Assignment 6 YazInterpreter
/*descriptions: 
*/

import java.util.*;
import java.io.*;

public class YazInterpreterold {

   public static void main(String[] args)  throws FileNotFoundException{
   
      Scanner console = new Scanner(System.in);
   
      intro();
      
      System.out.print("(I)nterpret .yzy program, (V)iew .yzy program, (Q)uit? ");
   
      String choice = console.next();
   
      while (!choice.equalsIgnoreCase("Q")) {
         if (choice.equalsIgnoreCase("I")) {
            interpret(console);
            System.out.println();
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy program, (Q)uit? ");
            choice = console.next(); 
         } else if (choice.equalsIgnoreCase("V")) {
            view(console);
            System.out.println();
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy program, (Q)uit? ");
            choice = console.next(); 
         } else {  
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy program, (Q)uit? ");
            choice = console.next();  
         }
      }
      
      //process(console);
   }

   public static void intro() {
      System.out.println("Welcome to YazInterpreter!");
      System.out.println("You may interpret a YazLang program and output");
      System.out.println("the results to a file or view a previously");
      System.out.println("interpreted YazLang program.");
      System.out.println();
   }
      
   public static Scanner process (Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      String name = console.next();
      
      File fileName = new File(name);
      
      while (!fileName.exists()) {
         System.out.print("File not found. Try again: ");
         name = console.next();
         fileName = new File(name);
      }
      
      Scanner inputFile = new Scanner (fileName); 
      
      return inputFile;
   }
   
   public static void interpret (Scanner console) throws FileNotFoundException {   
   
      Scanner input = process(console);
   
      System.out.print("Output file name: ");
      String newName = console.next();
      PrintStream output = new PrintStream(new File(newName));
      System.out.println("YazLang interpreted and output to a file!");
      
      //Scanner changF = process(console);       
   
      while (input.hasNextLine()) {
      
         String line=input.nextLine();
         Scanner tokens = new Scanner(line);
         String type = tokens.next();
      
         if (type.equals("RANGE")) {
            range(tokens,output);
         } else if (type.equals("CONVERT")) {
            convert(tokens,output);
            //System.out.println("");
         } else {
            repeat(tokens,output);
            System.out.println("");
         }
      }
      
   }
   
   public static void view(Scanner console) throws FileNotFoundException {
      Scanner inputView = process(console);
      System.out.println("");
      while (inputView.hasNextLine()) {
         String printLine = inputView.nextLine();
         System.out.println(printLine);
      }
   
   }
   
   public static void range(Scanner tokens, PrintStream output){
      int numF = tokens.nextInt();
      int numS = tokens.nextInt();
      int numT = tokens.nextInt();
      output.print(numF);
      while (numF< numS-numT) {
         numF = numF + numT;
         output.print(" " + numF);
      }
      output.println("");
   }
   
   public static void convert(Scanner tokens, PrintStream output){
      int tem = tokens.nextInt();
      String temp = tokens.next();
      if (temp.equals("C")){
         double fTemp =  (1.8*tem)+32;
         int f = (int) fTemp;
         output.println(f + "F");
      } else {
         double cTemp =  (tem-32) / 1.8;
         int c = (int) cTemp;
         output.println(c + "C");
      }
   }
   
   public static void repeat(Scanner tokens, PrintStream output){
     
      while(tokens.hasNext()) {
         String letter = tokens.next();
         int counts = tokens.nextInt();
         letter = letter.replace("_"," ");
         letter = letter.substring(1,letter.length()-1);
         
         for (int i=0; i<counts; i++) {
            output.print(letter);
         }
      }
      output.println("");
   }
}
   
