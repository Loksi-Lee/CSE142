// Yazzy Latif
// 7/29/2020
// CSE142
// TA: Grace Hopper

// This program reads in a roster of course staff members and computes and outputs
//   each person's pay for the week. Each type of staff member is paid using a
//   different model.
//
// DEVELOPMENT NOTES:
// (These notes would not be in your program's comments. They are here
// to help you understand important topics or elements of this code.)
//
// Notice the use of line-based file input in main, and the use of a Scanner
//   to tokenize a String in the pay methods.
//
// Although we have methods calling each other in a row, this program is NOT 
//   an example of chaining, because the structure of the code accurately
//   reflects the task being performed, and main remains a concise overall
//   summary of the behavior.

/*
Scratchwork:
   Input line format:
      empolyeeType employeeName arguments/parameters
*/

import java.util.*;
import java.io.*;

public class Payroll {

   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(new File("employees.txt"));
      PrintStream output = new PrintStream(new File("summary.txt"));
      
      output.println("Here is this week's summary of the payroll:");
            
      while (input.hasNextLine()) {
         String employeeLine = input.nextLine();

         // determine their role
         process(employeeLine, output);
      }
   }
   
   // Processes an employee text string
   // 
   // String employee - the employee to determine pay for
   public static void process (String employeeLine, PrintStream output) {
      if (employeeLine.startsWith("Instructor")) {
         payInstructor(employeeLine, output);
      } else if (employeeLine.startsWith("Grader")) {
         payGrader(employeeLine, output);
      } else if (employeeLine.startsWith("TA")) {
         payTA(employeeLine, output);
      }
   }
   
   // Computes and outputes the pay for an instructor; instructors get paid a flat
   //   amount per week
   // Instructor input will consist of the employee type, a name, and the weekly pay
   //   rate for that instructor
   //   
   // String instructor - the input for the instructor to pay
   public static void payInstructor(String instructor, PrintStream output) {
      Scanner tokens = new Scanner(instructor);
      String employeeType = tokens.next();
      String employeeName = tokens.next();
      double pay = tokens.nextDouble();
      
      output.println(employeeName + " (" + employeeType + ") was paid $" + pay + " this week");
   }
   
   
   // Computes and outputes the pay for a grader; graders get paid a given amount
   //   for each student they grade
   // Grader input will consist of the employee type, a name, and the number of
   //   students graded, and the pay per student for that grader
   //
   // String grader - the input for the grader to pay
   public static void payGrader(String grader, PrintStream output) {
      Scanner tokens = new Scanner(grader);
      String employeeType = tokens.next();
      String employeeName = tokens.next();
      
      int numStudents = tokens.nextInt();
      double payRate = tokens.nextDouble();
      
      double pay = numStudents * payRate;
      
      output.println(employeeName + " (" + employeeType + ") was paid $" + pay + " this week");

   }
   
   // Computes and outputes the pay for a TA; TAs get paid $15/hour and can work any 
   //   number of days
   // TA input will consist of the employee type, a name, and some number of values
   //   representing the hours worked on each of several days
   // 
   // String ta - the input for the TA to pay
   public static void payTA(String ta, PrintStream output) {
      Scanner tokens = new Scanner(ta);
      String type = tokens.next();
      String name = tokens.next();
      
      int hours = 0;
      while (tokens.hasNextInt()) {
         hours += tokens.nextInt();
      }
      
      double pay = hours * 15.00;      
      output.println(name + " (" + type + ") earned $" + pay + " this week.");
   } 
   
   
   
}

//////
   public static void view (Scanner console, String choice, Scanner input) {
   
      while (!choice.equalsIgnoreCase("V")) {
         System.out.print("(I)nterpret .yzy program, (V)iew .yzy program, (Q)uit? ");
         choice = console.next(); 
      }
      System.out.print("Input file name: ");
      String name = console.next();
      showfile(input);  
   }
   
   public static void showfile(Scanner input) {
      while (input.hasNextLine) {
         String type = input.Next();
      
      
         if (type.equals("RANGE")) {
            range(input);
         } else if (type.equals("CONVERT")) {
            convert(input);
         } else {
            repeat(input);
         
         }
      
      }
   }
   
   public static void range(Scanner input){
      Int numF = input.nextInt();
      Int numS = input.nextInt();
      Int numT = input.nextInt();
      System.out.print(numF);
      while (numF<=numT) {
         numF = numF + numT;
         System.out.print("" + numF);
      }
   }
   
}

/////
   public static void process (Scanner console) throws FileNotFoundException {
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
         } //else if (choice.equalsIgnoreCase("Q")) {    
      }
   }