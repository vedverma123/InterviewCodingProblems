package sorting;

import java.util.Arrays;

public class MergeSort {

   public void sort(int[] input){

      if(input.length < 2)
         return;

      int middle = input.length / 2 ;

      int[] left = new int[middle];
      for(int i = 0; i < middle; i ++)
         left[i] = input[i];

      int[] right = new int[input.length - middle];
      for(int i = middle, k = 0; i < input.length ; i ++)
         right[k++] = input[i];

      sort(left);
      sort(right);

      merge(left, right, input);
   }

   private void merge(int[] left, int[] right, int[] input) {
      int i =0, j =0, k=0;
      while(i < left.length && j < right.length){
         if(left[i] <= right[j])
            input[k++] = left[i ++];
         else
            input[k++] = right[j ++];
      }

      while(i < left.length)
         input[k++] = left[i++];

      while(j < right.length)
         input[k ++] = right[j ++];
   }

   public static void main(String[] args){
      MergeSort obj = new MergeSort();
      int[] input = {3,2,4,1,5};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }

}
