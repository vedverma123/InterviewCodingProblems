package leetcode;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ArrayThreeSumClosest {

   public int threeSumClosest(int[] nums, int target) {
      if(nums == null || nums.length == 0)
         throw new IllegalArgumentException();

      if(nums.length == 1)
         return nums[0];

      //sort the input array.
      Arrays.sort(nums);

      int closest = Integer.MAX_VALUE;

      for(int current = 0; current < nums.length ; current ++){
         int left = current + 1;
         int right = nums.length - 1;
         while(left < right){
            int sum = nums[current] + nums[left] + nums[right];
            if(Math.abs(target - sum) < Math.abs(closest))
               closest = target - sum;
            if(sum < target)
               left ++;
            else
               right --;
         }
      }

      return target - closest;
   }

   public static void main(String[] args) {
      ArrayThreeSumClosest obj = new ArrayThreeSumClosest();
      int[] nums = {-1,2,1,-4};
      char ch ='a';
      char ch1 = (char) (ch + 10);
      StringBuilder sb = new StringBuilder();
      sb.append(ch1);
      System.out.println(obj.threeSumClosest(nums, 1));
   }


}
