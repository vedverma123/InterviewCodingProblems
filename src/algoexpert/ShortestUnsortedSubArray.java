package algoexpert;

import java.util.Arrays;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray.
 *
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * output : [1,5]
 */
public class ShortestUnsortedSubArray {

   //Time Complexity - O(n)
   //Space Complexity - O(1)
   public int[] getUnsortedSubarray(int[] nums) {
      if(nums == null || nums.length < 2)
         return new int[0];

      int[] outputIndices = {-1,-1};

      int minOutOfOrder = Integer.MAX_VALUE;
      int maxOutOfOrder = Integer.MIN_VALUE;

      boolean isSorted = true;
      for(int i = 0; i < nums.length; i ++) {
         int num = nums[i];
         if (isOutOfOrder(num, i, nums)) {
            isSorted = false;
            minOutOfOrder = Math.min(num, minOutOfOrder);
            maxOutOfOrder = Math.max(num, maxOutOfOrder);
         }
      }
      if(isSorted){
         outputIndices[0] = 0;
         outputIndices[1] = 0;
      }

      int left = 0, right = nums.length - 1;
      while(minOutOfOrder >= nums[left])
         left ++;

      while(maxOutOfOrder <= nums[right])
         right --;

      outputIndices[0] = left;
      outputIndices[1] = right;

      return outputIndices;
   }

   private boolean isOutOfOrder(int num, int i, int[] nums) {
      if(i == 0)
         return num > nums[i + 1];
      if(i == nums.length - 1)
         return num < nums[i - 1];

      return num > nums[i  + 1] || num < nums[i - 1];
   }

   public static void main(String[] args) {
      ShortestUnsortedSubArray obj = new ShortestUnsortedSubArray();
      int[] nums = {2, 6, 4, 8, 10, 9, 15};
      System.out.println(Arrays.toString(obj.getUnsortedSubarray(nums)));
   }

   //This solution has some loopholes.
   //Time complexity _ O(n)
   public int[] findUnsortedSubarray(int[] nums) {
      if(nums == null || nums.length < 1)
         return new int[0];

      int[] outputIndices = {0,0};

      int mid = nums.length / 2;
      int left = mid;
      int count = mid;
      while(count > 0){
         if(nums[count - 1] > nums[count])
            left = count - 1;
         else if ((nums[count] == nums[mid] && left != mid))
            left = count;
         count --;
      }

      int right = mid;
      count = mid;
      while(count < nums.length - 1){
         if(nums[count + 1] < nums[count] || nums[count + 1] < nums[mid])
            right = count + 1;
         else if(nums[count] == nums[mid] && right != mid)
            right = count;
         count ++;
      }

      if(left != mid && right == mid){
         count = mid;
         boolean isRightLocated = false;
         while (count < nums.length){
            if(nums[count] < nums[left]){
               right = count;
               isRightLocated = true;
            }

            count ++;
         }
         if(right == mid && !isRightLocated){
            count = mid;
            while (count > left){
               if(nums[count] < nums[left])
                  right = count;
               count --;
            }
         }
      }
      if(right != mid && left == mid){
         count = mid;
         boolean isLeftLocated = false;
         while (count > 0){
            if(nums[count] > nums[right]){
               left = count;
               isLeftLocated = true;
            }
            count --;
         }
         if(left == mid && !isLeftLocated){
            count = mid;
            while (count < right){
               if(nums[count] > nums[right])
                  left = count;
               count ++;
            }
         }
      }

      if(left != right){
         outputIndices[0] = left;
         outputIndices[1] = right;
      }
      return outputIndices;
   }

}
