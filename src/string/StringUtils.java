package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringUtils {

   public static int countVowels(String str){
      if(str == null)
         return 0;
      int count = 0;
      String vowels = "aeiou";
      for(char ch : str.toLowerCase().toCharArray()){
         if(vowels.indexOf(ch) != -1)
            count ++;
      }
      return count;
   }
   //other approach is to include stack to reverse string.
   public static String reverse(String str){
      if(str == null)
         throw new IllegalArgumentException();

      char[] arrays = str.toCharArray();
      for(int start = 0, end = arrays.length - 1; start < end; start ++, end --){
         char temp = arrays[start];
         arrays[start] = arrays[end];
         arrays[end] = temp;
      }
      return String.valueOf(arrays);
   }

   public static String reverseWords(String str){
      if(str == null)
         return "";
      String[] words = str.trim().split(" ");
      for(int start = 0, end = words.length - 1; start < end; start ++, end --){
         String temp = words[start];
         words[start] = words[end];
         words[end] = temp;
      }
      return String.join(" ", words);
   }

   public static boolean areRotations(String str1, String str2){

      return str1.length() == str2.length() && (str1.toLowerCase() + str1.toLowerCase()).contains(str2.toLowerCase());
   }

   public static String removeDuplicates(String str){
      if(str == null)
         return "";
      if(str.length() == 1)
         return str;

      Set<Character> chars = new HashSet<>();
      StringBuilder builder = new StringBuilder();
      for(char ch : str.toCharArray()){
         if(!chars.contains(Character.toLowerCase(ch))){
            chars.add(Character.toLowerCase(ch));
            builder.append(ch);
         }
      }
      return builder.toString();
   }

   //Other implementation is to use array of ASCII characters, i.e. char[] array of 256 size.
   // And iterate through the string and increase the count.
   public static char mostRepeatedChar(String str){
      if(str == null)
         throw new IllegalArgumentException();
      int maxValue = 0;
      char mostRepeatedChar = str.charAt(0);
      Map<Character, Integer> map = new HashMap<>();
      for(char ch : str.toCharArray()){
         int count = 0;
         if(map.get(Character.toLowerCase(ch)) != null)
            count = map.get(Character.toLowerCase(ch)) + 1;
         map.put(Character.toLowerCase(ch), count);
         if(count > maxValue){
            maxValue = count;
            mostRepeatedChar = ch;
         }
      }
      return mostRepeatedChar;

   }

   public static void main(String[] args) {
      System.out.println(countVowels("HELLo"));
      System.out.println(reverse("HELLo"));
      System.out.println(reverseWords("     HELLo WorLD What's up"));
      System.out.println(areRotations("Hello", "olhel"));
      System.out.println(removeDuplicates("HELloe WorrrrlldDDD"));
      System.out.println(mostRepeatedChar("HELloe WorrrlldDDD THerER"));
   }

}
