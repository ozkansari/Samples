package ch06.random2;

import java.util.Random;

/**
   This class simulates a needle in the Buffon needle experiment.
*/
public class Needle
{
   /**
      Constructs a needle.
   */
   public Needle()
   {
      hits = 0;
      tries = 0;
      generator = new Random();
   }

   /**
      Drops the needle on the grid of lines and 
      remembers whether the needle hit a line.
   */
   public void drop()
   {
      double ylow = 2 * generator.nextDouble();
      double angle = 180 * generator.nextDouble();
      
      // Computes high point of needle
      
      double yhigh = ylow + Math.sin(Math.toRadians(angle));
      if (yhigh >= 2) hits++;    
      tries++;
   }

   /**
      Gets the number of times the needle hit a line.
      @return the hit count
   */
   public int getHits()
   {
      return hits;
   }

   /**
      Gets the total number of times the needle was dropped.
      @return the try count
   */
   public int getTries()
   {
      return tries;
   }
        
   private Random generator;
   private int hits;
   private int tries;
}
