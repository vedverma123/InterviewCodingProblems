package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationOfPhoneNum {

   public List<String> letterCombinations(String digits) {
      List<String> output = new ArrayList<>();
      if(digits == null || digits.length() == 0)
         return output;

      char[][] map = getCharMap();
      output.add("");
      for(char ch : digits.toCharArray()){
         output = expand(output, map[ch - '2']);
      }

      return output;
   }

   private List<String> expand(List<String> output, char[] chars) {
      List<String> next = new ArrayList<>();
      for(String s:output)
         for(char c:chars)
            next.add(s+c);
      return next;
   }

   private char[][] getCharMap() {
      char[][] map = new char[8][];
      map[0] = "abc".toCharArray();
      map[1] = "def".toCharArray();
      map[2] = "ghi".toCharArray();
      map[3] = "jkl".toCharArray();
      map[4] = "mno".toCharArray();
      map[5] = "pqrs".toCharArray();
      map[6] = "tuv".toCharArray();
      map[7] = "wxyz".toCharArray();
      return map;
   }

   public static void main(String[] args) {
      LetterCombinationOfPhoneNum obj = new LetterCombinationOfPhoneNum();
      System.out.println(Arrays.toString(obj.letterCombinations("73").toArray()));

   }

}
