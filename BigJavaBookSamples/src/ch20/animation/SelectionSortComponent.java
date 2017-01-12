package ch20.animation;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
   A component that displays the current state of the selection sort algorithm.
*/
public class SelectionSortComponent extends JComponent
{
   /**
      Constructs the component.
   */
   public SelectionSortComponent()
   {
      int[] values = ArrayUtil.randomIntArray(30, 300);
      sorter = new SelectionSorter(values, this);
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D)g;
      sorter.draw(g2);
   }

   /**
      Starts a new animation thread.
   */
   public void startAnimation()
   {
      class AnimationRunnable implements Runnable
      {
         public void run()
         {
            try
            {
               sorter.sort();
            }
            catch (InterruptedException exception)
            {
            }
         }
      }
      
      Runnable r = new AnimationRunnable();
      Thread t = new Thread(r);
      t.start();
   }

   private SelectionSorter sorter;
}

