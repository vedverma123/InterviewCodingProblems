package dynamicprogramming;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

   public int maxRobbery(int[] input){
      if(input == null || input.length == 0)
         return 0;

      if(input.length == 1)
         return input[0];

      int first = input[0];
      int second = Math.max(input[0], input[1]);

      int maxSum;
      for(int i = 2; i < input.length; i ++){
         maxSum = Math.max(second, first + input[i]);
         first = second ;
         second = maxSum;
      }

      return second > first ? second : first;
   }


   public static void main(String[] args) {
      HouseRobber obj = new HouseRobber();
      int[] input = {2,1,1,2};
      System.out.print(obj.maxRobbery(input));
   }

}
