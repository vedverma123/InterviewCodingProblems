package sorting;

import java.util.Arrays;

public class SelectionSort {

   public static void main(String[] args){
      SelectionSort obj = new SelectionSort();
      int[] input = {1,3,4,1,5,6,3,8};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }

   public void sort(int[] input) {
      for(int i = 0; i < input.length ; i ++){
         int j = findMinIndex(input, i);
         if(j > -1 && input[i] > input[j])
            swap(input, i , j);
      }
   }

   private void swap(int[] input, int i, int j) {
      int temp = input[j];
      input[j] = input[i];
      input[i] = temp;
   }

   private int findMinIndex(int[] input, int i) {
      int min = Integer.MAX_VALUE, minIndex = -1;
      for(int index = i + 1; index < input.length; index ++){
         if(input[index] < min ){
            min = input[index];
            minIndex = index;
         }
      }
      return minIndex;
   }

}
