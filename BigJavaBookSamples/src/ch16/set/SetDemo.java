package ch16.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
   This program demonstrates a set of strings. The user 
   can add and remove strings.
*/
public class SetDemo
{
   public static void main(String[] args)
   {
      Set<String> names = new HashSet<String>();
      Scanner in = new Scanner(System.in);

      boolean done = false;
      while (!done)
      {
         System.out.print("Add name, Q when done: ");
         String input = in.next();
         if (input.equalsIgnoreCase("Q")) 
            done = true;
         else
         {
            names.add(input);
            print(names);
         }
      }

      done = false;
      while (!done)
      {
         System.out.print("Remove name, Q when done: ");
         String input = in.next();
         if (input.equalsIgnoreCase("Q")) 
            done = true;
         else
         {
            names.remove(input);
            print(names);
         }
      }
   }

   /**
      Prints the contents of a set of strings.
      @param s a set of strings
   */
   private static void print(Set<String> s)
   {
      System.out.print("{ ");
      for (String element : s)
      {
         System.out.print(element);
         System.out.print(" ");
      }
      System.out.println("}");      
   }
}


