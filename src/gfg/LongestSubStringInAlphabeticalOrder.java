package gfg;

public class LongestSubStringInAlphabeticalOrder {

   public String getLongestSubString(String input){
      if(input == null || input.length() == 0)
         return "";

      int count = 1, max = 0;
      StringBuilder output = new StringBuilder();
      output.append(input.charAt(0));
      for(int i = 1; i < input.length(); i ++){
         char current = input.charAt(i);
         if(current > input.charAt(i - 1)){
            count ++;
         }else{
            output = new StringBuilder();
            count = 1;
         }
         max = Math.max(count, max);
         output.append(current);
      }
      return output.toString();
   }

   public static void main(String[] args) {
      LongestSubStringInAlphabeticalOrder obj = new LongestSubStringInAlphabeticalOrder();
      String input = "dcbab";
      System.out.print(obj.getLongestSubString(input));
   }

}
