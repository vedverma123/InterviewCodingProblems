package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

   public String substring(String input){
      if(input == null || input.length() == 0)
         return input;

      Map<Character, Integer> charIdxMap = new HashMap();
      StringBuilder output = new StringBuilder();
      int maxLength = Integer.MIN_VALUE;
      int currentLength= 0;
      String longestSubstring = "";

      for(int idx = 0; idx < input.length(); idx ++){
         char currentChar = input.charAt(idx);
         if(charIdxMap.containsKey(currentChar)){
            idx = charIdxMap.get(currentChar);
            if(currentLength > maxLength){
               maxLength = currentLength;
               longestSubstring = output.toString();
               output = new StringBuilder();
               charIdxMap = new HashMap<>();
               currentLength = 0;
            }else{
               output = new StringBuilder();
               charIdxMap = new HashMap<>();
               currentLength = 0;
            }
         }else{
            charIdxMap.put(currentChar, idx);
            currentLength ++;
            output.append(currentChar);
         }
      }

      return currentLength < maxLength ? longestSubstring : output.toString();
   }

   public static void main(String[] args) {
      String input = "clementisacap";
      System.out.println(new LongestSubstringWithoutDuplication().substring(input));
   }

}
