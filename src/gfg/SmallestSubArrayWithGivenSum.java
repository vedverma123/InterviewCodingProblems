package gfg;

import java.util.Arrays;

/**
 * Given an array of integers and a number x,
 * find the smallest subarray with sum greater than the given value.
 *
 * Examples:
 * arr[] = {1, 4, 45, 6, 0, 19}
 *    x  =  51
 * Output: 3
 * Minimum length subarray is {4, 45, 6}
 */
public class SmallestSubArrayWithGivenSum {

   public int[] smallestSubArray(int[] input, int desiredSum){
      if(input == null || input.length == 0)
         return new int[0];

      if(input.length == 1)
         return input[0] > desiredSum ? input : new int[0];

      int left = 0;
      int right = 1;
      int sum = input[left];
      while(right < input.length){
         if(sum > desiredSum){
            //keep moving i to the right to make smaller sub array till sum is greater than desired sum.
            while(left <= right && sum > desiredSum){
               sum -= input[left];
               left ++;
            }
            if(sum + input[left - 1] > desiredSum){
               left = left - 1;
               sum += input[left];
            }
            if(sum > desiredSum)
               break;
         }else if(sum <= desiredSum){
            sum += input[right];
            right++;
         }
      }
      if(sum > desiredSum){
         int[] output = new int[right - left];
         int count = 0;
         for(int i = left; i < right; i ++)
            output[count ++] = input[i];
         return output;
      }

      return new int[0];
   }

   public static void main(String[] args) {
      SmallestSubArrayWithGivenSum obj = new SmallestSubArrayWithGivenSum();
      int[] input = {1, 10, 5, 2, 7};
      int desiredSum = 9;
      System.out.println(Arrays.toString(obj.smallestSubArray(input, desiredSum)));
   }

}
