package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Input: [1,0,2]
 * Output: 5
 * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
 */
public class MinRewards {

   /**
    * Time Complexity - O(n)
    * Space Complexity - O(n)
    */
   public int minRewards_Optimized(int[] grades){
      if(grades == null || grades.length == 0)
         return 0;

      if(grades.length == 1)
         return 1;

      int size = grades.length;
      int[] rewards = new int[size];

      Arrays.fill(rewards, 1);

      //Going left to right
      for(int i = 1; i < size ; i ++){
         if(grades[i] > grades[i - 1])
            rewards[i] = rewards[i - 1] + 1;
      }

      //Going right to left
      for(int i = size - 2; i >= 0 ; i --){
         if(grades[i] > grades[i + 1])
            rewards[i] = Math.max(rewards[i], rewards[i + 1] + 1);
      }

      int totalRewards = 0;
      for(int reward : rewards)
         totalRewards += reward;

      return totalRewards;
   }


   //Time complexity - O(n^2)
   //Space complexity - O(n)
   public int minRewards(int[] grades){
      if(grades == null || grades.length == 0)
         return 0;

      int size = grades.length;
      int[] rewards = new int[size];
      int count = 0;
      Arrays.fill(rewards, 1);

      while(true){
         count = 1;
         while(count < size){
            if(grades[count - 1] > grades[count]){
               if(rewards[count - 1] <= rewards[count])
                  rewards[count - 1] = rewards[count - 1] + 1;
            }
            else if(grades[count - 1] < grades[count]){
               if(rewards[count] <= rewards[count - 1])
                  rewards[count] = rewards[count] + 1;
            }
            count ++;
         }

         if(isValidGradesAndRewards(grades, rewards))
            break;
      }

      int totalRewards = 0;
      for(int reward : rewards)
         totalRewards += reward;

      return totalRewards;
   }

   private boolean isValidGradesAndRewards(int[] grades, int[] rewards) {
      for(int count = 1; count < grades.length; count ++){
         if(grades[count - 1] == grades[count])
            continue;
         if(grades[count] < grades[count - 1]){
            if(rewards[count] >= rewards[count - 1])
               return false;
         }else{
            if(rewards[count] <= rewards[count - 1])
               return false;
         }
      }
      return true;
   }

   public static void main(String[] args) {
      MinRewards obj = new MinRewards();
      int[] grades = {1,0,2};
      System.out.println(obj.minRewards_Optimized(grades));
   }

}
