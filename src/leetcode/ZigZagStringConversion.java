package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 */

public class ZigZagStringConversion {

   public String zigzag(String input, int rows){
      if(input == null || input.length() == 0)
         return "";

      if(rows == 1)
         return input;
      int count = 0;
      List<List<Character>> chars = new ArrayList<>();
      for(int i = 0; i < rows && count < input.length(); i ++){
         List<Character> list = new ArrayList<>();
         list.add(input.charAt(count ++));
         chars.add(list);
      }

      for(int i = rows - 2; i >=0 && count < input.length(); i --){
         chars.get(i).add(input.charAt(count ++));
      }

      while(count < input.length()){
         for(int i = 1; i < rows && count < input.length(); i ++)
            chars.get(i).add(input.charAt(count ++));

         for(int i = rows - 2; i >=0 && count < input.length(); i --)
            chars.get(i).add(input.charAt(count ++));
      }

      StringBuilder output = new StringBuilder();
      for(List<Character> characterList : chars)
         for(Character ch : characterList)
            output.append(ch);

      return output.toString();
   }

   public static void main(String[] args) {
      String input = "AB";
      ZigZagStringConversion obj = new ZigZagStringConversion();
      System.out.println(obj.zigzag(input, 1));
   }

}
