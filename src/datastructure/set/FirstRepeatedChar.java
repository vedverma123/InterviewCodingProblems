package datastructure.set;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {

   public char find(String input){
      Set<Character> set = new HashSet<>();
      for(char ch : input.toCharArray()){
         ch = Character.toLowerCase(ch);
         if(set.contains(ch))
            return ch;
         set.add(ch);
      }
      return Character.MIN_VALUE;
   }

   public static void main(String[] args) {
      String input = "A green Apple";
      FirstRepeatedChar obj = new FirstRepeatedChar();
      System.out.println(obj.find(input));
   }
}
