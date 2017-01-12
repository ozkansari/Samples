package ch07.regression;

import java.util.Scanner;

/**
   This program tests the Bank class.
*/
public class BankTester
{
   public static void main(String[] args)
   {
      Bank firstBankOfJava = new Bank();
      firstBankOfJava.addAccount(new BankAccount(1001, 20000));
      firstBankOfJava.addAccount(new BankAccount(1015, 10000));
      firstBankOfJava.addAccount(new BankAccount(1729, 15000));

      Scanner in = new Scanner(System.in);
      
      double threshold = in.nextDouble();
      int c = firstBankOfJava.count(threshold);
      System.out.println("Count: " + c);
      int expectedCount = in.nextInt();
      System.out.println("Expected: " + expectedCount);
      
      int accountNumber = in.nextInt();
      BankAccount a = firstBankOfJava.find(accountNumber);
      if (a == null)
         System.out.println("No matching account");         
      else
      {         
         System.out.println("Balance of matching account: " + a.getBalance());
         int matchingBalance = in.nextInt();
         System.out.println("Expected: " + matchingBalance);
      }
   }
}
