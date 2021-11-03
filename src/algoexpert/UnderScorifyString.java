package algoexpert;

import java.util.ArrayList;
import java.util.List;

//String1 = testthis is a testtest to see if testestest it works
//String2 = test

//space - O(n)
// Time - O(N*(N+M)) - that's again veries based on the input string and the substrin. Its not very straight forward.
public class UnderScorifyString{

   public String underscorify(String input, String str2){
      if(input == null || input.length() == 0)
         return input;

      int length = input.length();
      int wordLength = str2.length();
      List<Integer[]> indices = new ArrayList();

      for(int idx = 0; idx < length;){
         int index = input.indexOf(str2, idx);
         if(index != -1){
            Integer[] array = {index, index + wordLength};
            idx = index + 1;
            indices.add(array);
         }else {
            break;
         }
      }

      List<Integer[]> collapsedIndices = new ArrayList();
      collapsedIndices.add(indices.get(0));
      if(indices.size() > 0){
         for(int i = 1; i < indices.size(); i ++){
            Integer[] currentIndices = indices.get(i);
            Integer[] prevIndices = indices.get(i - 1);
            if(prevIndices[1] >= currentIndices[0]){
               collapsedIndices.get(collapsedIndices.size() - 1)[1] = currentIndices[1];
            }else{
               collapsedIndices.add(currentIndices);
            }
         }
      }

      int count = 0;
      StringBuilder sb = new StringBuilder(input);
      for(Integer[] collapsedIndex : collapsedIndices){
         int startIdx = collapsedIndex[0];
         int endIdx = collapsedIndex[1];
         sb.insert(startIdx + count ++, '_');
         sb.insert(endIdx + count ++, '_');
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      String str1 = "testthis is a testtest to see if testestest it works";
      String str2 = "test";
      System.out.println(new UnderScorifyString().underscorify(str1,str2));
   }
}