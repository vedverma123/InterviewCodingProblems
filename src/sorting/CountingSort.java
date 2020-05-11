package sorting;

import java.util.Arrays;

public class CountingSort {

   public void sort(int[] input){
      if(input.length <= 0)
         return;
      int max = findMax(input);
      int[] countArray = new int[max + 1];
      countOccurence(countArray, input);

      for(int i = 0, k = 0; i < countArray.length ; i ++)
         if(countArray[i] > 0){
            for(int j = 1; j <= countArray[i]; j ++)
               input[k++] = i;
         }
   }

   private void countOccurence(int[] countArray, int[] input) {
      for(int i = 0; i < input.length; i ++)
         countArray[input[i]] = countArray[input[i]] + 1;
   }

   private int findMax(int[] input) {
      int max = input[0];
      for(int i =1; i < input.length; i ++)
         if(input[i] > max)
            max = input[i];

      return max;
   }

   public static void main(String[] args){
      CountingSort obj = new CountingSort();
      int[] input = {2,10,9,5,0,4,1,9};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }

}
