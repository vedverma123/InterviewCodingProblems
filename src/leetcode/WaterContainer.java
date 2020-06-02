package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 */
public class WaterContainer {
   public int maxArea(int[] height) {
      if(height == null || height.length < 2)
         return 0;

      int left = 0, right = height.length - 1;
      int maxArea = 0;
      while(left < right){
         int area = Math.min(height[left], height[right]) * (right - left);
         maxArea = Math.max(area, maxArea);
         if(height[left] > height[right])
            right --;
         else
            left ++;
      }
      return maxArea;
   }

   public static void main(String[] args) {
      WaterContainer obj = new WaterContainer();
      int[] input = {1,2,4,3};
      System.out.println(obj.maxArea(input));
   }
}
