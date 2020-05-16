package dynamicprogramming;

public class MaxSubArray {

   public int maxSum(int[] input){
      int maxSoFar = Integer.MIN_VALUE;
      int maxEndingHere = 0;

      for(int i = 0; i < input.length; i ++){
         maxEndingHere += input[i];

         if(maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere;
         if(maxEndingHere < 0)
            maxEndingHere = 0;
      }
      return maxSoFar;
   }

   public static void main(String[] args) {
      MaxSubArray obj = new MaxSubArray();
      int[] input = {-2,-1};
      System.out.print(obj.maxSum(input));
   }

}
