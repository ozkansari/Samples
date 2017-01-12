package ch17.genlist;

/**
   A program that tests the LinkedList class
*/
public class ListTester
{  
   public static void main(String[] args)
   {  
      LinkedList<String> staff = new LinkedList<String>();
      staff.addFirst("Tom");
      staff.addFirst("Romeo");
      staff.addFirst("Harry");
      staff.addFirst("Dick");
      
      // | in the comments indicates the iterator position

      ListIterator<String> iterator = staff.listIterator(); // |DHRT
      iterator.next(); // D|HRT
      iterator.next(); // DH|RT

      // Add more elements after second element
      
      iterator.add("Juliet"); // DHJ|RT
      iterator.add("Nina"); // DHJN|RT

      iterator.next(); // DHJNR|T

      // Remove last traversed element 

      iterator.remove(); // DHJN|T
     
      // Print all elements

      iterator = staff.listIterator();
      while (iterator.hasNext())
      {
         String element = iterator.next();
         System.out.print(element + " ");         
      }
      System.out.println();
      System.out.println("Expected: Dick Harry Juliet Nina Tom");
   }
}
