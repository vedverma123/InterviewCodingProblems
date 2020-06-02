package algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

   //Time complexity - O(n).
   //Space Complexity - O(n)
   public int longestConsecutiveUsingSet(int[] nums){
      if(nums == null || nums.length == 0)
         return 0;

      if(nums.length == 1)
         return 1;

      Set<Integer> set = new HashSet<>();
      for(int item : nums)
         set.add(item);

      int maxSequence = 1;

      for(int item : nums){
         if(!set.contains(item - 1)){
            int currentSeq = 1;
            int currentNum = item;

            while(set.contains(currentNum + 1)){
               currentNum += 1;
               currentSeq ++;
            }

            maxSequence = Math.max(maxSequence, currentSeq);
         }
      }


      return maxSequence;
   }

   //Time complexity - Avg case : O(nlogn), because of the sorting.
   //Space complexityb - O(1).
   public int longestConsecutive(int[] nums) {
      if(nums == null || nums.length == 0)
         return 0;

      if(nums.length == 1)
         return 1;

      Arrays.sort(nums);

      int count = 1;
      int maxCount  = 1;
      for(int i = 1; i < nums.length; i ++){
         if(nums[i -1 ] == nums[i])
            continue;
         if(nums[i-1] + 1 == nums[i])
            count ++;
         else{
            maxCount = Math.max(maxCount, count);
            count = 1;
         }

      }
      return Math.max(maxCount, count);
   }

   public static void main(String[] args) {
      LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
      int[] input = {100,4,200,1,3,2};
      System.out.println(obj.longestConsecutiveUsingSet(input));
   }

}
