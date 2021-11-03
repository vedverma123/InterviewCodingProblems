package algoexpert;

import java.util.Arrays;

//O(nlogn) Time/ O(1) space
public class HeapSort {

   public void sort(int[] nums){
      if(nums == null || nums.length == 0)
         return;

      sort(nums, 0, nums.length - 1);
   }

   private void sort(int[] nums, int start, int end) {

      if(start == end)
         return;

      //build max heap
      buildMaxHeap(nums, start, end);

      //swap first and last element.
      swap(nums, start, end);

      //repeat
      sort(nums, start, end - 1);

   }

   private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   private void buildMaxHeap(int[] nums, int start, int end) {
      int lastParentIdx = (end - 1) / 2;
      for(int idx = lastParentIdx; idx >= start; idx --)
         siftDown(nums, idx, end);
   }

   private void siftDown(int[] nums, int currentIdx, int lastIdx) {
      int firstChildIdx = leftChildIdx(currentIdx);
      while(firstChildIdx <= lastIdx){
         int secondChildIdx = rightChildIdx(currentIdx) <= lastIdx ? rightChildIdx(currentIdx) : -1;
         int idxToSwap;
         if(secondChildIdx != -1 && nums[secondChildIdx] > nums[firstChildIdx]){
            idxToSwap = secondChildIdx;
         }else{
            idxToSwap = firstChildIdx;
         }

         if(nums[currentIdx] < nums[idxToSwap]){
            swap(nums, currentIdx, idxToSwap);
            currentIdx = idxToSwap;
            firstChildIdx = 2 * currentIdx + 1;
         }else
            return;
      }
   }

   private int rightChildIdx(int idx){
      return 2*idx + 2;
   }

   private int leftChildIdx(int idx){
      return 2*idx + 1;
   }

   public static void main(String[] args) {
      int[] nums = {8,5,2,9,5,6,3};
      new HeapSort().sort(nums);
      System.out.println(Arrays.toString(nums));
   }
}
