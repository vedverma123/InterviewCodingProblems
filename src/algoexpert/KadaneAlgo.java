package algoexpert;

public class KadaneAlgo {

   //Naive Solution aka Brute Force
   //Time complexity - O(n^2)
   //Space complexity - O(1)
   public int maxSumSubArray(int[] input){
      if(input == null || input.length == 0)
         return 0;

      int sum ;
      int maxSum = Integer.MIN_VALUE;

      for(int i = 0; i < input.length; i ++){
         sum = input[i];
         if(sum > maxSum)
            maxSum = sum;
         for(int j = i +1; j < input.length; j ++){
            sum += input[j];
            if(sum > maxSum)
               maxSum = sum;
         }
      }
      return maxSum;
   }

   //DP- Naive solution
   //Time complexity - O(n)
   //Space complexity - O(n)
   public int maxSubArraySum(int[] input){
      if(input == null || input.length == 0)
         return 0;

      int[] maxSum = new int[input.length];
      int sum =0;
      for(int i = 0; i < input.length ; i ++){
         sum += input[i];
         if(sum < input[i]){
            maxSum[i] = input[i];
            sum = input[i];
         }else
            maxSum[i] = sum;
      }

      //find max number
      sum = Integer.MIN_VALUE;
      for(int item : maxSum)
         if(item > sum)
            sum = item;

      return sum;
   }

   //Time comlexity - O(n)
   //Space complexity - O(1)
   public int maxSubArray(int[] input){
      int maxSoFar = input[0];
      int maxEndingHere = input[0];

      for(int i = 1; i < input.length; i ++){
         maxEndingHere = Math.max(maxEndingHere + input[i], input[i]);
         maxSoFar = Math.max(maxSoFar, maxEndingHere);
      }
      return maxSoFar;
   }

   public static void main(String[] args){
      KadaneAlgo obj = new KadaneAlgo();
      int[] input = {2,-3,-1,-5,4,-2,-1,9,-6};
      System.out.print(obj.maxSubArray(input));
   }

}
