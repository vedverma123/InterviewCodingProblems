package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSubsetSumNoAdjacent {

   //Time complexity - O(n) or O(n^2)
   //Space complexity - O(n)
   public int maxSubsetSum(int[] input){
      if(input == null)
         return 0;

      int sum = 0;
      List<Integer> maxIndexList = new ArrayList(input.length);
      int startIndex = 0;
      findMaxElementIndex(input, maxIndexList, startIndex);
      for(int index : maxIndexList)
         sum += input[index];
      return sum;
   }

   private void findMaxElementIndex(int[] input, List<Integer> maxIndexList, int startIndex) {
      if(input.length == 0)
         return ;

      int max = Integer.MIN_VALUE;
      int maxIndex = -1;

      if(input.length == 1){
         maxIndex = 0;
      }
      else{
         for(int index = 0; index < input.length; index ++){
            if(input[index] > max){
               max = input[index];
               maxIndex = index;
            }
         }
      }

      if(!isAdjacentIndex((startIndex + maxIndex), maxIndexList))
         maxIndexList.add(startIndex + maxIndex);

      findMaxElementIndex(Arrays.copyOfRange(input, 0, maxIndex), maxIndexList, 0);
      findMaxElementIndex(Arrays.copyOfRange(input, maxIndex + 1, input.length), maxIndexList, maxIndex + 1);

   }

   private boolean isAdjacentIndex(int maxIndex, List<Integer> maxIndexList) {
      for(int index : maxIndexList)
         if(index == maxIndex || Math.abs(index - maxIndex) == 1)
            return true;
      return false;
   }


   //Time complexity - O(n)
   //Space complexity - O(1)
   public int findMaxSum(int[] input){
      if(input == null)
         return 0;

      if(input.length == 1)
         return input[0];

      int first = input[0];
      int second = input[1];
      int max ;

      for(int i =2; i < input.length; i ++){
         max = Math.max(second, first + input[i]);
         first = second;
         second = max;
      }
      return second > first ? second : first;
   }

   public static void main(String[] args) {
      MaxSubsetSumNoAdjacent obj = new MaxSubsetSumNoAdjacent();
      int[] input = {2, 5, 10, 3, 9, 1, 11};
      System.out.println(obj.findMaxSum(input));
   }
}
