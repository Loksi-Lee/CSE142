// Lesi Li
// 07/18/2020
// CSE 142
// TA: Joe Lang
// Assignment #4 Budgeter
/*descriptions: This program aim to calculate
people total income and total expenses a month.
Through the calculation, people can know whether
the spend more than earn or earn more than spend.
*/


import java.util.*;

public class Budgeter {

//days represent the total days of a month
//By setting a counstant at the begining,
//We can change the value base on different month
//and get the corresponding value of the income 
//per day or expenses per day
   public static final int DAYS = 31;

   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
   
      intro();
     
      double Income = getMoney(console, "income");
      
      int Choice = Cho(console);
      
      double Expenses = getMoney(console, "expense");      
      
      printTolIn(Income);
      
      double TolExp = printTolExp(Expenses, Choice);
      
      printResult(Income, TolExp);
   
   }
   
   //This is the introduction part of the system
   public static void intro() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println(); 
   }
  
   
   //This part helps to print out the main input part of the system
   //By making a "String name" as a parameter, we can change the 
   //information of the output by putting the name that we 
   //want to print out in the main.
   public static double getMoney(Scanner console, String name) {
      System.out.print("How many categories of " + name +"? ");
      
      int numCate = console.nextInt();
    
      double totalMoney = 0;
      for (int i=1; i <= numCate; i++) {
         System.out.print("    Next " + name +" amount? $");
         double Money = console.nextDouble();
      
         totalMoney = totalMoney + Money;
      }
      System.out.println();
      
      return totalMoney;
   }
   
   //This method mainly helps to get the number of  
   //choice that whether people expenses is daily
   //or monthly.
   public static int Cho (Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int cho = console.nextInt();
      return cho;
   }
    
//The method here is to help print out the total income
//and income per day base on the calculations that
//total income divided by the constant
//I use a parameter "Income" that is referenced from
//the main method
   public static void printTolIn (double Income) {

      double InpDay =  Income/DAYS;
      System.out.println("Total income = $"+ round2(Income) +
                         " ($" + round2(InpDay) + "/day)");
  }
  
 //This method here is to help print out the total expenses
 //Expenses is the expenses base on our inport.
 //Choice here is the value that whether people choose daily
 //or monthly.
 //MTolExpenses is the month total expenses
 //ExppDay means Expense per day
 //If people chooce to input the value of monthly expenses
 //Then Month total expenses = Expenses
 //And thus expense per day = total expenses/total days
 //if and else if statement here is to help print the 
 //correct expenses base on daily or monthly.
 //I return the value of tolal expenses that is
 //use for calculate the Net between income and 
 //expenses in the next method.
  public static double printTolExp (double Expenses,int Choice) {

      double MTolExpenses = round2(Expenses);
      double ExppDay = round2(Expenses/DAYS);
     
      double DTolExpenses = round2(Expenses*DAYS);
      
      double TolExpenses = 0.0;   

      if (Choice == 1) {
         System.out.println("Total expenses = $"+ round2(MTolExpenses) 
                             + " ($" + round2(ExppDay) + "/day)");
         TolExpenses = TolExpenses + round2(MTolExpenses);
      } else if (Choice ==2) {
         System.out.println("Total expenses = $" + round2(DTolExpenses) 
                    + " ($" + round2(Expenses) + "/day)");
         TolExpenses = TolExpenses + round2(DTolExpenses);
      }
      
      System.out.println();
      
      return TolExpenses;
      }
 
 //This method main to print the result about whether
 //spend more or earn more base on the different
 //between total income and expeses.
 //In is the total month income.
 //Exp is the total month expenses.
 //If and else if statement here is to print
 //out the correct output base on Net.
      public static void printResult(double In, double Exp) {
      
      double Net = In - Exp;
      Net = round2(Net);
      
      if (Net > 250) { 
         System.out.println("You earned $" + Net+ " more than you spent this month."); 
         System.out.println("You're a big saver.");
         System.out.println("You did a good job in this Month!"); 
      } else if (Net>0 && Net<250 ) { 
         System.out.println("You earned $" + Net+ " more than you spent this month."); 
         System.out.println("You're a saver."); 
         System.out.println("Well, not too bad, we do need to spend money sometimes.");
      } else if (Net> -250 && Net<=0){ 
         Net = Math.abs(Net);
         System.out.println("You spent $" +  Net + " more than you earned this month."); 
         System.out.println("You're a spender."); 
         System.out.println("Don't remember your goal of saving money!");
      } else if(Net  < -250) { 
         Net = Math.abs(Net);
         System.out.println("You spent $" + Net + " more than you earned this month.");   
         System.out.println("You're a big spender."); 
         System.out.println("Wow, you really need to start to save money!");
      }   
      
   }   
  
//This method is to help the number round
//to two decimal.   
   public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
  
}




