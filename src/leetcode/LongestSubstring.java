package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

   //Time complexity - O(2n) - O(n)
   public int lengthOfLongestSubstring(String s) {
      if(s == null || s.length() == 0)
         return 0;

      if(s.length() == 1)
         return 1;
      int start = 0, end = 1;
      StringBuilder substring = new StringBuilder();
      int longest = 0;
      while(end < s.length()){
         if(substring.toString().equals("")){
            substring.append(s.charAt(start));
            if(substring.length() > longest)
               longest = substring.length();
         }

         char startChar = s.charAt(start);
         char endChar = s.charAt(end);
         if(startChar != endChar && substring.toString().indexOf(endChar) == -1){
            substring.append(endChar);
            end++;
            if(substring.length() > longest)
               longest = substring.length();
         }
         else{
            start++;
            end = start + 1;
            substring = new StringBuilder();
         }
      }
      return longest;
   }

   /**
    * More optimized version using sliding window.
    */
   public int lengthOfLongestSubstring1(String s) {
      if(s == null || s.length() == 0)
         return 0;

      if(s.length() == 1)
         return 1;

      Set<Character> set = new HashSet<>();
      int longest = 0;
      int i = 0, j = 0;
      int length = s.length();

      while(i < length && j < length){
         if(!set.contains(s.charAt(j))){
            set.add(s.charAt(j ++));
            longest = Math.max(longest, j - i);
         }else{
            set.remove(s.charAt(i++));
         }
      }
      return longest;
   }

   public static void main(String[] args) {
      LongestSubstring obj = new LongestSubstring();
      System.out.println(obj.lengthOfLongestSubstring1("bbbb"));
   }

}
