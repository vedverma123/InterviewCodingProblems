package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a binary array and an integer m,
 * find the position of zeroes flipping which creates maximum number of consecutive 1’s in array.
 *
 * Examples :
 *
 * Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
 *          m = 2
 * Output:  5 7
 * We are allowed to flip maximum 2 zeroes. If we flip
 * arr[5] and arr[7], we get 8 consecutive 1's which is
 * maximum possible under given constraints
 */
public class FlippingZeros {

   //Solving using sliding window concept.
   public List<Integer> flipZeros(int[] input, int m){
      if(input == null || input.length == 0)
         return new ArrayList<>();

      List<Integer> output = new ArrayList<>();

      int windowLeft = 0, windowRight = 0;
      int zeroCount = 0;
      int bestWindow = 0;
      int bestWindowStart = 0;
      while(windowRight < input.length){
         if(zeroCount <= m){
            if(input[windowRight] == 0)
               zeroCount ++;
            windowRight ++;

         }
         if(zeroCount > m){
            if(input[windowLeft] == 0)
               zeroCount --;
            windowLeft ++;
         }

         if(bestWindow < windowRight - windowLeft){
            bestWindow = windowRight - windowLeft;
            bestWindowStart = windowLeft;
         }
      }

      for(int i = bestWindowStart; i <= bestWindow; i ++)
         if(input[i] == 0)
            output.add(i);

      return output;
   }

   public static void main(String[] args) {
      FlippingZeros obj = new FlippingZeros();
      int[] input = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
      System.out.print(Arrays.toString(obj.flipZeros(input, 1).toArray()));
   }

}
