package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of numbers and the target sum, find the quadruples having sum equal to the target sum.
 */
public class ArrayFourNumberSum {

   //Time complexity : O(n^2) : Average case.
  //                   O(n^3) : Worst case.
  // Space complexity : O(n^2)
   public List<List<Integer>> findQuadruples(int[] input, int targetSum){
      if(input == null || input.length < 4)
         return new ArrayList<>();

      List<List<Integer>> quadruples = new ArrayList<>();
      Map<Integer, List<List<Integer>>> map = new HashMap<>();

      for(int i = 1; i < input.length ; i ++){
         for(int j = i + 1; j < input.length ; j ++){
            int diff = targetSum - (input[i] + input[j]);
            if(map.containsKey(diff)){
               final List<List<Integer>> lists = map.get(diff);

               //O(n/2) = O(n) in worst case.
               for(List<Integer> list : lists){
                  List<Integer> quadruple = new ArrayList<>();
                  quadruple.add(input[i]);
                  quadruple.add(input[j]);
                  quadruple.addAll(list);
                  if(!ifExist(quadruples, quadruple))
                     quadruples.add(quadruple);
               }
            }
         }
         for(int k = i - 1 ; k >=0; k --){
            List<Integer> list = new ArrayList<>();
            list.add(input[k]);
            list.add(input[i]);
            int key = input[k] + input[i];
            List<List<Integer>> lists = map.get(key);
            if(lists == null)
               lists = new ArrayList<>();
            if (!ifExist(lists, list)){
               lists.add(list);
               map.put(key, lists);
            }
         }
      }

      return quadruples;
   }

   private boolean ifExist(List<List<Integer>> quadruples, List<Integer> quadruple) {
      if(quadruples.size() == 0)
         return false;

      Collections.sort(quadruple);
      for(List<Integer> exist : quadruples){
         Collections.sort(exist);
         if(exist.equals(quadruple))
            return true;
      }
      return false;
   }

   public static void main(String[] args) {
      ArrayFourNumberSum obj = new ArrayFourNumberSum();
      int[] input = {2,-4,-5,-2,-3,-5,0,4,-2};
      int targetSum = -14;
      List<List<Integer>> quadruples = obj.findQuadruples(input, targetSum);
      for(List<Integer> quadruple : quadruples)
         System.out.println(Arrays.toString(quadruple.toArray()));
   }

}
