package dynamicprogramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {

   //This can be solved using fibonacci concept i.e. fib(n) = fib(n - 1) + fib(n - 2).
   public int climbStairs(int stairSteps){
      int first = 1, second = 1;
      if(stairSteps == 0)
         return 0;
      int ways = 1;
      for(int i = 2; i <= stairSteps; i ++){
         ways = first + second;
         second = first;
         first = ways;
      }
      return ways;
   }

   public static void main(String[] args) {
      ClimbingStairs obj = new ClimbingStairs();
      int stairSteps = 5;
      System.out.print(obj.climbStairs(stairSteps));
   }

}
