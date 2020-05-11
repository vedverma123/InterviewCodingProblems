package sorting;

import java.util.Arrays;

public class QuickSort {

   public void sort(int[] input){
      //choose the pivot as last element.
      //partitioning the array into left and right and swap the elements.
      //repeat.

      if(input.length == 0)
         return;

      sort(input, 0, input.length - 1);
   }

   private void sort(int[] input, int start, int end) {

      if(start >= end)
         return;

      int boundry = start -1;
      int pivotIndex = end;

      for(int i = start; i < end; i ++){
         if(input[i] > input[pivotIndex])
            continue;
         boundry ++;
         swap(input, boundry, i);
      }
      swap(input, ++boundry, pivotIndex);

      //left partition
      sort(input, start, boundry - 1);

      //right partition
      sort(input, boundry + 1, end);
   }

   private void swap(int[] input, int boundry, int i) {
      int temp = input[i];
      input[i] = input[boundry];
      input[boundry] = temp;
   }

   public static void main(String[] args){
      QuickSort obj = new QuickSort();
      int[] input = {2,1,3,5,1,8,5,6};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }
}
