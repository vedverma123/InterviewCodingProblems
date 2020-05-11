package algoexpert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArrayTwoNumberSum {

   //space complexity - O(n)
   //time complexity - O(n)
   public void findPairs(Integer[] input, int target){
      Map<Integer, Integer> map = new HashMap<>();
      for(int i = 0; i < input.length ; i ++)
         map.put(input[i], i);
      for(int num : map.keySet()){
         int index = map.containsKey((target - num)) ? map.get(target - num) : -1;
         if(index != -1 && index != map.get(num)){
            System.out.print("Pairs are --->" + num + ", " + (target - num));
            break;
         }
      }
   }

   //space complexity - O(1)
   //time complexity - O(nlogn)
   public void getPairs(Integer[] input, int target){
      //sort the input array.
      Collections.sort(Arrays.asList(input));

      int left = 0, right = input.length - 1;
      while(right > left){
         int sum = input[left] + input[right];
         if(sum == target){
            System.out.print("Pairs are --->" + input[left] + ", " + input[right]);
            break;
         }
         else if(sum > target)
            right --;
         else
            left ++;
      }
   }

   public static void main(String[] args) {
      ArrayTwoNumberSum obj = new ArrayTwoNumberSum();
      Integer[] input = {3,5,-4,8,11,1,-1,6};
      obj.getPairs(input, 13);
   }

}
