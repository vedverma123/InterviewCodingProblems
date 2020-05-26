package algoexpert;

/**
 * Given a circular array of integers(positive or negative both), check if we have ONLY ONE CYCLE.
 * And value at index represents the jump in forward direction if number is positive otherwise backward direction if number is negative.
 *
 * eg : {2,3,1,-4,-4,2} - output: true.
 *      {1,-1,1,-1} - output : false because having multiple cycle.
 */

/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 */
public class SingleCycleCheck {

   public boolean hasSingleCycle(int[] input){
      int startIndex = 0;
      int visitedCount = 0;
      int currentIndex = startIndex;

      while(visitedCount < input.length){

         //condition for multiple cycle
         if(visitedCount > 0 && currentIndex == startIndex)
            return false;

         visitedCount ++;
         currentIndex = getCurrentIdx(currentIndex, input);
      }

      return currentIndex == startIndex;
   }

   private int getCurrentIdx(int currentIndex, int[] input) {
      currentIndex = (currentIndex + input[currentIndex]) % input.length;
      return currentIndex >= 0 ? currentIndex : currentIndex + input.length;
   }

   public static void main(String[] args) {
      SingleCycleCheck obj = new SingleCycleCheck();
//      int[] input = {2,3,1,-4,-4,2};
      int[] input = {1,-1,1,-1};
      System.out.print(obj.hasSingleCycle(input));
   }

}
