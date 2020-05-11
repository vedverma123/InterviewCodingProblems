package dynamicprogramming;

public class LongestIncreasingSubsequence {

   public int findLIS(int[] array){
      if(array == null || array.length == 0)
         return 0;
      int[] lis = new int[array.length];

      for(int i =0; i < lis.length; i ++)
         lis[i] = 1;

      for(int i = 1 ; i < array.length; i ++)
         findLIS(array, lis, i);

      int max = Integer.MIN_VALUE;
      for(int item : lis)
         if(max < item)
            max = item;
      return max;
   }

   private void findLIS(int[] array, int[] lis, int i) {
      for(int j = 0; j < i; j ++){
         if(array[i] > array[j] && lis[i] < lis[j] + 1)
            lis[i] = lis[j] + 1;
      }
   }

   public static void main(String[] args) {
      LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
      int[] input = {5,9,10,2,10,13,15,21};
      System.out.print(obj.findLIS(input));
   }

}
