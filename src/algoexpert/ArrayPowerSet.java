package algoexpert;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of elements, return the powerset of given input.
 * Powerset is a set of all subsets of the given array.
 * Eg : {1,2,3} : {{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}
 */
public class ArrayPowerSet {

   //Time complexity - O(n*2^n)
   //Space complexity - O(n*2^n)
   public List<List<Integer>> powerSet(Integer[] input){
      List<List<Integer>> powerSet = new ArrayList<>();
      if(input == null || input.length == 0)
         return powerSet;

      powerSet.add(new ArrayList<>());

      //loop for number of combinations
      for(int i = 0; i < input.length; i ++){
         int size = powerSet.size();
         for(int j = 0; j < size; j ++){
            List<Integer> subset = new ArrayList<>();
            subset.addAll(powerSet.get(j));
            subset.add(input[i]);
            powerSet.add(subset);
         }
      }
      return powerSet;
   }

   public static void main(String[] args) {
      ArrayPowerSet obj = new ArrayPowerSet();
      List<List<Integer>> powerSet = obj.powerSet(new Integer[]{1,2,3,4,5,6});
      System.out.println("Total :" + powerSet.size() + " combinations");
      for(List<Integer> subset : powerSet){
         System.out.print("{");
         for(int item : subset)
            System.out.print(item +" ");
         System.out.print("}");
         System.out.println();
      }
   }

}
