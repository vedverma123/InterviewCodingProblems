package algoexpert;

import java.util.Arrays;

public class MoveElementArray {

   //Time Complexity - O(n)
   // Space complexity - O(1)
   public int[] move(int[] input, int num){
      if(input == null)
         throw new IllegalStateException();

      int count = 0, index = 0;
      while(index < input.length){
         if(input[index] != num){
            input[count] = input[index];
            count++;
         }
         index ++;
      }

      while(count < input.length)
         input[count ++] = num;

      return input;
   }

   public static void main(String[] args) {
      MoveElementArray obj = new MoveElementArray();
      int[] input = {2,1,2,2,2,3,4,2};
      System.out.println(Arrays.toString(obj.move(input, 2)));
   }

}
