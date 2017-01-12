package ch16.heapsort;

/**
   This program demonstrates the heapsort algorithm.
*/
public class HeapSortDemo
{  
   public static void main(String[] args)
   {  
      int[] a = ArrayUtil.randomIntArray(20, 100);
      ArrayUtil.print(a);
      HeapSorter sorter = new HeapSorter(a);
      sorter.sort();
      ArrayUtil.print(a);
   }
}
