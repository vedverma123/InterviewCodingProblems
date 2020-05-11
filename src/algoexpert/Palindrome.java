package algoexpert;

public class Palindrome {

   //Time Complexity - O(n)
   //Space complexity - O(1).
   public boolean isPalindrome(String str){
      if(str == null || str == "")
         return false;
      str = str.trim();

      int start = 0, end = str.length() - 1;
      while(start < end ){
         if(str.charAt(start ++) != str.charAt(end--))
            return false;
      }
      return true;
   }

   public static void main(String[] args) {
      Palindrome obj = new Palindrome();
      System.out.println(obj.isPalindrome("abaa"));
   }

}
