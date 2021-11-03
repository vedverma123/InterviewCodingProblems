package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Main string - "gogopowerrangergogopowerranger"
// substring - "xxyxxy"
// Ouput - find out x and y that matches the main string ["go","powerranger"].
public class PatternMatcher {

   public String[] getPatternMatcher(String main, String substring){
      String[] patterns = new String[2];
      if(substring == null || main == null || substring.length() > main.length())
         return patterns;

      int mainStringLength = main.length();
      boolean isStartWithX = substring.startsWith("x");
      Map<Character, Integer> totalXYMap = new HashMap<>();
       for(Map.Entry<Character, Integer> entry : totalXYMap.entrySet()){

       }
       getTotalXY(substring, totalXYMap);
      if(totalXYMap.get('y') > 0){
         int firstYIdx = getFirstYPos(substring);
         for(int lengthOfX = 1; lengthOfX < mainStringLength; lengthOfX ++){
//             int yLength =
         }

      }else{

      }



      return null;
   }

   private int getFirstYPos(String substring) {
      int pos = -1;
      for(int idx = 0; idx < substring.length(); idx ++){
         char ch = substring.charAt(idx);
         if(ch == 'y')
            return idx;
      }
      return pos;
   }

   private void getTotalXY(String substring, Map<Character, Integer> totalXYMap) {
       for(char ch : substring.toCharArray()){
           if(ch=='x')
               totalXYMap.put(ch, totalXYMap.get('x') + 1);
            else
               totalXYMap.put(ch, totalXYMap.get('y') + 1);
       }
   }

   public static void main(String[] args) {
      String main = "gogopowerrangergogopowerranger";
      String substring = "xxyxxy";
      System.out.println(Arrays.toString(new PatternMatcher().getPatternMatcher(main, substring)));
   }

}
