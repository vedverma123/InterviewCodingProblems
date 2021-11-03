package algoexpert;

import java.util.Arrays;

//Time - O(n) - worse case when all elements are same and same as target
//Space - O(1)
public class TargetRangeInSortedArray {
   public int[] range(int[] nums, int target) {
      int[] output = { -1, -1 };
      if (nums == null || nums.length == 0)
         return output;

      int length = nums.length;
      int mid = length / 2;

      int start = -1;
      int end = -1;

      int idx = mid;
      if (nums[mid] == target) {
         //go in both direction
         while (idx >= 0 && nums[idx] == target) {
            idx--;
         }
         start = idx + 1;
         idx = mid;
         while (idx < length && nums[idx] == target) {
            idx++;
         }
         end = idx - 1;
      } else if (target < nums[mid]) {
         //go strict to left
         idx = mid - 1;
         while (idx >= 0) {
            if (target > nums[idx])
               break;
            if (target == nums[idx]) {
               if (end == -1)
                  end = idx;
               else
                  start = idx;
            }
            idx--;
         }
         start = start == -1 ? end : start;
      } else {
         //go strict to right
         idx = mid + 1;
         while (idx < length) {
            if (target < nums[idx])
               break;
            if (target == nums[idx]) {
               if (start == -1)
                  start = idx;
               else
                  end = idx;
            }
            idx++;
         }
         end = end == -1 ? start : end;
      }
      output[0] = start;
      output[1] = end;
      return output;
   }

   public static void main(String[] args) {
      int[] input = {1,1,1,1,1,1,1,1};
      System.out.println(Arrays.toString(new TargetRangeInSortedArray().range(input, 1)));
   }
}
