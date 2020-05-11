package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayThreeNumberSum {

   //Time Complexity - O(n^2)
   //Space complexity - O(n) - to take extra map.
   public Set<Set<Integer>> findTriplet(Integer[] input, int targetSum){
      Set<Set<Integer>> triplets = new HashSet<>();

      //sort the input - O(nlogn) -> using Quick Sort
      //Collections.sort(Arrays.asList(input));

      //Store the sorted array into the map.
      Map<Integer, Integer> map = new HashMap<>();
      for(int index = 0; index < input.length; index ++)
         map.put(input[index], index);

      for(int i = 0; i < input.length ; i ++)
         for(int j = i + 1; j < input.length; j ++){
            int key = targetSum - input[i]-input[j];
            if(map.containsKey(key) && map.get(key) != i && map.get(key) != j){
               Set<Integer> set = new HashSet<>();
               set.add(input[i]);
               set.add(input[j]);
               set.add(key);
               triplets.add(set);
            }
         }
      return triplets;
   }

   //Time Complexity - O(n^2)
   //Space complexity - O(n) - to store triplets. But its better than the first one.
   public List<List<Integer>> findTripletUsingPointers(Integer[] input, int targetSum){
      List<List<Integer>> triplets = new ArrayList<>();
      //sort the input - O(nlogn) -> using Quick Sort
      Collections.sort(Arrays.asList(input));

      for(int current = 0; current < input.length - 1; current ++){
         int left = current + 1, right = input.length - 1;
         while (left < right){
            int currentSum = input[current] + input[left] + input[right];
            if(currentSum == targetSum){
               List<Integer> list = new ArrayList<>();
               list.add(input[left]);
               list.add(input[right]);
               list.add(input[current]);
               triplets.add(list);
               left ++; right --;
            }
            else if(currentSum > targetSum)
               right --;
            else
               left ++;

         }
      }
      return triplets;
   }

   public static void main(String[] args) {
      ArrayThreeNumberSum obj = new ArrayThreeNumberSum();
      Integer[] input = {12,3,1,2,-6,5,-8,6};
      System.out.println(obj.findTripletUsingPointers(input, 0));
   }

}
