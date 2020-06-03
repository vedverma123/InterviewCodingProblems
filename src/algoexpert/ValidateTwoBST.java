package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two arrays of BST nodes, validate them and return true of they make same BST otherwise false.
 * NOTE : Validate them without actually creating a tree.
 */
public class ValidateTwoBST {

   //Space complexity - O(n^2)
   //Time complexity - O(n^2)
   public boolean validate(Integer[] first, Integer[] second){
      if((first == null && second == null) || (first.length == 0 && second.length == 0))
         return true;

      List<Integer> minList1 = new ArrayList<>();
      List<Integer> minList2 = new ArrayList<>();
      List<Integer> maxList1 = new ArrayList<>();
      List<Integer> maxList2 = new ArrayList<>();

      populateMinAndMax(minList1, maxList1, Arrays.asList(first));
      populateMinAndMax(minList2, maxList2, Arrays.asList(second));

      return validate(minList1, minList2) && validate(maxList1, maxList2);
   }

   private boolean validate(List<Integer> list1, List<Integer> list2) {
      if((list1 == null && list2 == null) || (list1.size() == 0 && list2.size() == 0))
         return true;

      if(list1.get(0) != list2.get(0) || list1.size() != list2.size())
         return false;

      if(list1.size() == 1 && list2.size() == 1 && list1.get(0) == list2.get(0))
         return true;

      List<Integer> minList1 = new ArrayList<>();
      List<Integer> minList2 = new ArrayList<>();
      List<Integer> maxList1 = new ArrayList<>();
      List<Integer> maxList2 = new ArrayList<>();

      populateMinAndMax(minList1, maxList1, list1);
      populateMinAndMax(minList2, maxList2, list2);

      return validate(minList1, minList2) && validate(maxList1, maxList2);
   }

   private void populateMinAndMax(List<Integer> minList1, List<Integer> maxList1, List<Integer> source) {
      for(int i = 1; i < source.size(); i ++)
         if(source.get(i) >= source.get(0))
            maxList1.add(source.get(i));
         else
            minList1.add(source.get(i));
   }

   public static void main(String[] args) {
      ValidateTwoBST obj = new ValidateTwoBST();
      Integer[] first = {10,8,5,15,2,12,11,94,81};
      Integer[] second = {10,15,8,12,94,81,5,2,11};
      System.out.println(obj.validate(first, second));
   }

}
