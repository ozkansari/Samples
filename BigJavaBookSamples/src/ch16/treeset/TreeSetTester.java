package ch16.treeset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
   A program to test a tree set with a comparator for coins.
*/
public class TreeSetTester
{
   public static void main(String[] args)
   {
      Coin coin1 = new Coin(0.25, "quarter");
      Coin coin2 = new Coin(0.25, "quarter");
      Coin coin3 = new Coin(0.01, "penny");
      Coin coin4 = new Coin(0.05, "nickel");

      class CoinComparator implements Comparator<Coin>
      {
         public int compare(Coin first, Coin second)
         {
            if (first.getValue() < second.getValue()) return -1;
            if (first.getValue() == second.getValue()) return 0;
            return 1;
         }
      }

      Comparator<Coin> comp = new CoinComparator();
      Set<Coin> coins = new TreeSet<Coin>(comp);
      coins.add(coin1);
      coins.add(coin2);
      coins.add(coin3);
      coins.add(coin4);

      for (Coin c : coins)
         System.out.print(c.getValue() + " ");
      System.out.println("Expected: 0.01 0.05 0.25");
   }
}
