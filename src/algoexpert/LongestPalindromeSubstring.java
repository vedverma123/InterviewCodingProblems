package algoexpert;

/**
 * Given a string, return a longest palindrome substring.
 * Eg: Input - "abaxyzzyxf"
 *     output - "xyzzyx"
 */
public class LongestPalindromeSubstring {

   //Time complexity - O(n^2)
   //Space complexity - O(1)
   public String longestPalindromeSubstring(String input){
      if(input == null || input.length() == 0)
         return "";

      int[] current = {0,1};
      int[] odd = new int[2];
      int[] even = new int[2];
      int[] longest = new int[2];
      for(int i = 1; i < input.length(); i ++){
         odd = getLongestPalindromeFrom(input, i -1, i + 1);
         even = getLongestPalindromeFrom(input, i -1, i);
         if(odd[1] - odd[0] > even[1] - even[0]){
            longest[1] = odd[1];
            longest[0] = odd[0];
         }

         else{
            longest[1] = even[1];
            longest[0] = even[0];
         }

         if(longest[1] - longest[0] > current[1] - current[0]){
            current[1] = longest[1];
            current[0] = longest[0];
         }
      }

      return input.substring(current[0], current[1]);
   }

   private int[] getLongestPalindromeFrom(String input, int left, int right) {
      int[] longest = new int[2];
      while(left >= 0 && right < input.length()){
         if(input.charAt(left) != input.charAt(right))
            break;
         left--;
         right ++;
      }
      longest[0] = left + 1;
      longest[1] = right;
      return longest;
   }

   public static void main(String[] args) {
      LongestPalindromeSubstring obj = new LongestPalindromeSubstring();
      String input = "ccc";
      System.out.println(obj.longestPalindromeSubstring(input));
   }

}
