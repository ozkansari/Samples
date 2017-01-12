package ch16.map;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
   This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
   public static void main(String[] args)
   {      
      Map<String, Color> favoriteColors 
            = new HashMap<String, Color>();
      favoriteColors.put("Juliet", Color.PINK);
      favoriteColors.put("Romeo", Color.GREEN);
      favoriteColors.put("Adam", Color.BLUE);
      favoriteColors.put("Eve", Color.PINK);

      Set<String> keySet = favoriteColors.keySet();
      for (String key : keySet)
      {
         Color value = favoriteColors.get(key);
         System.out.println(key + "->" + value);
      }
   }
}
