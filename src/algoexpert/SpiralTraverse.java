package algoexpert;

import java.util.Arrays;

public class SpiralTraverse {

   //Time complexity - O(n)
   //Space complexity - O(n)
   public int[] traverse(int[][] input, int i, int j){
      int[] output = new int[i*j];
      int startRow = 0, endRow = i -1;
      int startCol = 0, endCol = j - 1;

      int count = 0;
      while(startRow < endRow && startCol < endCol){
         count = traversePerimeter(input, startRow, endRow, startCol, endCol, output, count);
         startRow ++;
         endRow --;
         startCol ++;
         endCol --;
      }

      return output;
   }

   private int traversePerimeter(int[][] input, int startRow, int endRow, int startCol, int endCol, int[] output, int count) {

      for(int i = startCol; i <= endCol; i ++)
         output[count ++] = input[startRow][i];

      for(int j = startRow + 1; j <= endRow; j ++)
         output[count ++] = input[j][endCol];

      for(int k = endCol - 1; k >= startCol; k --)
         output[count ++] = input[endRow][k];

      for(int l = endRow - 1; l > startRow; l --)
         output[count ++] = input[l][startCol];

      return count;
   }

   public static void main(String[] args) {
      int i = 4, j =4;
      int[][] input = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
      SpiralTraverse obj = new SpiralTraverse();
      System.out.println(Arrays.toString(obj.traverse(input, i , j)));
   }

}
