package algoexpert;

import java.util.Arrays;
import java.util.Collections;

public class SmallestDifferenceArray {

   //Time complexity - O(nlogn + mlogm) + O(n + m) = O(nlogn + mlogm)
   //Space complexity - O(1)
   public int[] diff(Integer[] array1, Integer[] array2){
      int[] output = new int[2];
      //sort both the input array.
      Collections.sort(Arrays.asList(array1));
      Collections.sort(Arrays.asList(array2));

      //take a pointer on each input array and compare the difference.
      int ptr1 = 0, ptr2 = 0;
      int diff = Integer.MAX_VALUE;
      while(ptr1 < array1.length && ptr2 < array2.length){
         if(array1[ptr1] == array2[ptr2]){
            populate(output, array1[ptr1], array2[ptr2]);
            break;
         }

         if(array1[ptr1] < array2[ptr2]){
            if(diff > Math.abs(array1[ptr1] - array2[ptr2])){
               diff = Math.abs(array1[ptr1] - array2[ptr2]);
               populate(output, array1[ptr1], array2[ptr2]);
            }
            ptr1 ++;
         }else{
            if(diff > Math.abs(array1[ptr1] - array2[ptr2])){
               diff = Math.abs(array1[ptr1] - array2[ptr2]);
               populate(output, array1[ptr1], array2[ptr2]);
            }
            ptr2 ++;
         }
      }
      return output;
   }

   private void populate(int[] output, int num1, int num2){
      output[0] = num1;
      output[1] = num2;
   }

   public static void main(String[] args) {
      SmallestDifferenceArray obj = new SmallestDifferenceArray();
      Integer[] array1 = {-1,5,10,30,28,3};
      Integer[] array2 = {56,134,135,15,17};
      System.out.println(Arrays.toString(obj.diff(array1, array2)));
   }

}
