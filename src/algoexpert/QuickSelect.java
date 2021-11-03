package algoexpert;

//Kth smallest/largest problems can be solved using min heap as well,
// but here we will see how we can such problem using Quick select algo.
// Quick select also developed by the same guy who developed quick sort.

//O(n) time and O(1) space.
public class QuickSelect{

   public int kthSmallest(int[] nums, int k) throws Exception {
      if(nums == null || nums.length == 0)
         return Integer.MIN_VALUE;
      int position = k - 1;
      return kthSmallest(nums, 0, nums.length - 1, position);
   }

   private int kthSmallest(int[] nums, int low, int high, int position) throws Exception {
      if(low > high)
         throw new Exception("Illegal state");
      //get the pivot location
      int pivotIdx = partition(nums, low, high);
      if(pivotIdx == position)
         return nums[pivotIdx];
      else if(pivotIdx > position)
         return kthSmallest(nums, low, pivotIdx - 1, position);
      else
         return kthSmallest(nums, pivotIdx + 1, high, position);
   }

   private int partition(int[] nums, int low, int high) {
      if(low == high)
         return high;
      int pivot = nums[low];
      int i = low;
      int j = high;
      while(i <= j){
         while(pivot >= nums[i]){
            i++;
         }
         while (pivot < nums[j]){
            j --;
         }
         if(i < j)
            swap(nums, i, j);
      }
      swap(nums, j, low);
      return j;
   }

   private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
   }

   public static void main(String[] args) throws Exception {
      int[] nums = {8,5,9,7,6,3};
      System.out.println(new QuickSelect().kthSmallest(nums, 6));
   }
}