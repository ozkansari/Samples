package ch07.arraylist;

import java.util.ArrayList;

/**
   This program tests the ArrayList class.
*/
public class ArrayListTester
{
   public static void main(String[] args)
   {
      ArrayList<BankAccount> accounts 
            = new ArrayList<BankAccount>();
      accounts.add(new BankAccount(1001));
      accounts.add(new BankAccount(1015));
      accounts.add(new BankAccount(1729));
      accounts.add(1, new BankAccount(1008));
      accounts.remove(0);

      System.out.println("Size: " + accounts.size());
      System.out.println("Expected: 3");
      BankAccount first = accounts.get(0);
      System.out.println("First account number: " 
            + first.getAccountNumber());
      System.out.println("Expected: 1008");                  
      BankAccount last = accounts.get(accounts.size() - 1);
      System.out.println("Last account number: " 
            + last.getAccountNumber());
      System.out.println("Expected: 1729");                  
   }
}
