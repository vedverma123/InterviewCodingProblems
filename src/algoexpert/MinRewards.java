package algoexpert;

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

   //Time complexity - O(n^2)
   //Space complexity - O(n)
   public int minRewards(int[] grades){
      if(grades == null || grades.length == 0)
         return 0;

      int size = grades.length;
      int[] rewards = new int[size];
      int count = 0;
      while(count < size)
         rewards[count ++] = 1;

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
      int[] grades = {1,2,2};
      System.out.println(obj.minRewards(grades));
   }

}
