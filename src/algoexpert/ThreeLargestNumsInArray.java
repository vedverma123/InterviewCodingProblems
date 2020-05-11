package algoexpert;

import java.util.Arrays;

public class ThreeLargestNumsInArray {


   //space complexity - O(1)
   // time complexity - O(n/2) * 3 = O(n).
   public int[] find(int[] input){
      createMaxHeap(input);
      int[] threeLargestNums = new int[3];
      for(int count = 1, j = 2 ; count <=3; count ++, j --){
         threeLargestNums[j] = remove(input);
         createMaxHeap(input);
      }

      return threeLargestNums;
   }

   private int remove(int[] input) {
      int temp = input[0];
      input[0] = input[input.length - 1];
      return temp;
   }

   private int getLeftChildIndex(int index){
      return 2*index + 1;
   }

   private int getRightChildIndex(int index){
      return 2*index + 2;
   }

   private void createMaxHeap(int[] input) {
      for(int index = input.length / 2; index >= 0; index --){
         if(getRightChildIndex(index) >= input.length || getLeftChildIndex(index) >= input.length)
            continue;
         if(!isParentValid(index, input)){
            int largerIndex = getLargerIndex(index, input);
            swap(index, largerIndex, input);
         }
      }
   }

   private void swap(int index, int largerIndex, int[] input) {
      int temp = input[index];
      input[index] = input[largerIndex];
      input[largerIndex] = temp;
   }

   private int getLargerIndex(int index, int[] input) {
      return leftChild(index, input) > righChild(index, input) ? getLeftChildIndex(index) : getRightChildIndex(index);
   }

   private boolean isParentValid(int index, int[] input) {
      return input[index] >= leftChild(index, input) && input[index] >= righChild(index, input);
   }

   private int righChild(int index, int[] input) {
      return input[getRightChildIndex(index)];
   }

   private int leftChild(int index, int[] input) {
      return input[getLeftChildIndex(index)];
   }


   public static void main(String[] args) {
      int[] input = {141,1,1,-7,-17,-27,8,541,7,7, 1000};
      ThreeLargestNumsInArray obj = new ThreeLargestNumsInArray();
      System.out.println(Arrays.toString(obj.find(input)));
   }

}
