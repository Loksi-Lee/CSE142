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

public class Budgeterno {

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
      
      printtotal(Income, Expenses, Choice);      
   
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
    //int c = cho;
      return cho;
   }
    
//I set three parameters here, those are income, expenses and choice
//These three are the variable that I already defined in the main
//This method mainly use to print out the output of counting 
//the total income and expenses and know whether spend more or
//earn more in a more direct way.
   public static void printtotal (double Income, double Expenses, int Choice) {
   
   //InpDay helps to calculate the value of income per day
   //Income per day = total income divided by total days 
      double InpDay =  Income/DAYS;
      System.out.println("Total income = $"+ round2(Income) +
                         " ($" + round2(InpDay) + "/day)");
   
   //MTolExpenses is the month total expenses
   //ExppDay means Expense per day
   //If people chooce to input the value of monthly expenses
   //Then Month total expenses = Expenses
   //And thus expense per day = total expenses/total days
      double MTolExpenses = round2(Expenses);
      double ExppDay = round2(Expenses/DAYS);
     
    //DTolExpenses is the month total expenses base 
    //on daily count
    //If people inset the daily expenses, then
    //Month total expense equal to daily expense 
    //times total days in a month
      double DTolExpenses = round2(Expenses*DAYS);
      
      double TolIncome = round2(Income);
      
      double TolExpenses = 0.0;   
      
      //I use a if and else if statement here
      //to seperate the calculation of the expenses
      //Choice == 1 means people choose the monthly expenses
      //and Choice == 2 means people choose the daily expenses
      //Since daily and monthly expenses would produce different
      //result. Therefore, if and else if statement here can
      //help to seperate them and produce the correct
      //amount base of the above formula.
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
      
      //Net here is a variable that helps to
      //calculate the different of total 
      //income and total expenses.
      double Net = TolIncome - TolExpenses;
      Net = round2(Net);
      
      //The amount of difference between the income
      //and expenses help let you know whether you
      //spend more or earn more.
      //The different of the value causes to different 
      //output.
      //Therefore, I use if and else if method to
      //seperate them base on the value of the Net. 
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




