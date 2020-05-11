package datastructure.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {

   public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      if(nums1.length >= nums2.length){
         populateMap(nums2, map);
         list = arrayIntersection(nums1, map, nums2.length);
      }
      else{
         populateMap(nums1, map);
         list = arrayIntersection(nums2, map, nums1.length);
      }
      int[] arrayIntersection = new int[list.size()];
      for(int i = 0; i < list.size(); i ++){
         arrayIntersection[i] = list.get(i);
      }
      return  arrayIntersection;
   }

   public void populateMap(int[] numbers, Map<Integer, Integer> map){
      for(int i = 0; i < numbers.length; i ++){
         if(map.containsKey(numbers[i])){
            map.put(numbers[i], map.get(numbers[i]) + 1);
         }
         else{
            map.put(numbers[i], 1);
         }
      }
   }

   public List<Integer> arrayIntersection(int[] numbers, Map<Integer, Integer> map, int length){
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < numbers.length; i ++){
         if(map.containsKey(numbers[i]) && map.get(numbers[i]) > 0){
            list.add(numbers[i]);
            map.put(numbers[i], map.get(numbers[i]) - 1);
         }
      }
      return list;
   }

   public static void main(String[] args) {
      ArrayIntersection solution =  new ArrayIntersection();
      int[] intersection = solution.intersect(new int[]{1,2,3,4,5,6,7,7,8,7,7,8,8}, new int[]{2,2,5,6,7,77,7,8,8});
      for(int num: intersection){
         System.out.print(num + ",");
      }

   }
}