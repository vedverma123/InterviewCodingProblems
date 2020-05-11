package datastructure.array;

import java.io.IOException;
import java.util.Arrays;

public class RearrangeArrayAlternatively {

   /**
    * Takes O(n2)
    * @param input
    */
   public static void rearrange(int [] input)
   {
      for(int i = 0; i < input.length ; i ++){

         int left = i + 0, right = input.length - 1;
         while(left < right){
            swap(input, left, right);
            left ++;
            right --;
         }
      }
   }

   private static void swap(int[] input, int left, int right){
      int temp = input[left];
      input[left] = input[right];
      input[right] = temp;
   }

   /**
    * O(n2)
    * @param arr
    * @return
    */
   public static int[] rearrangeArray(int [] arr)
   {
      int temp;
      for (int i = 0; i < arr.length; i++) {
         if (i % 2 == 0) {
            // Store the last element to 'temp'
            temp = arr[arr.length - 1];
            // Shift all elements, starting from index, 'i', to one place right
            for (int j = arr.length - 2; j >= i; j--) {
               arr[j + 1] = arr[j];
            }
            // Put the value stored in 'temp' to index, 'i'
            arr[i] = temp;
         }
      }
      return arr;
   }

   /**
    * Takes O(n)
    */
   public static void rearrangeInNComplexity(long arr[], int n)
   {
      // initialize index of first minimum and first
      // maximum element
      int max_idx = n - 1, min_idx = 0;

      // store maximum element of array
      long max_elem = arr[n - 1] + 1;

      // traverse array elements
      for (int i = 0; i < n; i++) {
         // at even index : we have to put
         // maximum element
         if (i % 2 == 0) {
            arr[i] += (arr[max_idx] % max_elem) * max_elem;
            max_idx--;
         }

         // at odd index : we have to put minimum element
         else {
            arr[i] += (arr[min_idx] % max_elem) * max_elem;
            min_idx++;
         }
      }

      // array elements back to it's original form
      for (int i = 0; i < n; i++)
         arr[i] = arr[i] / max_elem;
   }

   public static void main(String[] args) throws IOException {

      int size = 1000000;
//      int size = 6;
      long[] input = new long[size];
      for(int i = 0; i < size; i ++)
         input[i] = i +1;
      rearrangeInNComplexity(input,size);
      System.out.println(Arrays.toString(input));
   }
}
