package gfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StringSegmentation{
   public static boolean canSegmentString(String input, Set<String> dictionary) {
      if(input == null)
         return true;
      List<String> words = new ArrayList<>();
      int end = 1, start = 0;
      while(end < input.length()){
         String word = input.substring(start, end);
         if(dictionary.contains(word)){
            start = end;
            words.add(word);
         }
         end++;
      }

      words.add(input.substring(start,end));

      for(int  i = 0; i< words.size(); i ++){
         if(!dictionary.contains(words.get(i))){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      Set<String> dictionary = new HashSet<>();
      dictionary.add("apple");
      dictionary.add("pear");
      dictionary.add("pier");
      dictionary.add("pie");
      System.out.println(canSegmentString("applepie", dictionary));
   }
}