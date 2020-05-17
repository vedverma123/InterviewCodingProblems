package dynamicprogramming;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 */
public class JumpGame {

   public boolean canJump(int[] nums) {

      if(nums == null || nums.length == 0)
         return false;

      int furtherReachSoFar = 0;
      for(int i = 0; i < nums.length; i ++){
         if(i > furtherReachSoFar || furtherReachSoFar >= nums.length - 1)
            break;

         furtherReachSoFar = Math.max(furtherReachSoFar, i + nums[i]);
      }

      return furtherReachSoFar >= nums.length - 1;
   }

   public static void main(String[] args) {
      JumpGame obj = new JumpGame();
      int[] nums = {2,3,1,1,4};
      System.out.print(obj.canJump(nums));
   }

}
