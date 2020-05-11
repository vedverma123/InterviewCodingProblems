package algoexpert;

public class LongestPeakArray {

   //Time complexity - O(n) - Although there are a couple of nested loops, but no element would be traverse twice so thats why
   // time complexity is O(n).
   // Space complexity - O(1).
   public int find(int[] input){
      if(input == null)
         return 0;

      int current = 1;
      int longestPeak = 0;
      while(current < input.length - 1){
         if(input[current] > input[current - 1] && input[current] > input[current + 1]){
            int currentPeak = getPeakPoints(input, current);
            if(currentPeak > longestPeak)
               longestPeak = currentPeak;
         }
         current++;
      }
      return longestPeak;
   }

   private int getPeakPoints(int[] input, int peakTip) {
      int start = peakTip;
      int end = peakTip;
      while (start > 0 && input[start] > input[start - 1])
         start --;

      while(end < input.length - 1 && input[end] > input[end + 1])
         end ++;

      return end - start + 1;
   }

   public static void main(String[] args) {
      LongestPeakArray obj = new LongestPeakArray();
      int[] input = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};
      System.out.println(obj.find(input));
   }
}
