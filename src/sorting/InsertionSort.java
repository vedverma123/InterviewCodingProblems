package sorting;

import java.util.Arrays;

public class InsertionSort {

   public static void main(String[] args){
      InsertionSort obj = new InsertionSort();
      Integer[] input = {3,1,5,2,8,4};
      input = obj.sort(input);
      System.out.println(Arrays.toString(input));
   }

   public Integer[] sort(Integer[] input) {
      for(int i = 1; i < input.length; i ++){
         int current = input[i];
         int j = i - 1;
         while(j >= 0 && input[j] > current){
            input[j + 1] = input[j];
            j--;
         }
         input[j + 1] = current;
      }
      return input;
   }
}
