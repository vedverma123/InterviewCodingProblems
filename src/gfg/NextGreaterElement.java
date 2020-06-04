package gfg;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array, return the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 *
 * Examples:
 *
 * For any array, rightmost element always has next greater element as -1.
 * For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 */
public class NextGreaterElement {

   public int[] nextGreaterElements(int[] input){
      if(input == null || input.length == 0)
         return new int[0];

      int[] output = new int[input.length];
      int count = 0;
      Stack<Integer> stack = new Stack<>();
      stack.push(input[0]);
      for(int i = 1; i < input.length; i ++){
         if(stack.peek() > input[i])
            stack.push(input[i]);
         else if(stack.peek() < input[i]){
            //keep popping
            while(!stack.empty()){
               output[count ++] = input[i];
               stack.pop();
            }
            stack.push(input[i]);
         }
      }
      while(!stack.isEmpty()){
         output[count ++] = -1;
         stack.pop();
      }


      return output;
   }

   public static void main(String[] args) {
      NextGreaterElement obj = new NextGreaterElement();
      int[] input = {4,3,2,1,0};
      System.out.println(Arrays.toString(obj.nextGreaterElements(input)));
   }

}
