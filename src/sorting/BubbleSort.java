package sorting;

import java.util.Arrays;

public class BubbleSort {

   public void sort(int[] input){
      boolean isSorted = true;
      for(int i =0; i < input.length; i ++){
         for(int j = 1; j < input.length - i; j ++){
            if(input[j] < input[j - 1]){
               swap(input, j, j-1);
               isSorted = false;
            }
         }
         if(isSorted)
            return;
      }
   }

   private void swap(int[] input, int i, int j) {
      int temp = input[i];
      input[i] = input[j];
      input[j] = temp;
   }

   public static void main(String[] args) {
      BubbleSort obj = new BubbleSort();
      int[] input = {1,2,2,3,4,5};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }
}
