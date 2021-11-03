package algoexpert;

import java.util.Arrays;

//time - O(n + logn) / Space - O(logn)
public class SearchInRotatedSortedArray {
   public int search(int[] nums, int target){
      if(nums == null || nums.length == 0)
         return - 1;

      int length = nums.length;
      //find out the pivot index
      int index = 1;
      while(index < length && nums[index - 1] < nums[index]){
         index ++;
      }

      //first array = 0 to index - 1
      //second array = index to length

      //left part
      if(target >= nums[0] && target <= nums[index - 1]){
         return doBinarySearch(Arrays.copyOfRange(nums, 0, index), 0, index - 1, target);
      }
      //right part
      else if (index < length && target >= nums[index] && target <= nums[length - 1]){
         int result = doBinarySearch(Arrays.copyOfRange(nums, index, length), 0, length - index, target);
         return result != -1 ? index + result : -1;
      }
      else
         return -1;
   }

   private int doBinarySearch(int[] nums, int start, int end, int target){

      if(end - start <= 1)
         return nums[start] == target ? start : nums[end] == target ? end : - 1;


      int mid = (start + end) / 2;

      if(target <= nums[mid])
         return doBinarySearch(nums, start, mid, target);
      else
         return doBinarySearch(nums, mid, end, target);
   }

   public static void main(String[] args) {
      int[] input = {3,1};
      System.out.println(new SearchInRotatedSortedArray().search(input, 3));
   }
}
