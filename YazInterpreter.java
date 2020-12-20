// Lesi Li
// 8/1/2020
// CSE 142
// TA: Joe Lang
// Assignment 6 YazInterpreter
/*descriptions: This program mainly have three functions:
Interpre; view; and quit. For the interpret option,
user can first imput a file. If the file name is imports 
correctly and exists on the computer, the computer can 
read the file. Otehr wise, it would says file not found. 
After inputting the correct file name, the system will ask
to have an output file. In this case, a new file would be
created successfully. For the view option, user can view 
the file they want by typing the corresponding file name.
After that, the content of that file would be showing out.
Once the user type "q", the system would be end.
*/

import java.util.*;
import java.io.*;

public class YazInterpreter {

   public static void main(String[] args)  throws FileNotFoundException{
   
      Scanner console = new Scanner(System.in);
   
      intro();
      
      System.out.print("(I)nterpret .yzy program, (V)iew .yzy output, (Q)uit? ");
   
      String choice = console.next();
   
      while (!choice.equalsIgnoreCase("Q")) {
         if (choice.equalsIgnoreCase("I")) {
            interpret(console);
            System.out.println();
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy output, (Q)uit? ");
            choice = console.next(); 
         } else if (choice.equalsIgnoreCase("V")) {
            view(console);
            System.out.println();
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy output, (Q)uit? ");
            choice = console.next(); 
         } else {  
            System.out.print("(I)nterpret .yzy program, (V)iew .yzy output, (Q)uit? ");
            choice = console.next();  
         }
      }
      
   }
   
  //This is the introduction part of the whole system.
   public static void intro() {
      System.out.println("Welcome to YazInterpreter!");
      System.out.println("You may interpret a YazLang program and output");
      System.out.println("the results to a file or view a previously");
      System.out.println("interpreted YazLang program.");
      System.out.println();
   }
   
   //This method main to help reduce the redundant part. 
   //Which is the repeat process of chooing i; v; and q.
   //Also the "input file name" part and "file not found"
   //part.
   //Scanner console is a parameter that help to input something.
   //We throws the filenotfound exception to prevent error.
   //A return statement to return a scanner of a required file
   //in the homework, which can help to read that input file 
   //in the latter method.
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
   
   //The method is the interpret part.
   //Is main to make to output method.
   //Scanner console is a parameter that help to input something.
   //We throws the filenotfound exception to prevent error.
   public static void interpret (Scanner console) throws FileNotFoundException {   
   
      Scanner input = process(console);
   
      System.out.print("Output file name: ");
      String newName = console.next();
      PrintStream output = new PrintStream(new File(newName));
      System.out.println("YazLang interpreted and output to a file!");
      
      changeFile(console,input,output);
     
   }
      
   //This method is the process to change the 
   //content of the input file from the homework to 
   //the according format.
   //Scanner console is a parameter that help to input something.
   //Scanner input is a parameter of the file name read in the "process()"method.
   //PrintStream output is a parameter refering to our output file and help to 
   //store what we want in that output txt file.
   //We throws the filenotfound exception to prevent error.
   public static void changeFile(Scanner console, Scanner input, PrintStream output)
   throws FileNotFoundException {
      
      Scanner changF = input;       
   
      while (changF.hasNextLine()) {
      
         String line=changF.nextLine();
         Scanner tokens = new Scanner(line);
         String type = tokens.next();
      
         if (type.equals("RANGE")) {
            range(tokens,output);
         } else if (type.equals("CONVERT")) {
            convert(tokens,output);
         } else {
            repeat(tokens,output);
         }
      }
      
   }
   
   //This method is the view part.
   //After user inputing the correct file name
   //in the process method, this method here
   //will help to print out the content of that file.
   //Scanner console is a parameter that help to input something.
   //We throws the filenotfound exception to prevent error.
   public static void view(Scanner console) throws FileNotFoundException {
      Scanner inputView = process(console);
      System.out.println("");
      while (inputView.hasNextLine()) {
         String printLine = inputView.nextLine();
         System.out.println(printLine);
      }
   
   }
   
   //This method is the changing part of the range.
   //Increasing the first number by the third number
   //until it reach to the second number.
   //Scanner tokens is a parameter that refer to that specific line.
   //PrintStream output is a parameter to help store the change
   //in to that output file.
   public static void range(Scanner tokens, PrintStream output) {
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
   
   //This method is the changing part of the convert.
   //Converting C to F or vice versa.
   //Scanner tokens is a parameter that refer to that specific line.
   //PrintStream output is a parameter to help store the change
   //in to that output file.   
   public static void convert(Scanner tokens, PrintStream output){
      int tem = tokens.nextInt();
      String temp = tokens.next();
      if (temp.equalsIgnoreCase("C")){
         double fTemp =  (1.8*tem)+32;
         int f = (int) fTemp;
         output.println(f + "F");
      } else {
         double cTemp =  (tem-32) / 1.8;
         int c = (int) cTemp;
         output.println(c + "C");
      }
   }
   
    //This method is the changing part of the repeat.
    //Repeat each word by the times of the number following.
   //Scanner tokens is a parameter that refer to that specific line.
   //PrintStream output is a parameter to help store the change
   //in to that output file.
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
   
