package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

   public static int lcs(String str1, String str2){
      String shortestString = str1.length() > str2.length() ? str1 : str2;
      String longestString = shortestString.equals(str1) ? str2 : str1;
      int index = -1;
      int count = 0;
      for(char ch : shortestString.toCharArray()){
         if(longestString.indexOf(ch) > index){
            index = longestString.indexOf(ch);
            count ++;
         }

      }
      return count;
   }

      /*LongestCommonSubsequence obj = new LongestCommonSubsequence();
      String str1 = "abcdefg";
      String str2 = "azyxgcf";
      System.out.print(obj.lcs(str1, str2));*/


      public static void main(String[] args) throws IOException {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         int t = Integer.parseInt(reader.readLine());
         while(t>0)
         {
            String[] split = reader.readLine().split(" ");
            int size1 = Integer.parseInt(split[0]);
            int size2 = Integer.parseInt(split[1]);
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            System.out.println(lcs(str1, str2));
            t--;
         }
      }

}
