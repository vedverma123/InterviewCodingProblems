package algoexpert;

import java.util.Arrays;

public class QuickSort {

   public int[] sort(int[] nums){
      if(nums == null || nums.length == 0)
         return nums;
      sort(nums, 0, nums.length);
      return nums;
   }
   private void sort(int[] nums, int low, int high){
      if(low == high)
         return;
      int j = partition(low, high, nums);
      sort(nums, low, j);
      sort(nums, j + 1, high);
   }

   private int partition(int low, int high, int[] nums){

      int pivot = nums[low];
      int i = low, j = high;
      while (i < j){
         do{
            i ++;
         }while (nums[i] <= pivot);

         do{
            j --;
         }while (nums[j] > pivot);
         if(i < j)
            swap(i, j, nums);
      }
      swap(j, low, nums);
      return j;
   }

   private void swap(int i, int j, int[] nums) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   public static void main(String[] args) {
      int[] input = {5,6,1,8,9,0,-1,10,12};
      System.out.println("Before Sorting--->");
      System.out.println(Arrays.toString(input));
      System.out.println("After Sorting--->");
      System.out.println(Arrays.toString(new QuickSort().sort(input)));
   }

}
