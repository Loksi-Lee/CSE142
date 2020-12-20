// Lesi Li
// 07/18/2020
// CSE 142
// TA: Joe Lang
// Assignment #4 Budgeter
/*descriptions: 
*/


import java.util.*;

public class Budgeter2 {

   public static final int days = 31;

   public static void main (String[] args) {
      Scanner console = new Scanner(System.in);
   
      intro();
      //double Income = getMoney(console, "income");
      
      //System.out.print("Enter 1) monthly or 2) daily expenses?");
     // int Choice = console.nextInt();
      
      
     //double Expenses = getMoney(console, "expenses");
      
      output(console);
     // printTotal(Income, Expenses);
      
   
   }
   
   public static void intro() {
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println(); 
   }
   
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
    

   
   public static void output (Scanner console) {
   
      double Income = getMoney(console, "income");
      
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int Choice = console.nextInt();
      
      
      double Expenses = getMoney(console, "expense");
   
      double InpDay =  Income/days;
      System.out.println("Total income = $"+ round2(Income) +" ($" + round2(InpDay) + "/day)");
   
      double MTolExpenses = round2(Expenses);
      double ExppDay = round2(Expenses/days);
      
      double DTolExpenses = round2(Expenses*days);
      
      double TolIncome = round2(Income);
       
      double TolExpenses = 0.0;    
      if (Choice == 1) {
         System.out.println("Total expenses = $"+ round2(MTolExpenses) + " ($" + round2(ExppDay) + "/day)");
          TolExpenses = TolExpenses + round2(MTolExpenses);
      } else if (Choice ==2) {
         System.out.println("Total expenses = $" + round2(DTolExpenses) + " ($" + round2(Expenses) + "/day)");
          TolExpenses = TolExpenses + round2(DTolExpenses);
      }
      
      System.out.println();
      
      double Net = TolIncome - TolExpenses;
      Net = round2(Net);
      
           if (Net > 250) { 
         System.out.println("You earned $" + Net+ " more than you spent this month"); 
         System.out.println("You're a big saver"); 
       } else if (Net>0 && Net<250 ) { 
         System.out.println("You earned $" + Net+ " more than you spent this month"); 
          System.out.println("You're a saver"); 
      } else if (Net> -250 && Net<0){ 
         Net = Math.abs(Net);
         System.out.println("You spent $" +  Net + " more than you earned this month"); 
         System.out.println("You're a spender"); 
      } else if(Net  < -250) { 
         Net = Math.abs(Net);
         System.out.println("You spent $" + Net + " more than you earned this month.");   
         System.out.println("You're a big spender."); 
     }   
      
   }   
  
   
   public static double round2(double num) {
      return Math.round(num * 100.0) / 100.0;
   }
  
}




