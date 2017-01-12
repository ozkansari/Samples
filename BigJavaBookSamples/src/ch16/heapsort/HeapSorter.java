package ch16.heapsort;

/**
   This class applies the heapsort algorithm to sort an array.
*/
public class HeapSorter
{
   /**
      Constructs a heap sorter that sorts a given array.
      @param anArray an array of integers
   */
   public HeapSorter(int[] anArray)
   {
      a = anArray;
   }   

   /**
      Sorts the array managed by this heap sorter.
   */
   public void sort()
   {  
      int n = a.length - 1;
      for (int i = (n - 1) / 2; i >= 0; i--)
         fixHeap(i, n);
      while (n > 0)
      {
         swap(0, n);
         n--;
         fixHeap(0, n);
      }
   }

   /**
      Ensures the heap property for a subtree, provided its
      children already fulfill the heap property.
      @param rootIndex the index of the subtree to be fixed
      @param lastIndex the last valid index of the tree that 
      contains the subtree to be fixed
   */
   private void fixHeap(int rootIndex, int lastIndex)
   {
      // Remove root
      int rootValue = a[rootIndex];

      // Promote children while they are larger than the root      

      int index = rootIndex;
      boolean more = true;
      while (more)
      {
         int childIndex = getLeftChildIndex(index);
         if (childIndex <= lastIndex)
         {
            // Use right child instead if it is larger
            int rightChildIndex = getRightChildIndex(index);
            if (rightChildIndex <= lastIndex
                  && a[rightChildIndex] > a[childIndex])
            {
               childIndex = rightChildIndex;
            }
            
            if (a[childIndex] > rootValue) 
            {
               // Promote child
               a[index] = a[childIndex];
               index = childIndex;
            }
            else
            {
               // Root value is larger than both children
               more = false;
            }
         }
         else 
         {
            // No children
            more = false; 
         }
      }

      // Store root value in vacant slot
      a[index] = rootValue;
   }

   /**
      Swaps two entries of the array.
      @param i the first position to swap
      @param j the second position to swap
   */
   private void swap(int i, int j)
   {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
      Returns the index of the left child.
      @param index the index of a node in this heap
      @return the index of the left child of the given node
   */
   private static int getLeftChildIndex(int index)
   {
      return 2 * index + 1;
   }

   /**
      Returns the index of the right child.
      @param index the index of a node in this heap
      @return the index of the right child of the given node
   */
   private static int getRightChildIndex(int index)
   {
      return 2 * index + 2;
   }

   private int[] a;
}
