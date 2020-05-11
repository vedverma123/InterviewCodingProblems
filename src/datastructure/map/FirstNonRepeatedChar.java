package datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedChar {

   public Character find(String input){
      Map<Character, Integer> map = new LinkedHashMap<>();
      for(char ch : input.toCharArray()){
         ch = Character.toLowerCase(ch);
         int count = map.containsKey(ch) ? map.get(ch) : 0;
         map.put(ch, count + 1);
      }
      System.out.println(map);
      for(var entrySet : map.entrySet()){
         if(entrySet.getValue() == 1){
            return entrySet.getKey();
         }
      }

      return null;
   }

   public static void main(String[] args) {
      String input = "A green apple";
      FirstNonRepeatedChar obj = new FirstNonRepeatedChar();
      System.out.println(obj.find(input));
   }

}
