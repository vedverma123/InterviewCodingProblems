package algoexpert;

public class MonotonicArray {

   //Time complexity - O(n)
   //Space complexity - O(1)
   public boolean isMonotonic(int[] input){
      if(input == null)
         return false;

      if(input.length <=2)
         return true;

      boolean isSortedASC = true;
      for(int j = 1; j < input.length; j ++){
         if(input[j - 1] > input[j]){
            isSortedASC = false;
            break;
         }
      }

      boolean isSortedDESC = true;
      if(!isSortedASC){
         for(int j = 1; j < input.length; j ++){
            if(input[j - 1] < input[j]){
               isSortedDESC = false;
               break;
            }
         }
      }
      return isSortedASC || isSortedDESC;
   }

   public static void main(String[] args) {
      int[] input = {1,1,1};
      MonotonicArray obj = new MonotonicArray();
      System.out.println(obj.isMonotonic(input));
   }
}
