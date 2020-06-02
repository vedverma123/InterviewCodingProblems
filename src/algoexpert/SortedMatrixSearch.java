package algoexpert;

import java.util.Arrays;

/**
 * Search a given number in sorted 2D matrix.
 *
 * NOTE : Tried Binary search on the matrix, but it has many loop holes. Although it may run in O(logn*logm) time complexity.
 */
public class SortedMatrixSearch {

   //Time complexity : O(n+m), where n : rows and m:cols
   //Space complexity : O(1)
   public int[] searchInMatrix(int[][] matrix, int item){
      int[] output = {-1,-1};
      if(matrix == null || matrix.length == 0)
         return output;

      int row = 0;
      int col = matrix[0].length - 1;
      while(row < matrix.length && col >= 0){
         if(matrix[row][col] == item){
            output[0] = row;
            output[1] = col;
            break;
         }
         if(matrix[row][col] > item){
            //go left in the row
            --col;
         }
         //go bottom in the row
         else{
            ++row;
         }
      }

      return output;
   }

   public static void main(String[] args) {
      SortedMatrixSearch obj = new SortedMatrixSearch();
      int[][] matrix = {{1,4,7,12,15,1000},
            {2,5,19,31,32,1001},
            {3,8,24,33,35,1002},
            {40,41,42,44,45,1003},
            {500,510,520,550,570,2000}};
      System.out.println(Arrays.toString(Arrays.copyOfRange(obj.searchInMatrix(matrix, 0), 0, 2)));
   }













   public int[] search(int[][] matrix, int item){
      int[] output = {-1,-1, -1, -1};
      if(matrix == null || matrix.length == 0)
         return output;

      search(matrix, 0,0,matrix.length - 1, matrix[0].length - 1, item, output);
      if(output[2] > -1){
         return search(matrix, item, output);
      }else if(output[0] > -1){
         return output;
      }
      int[] noOutput = { -1, -1 };
      return noOutput;
   }

   private int[] search(int[][] matrix, int item, int[] output) {
      for(int i = output[0]; i <= output[2]; i ++)
         for(int j = 0; j <= matrix[i].length; j ++){
            if(matrix[i][j] == item){
               output[0] = i;output[1] = j;
               return output;
            }
         }
      output[0] = -1;
      output[1] = -1;
      return output;
   }

   private void search(int[][] matrix, int startRow, int startCol, int endRow, int endCol,
         int item, int[] output) {
      int midRow = startRow + (endRow - startRow) / 2;
      int midCol = startCol + (endCol - startCol) / 2;

      if(matrix[midRow][midCol] == item){
         output[0] = midRow;
         output[1] = midCol;
         return ;
      }

      if(matrix[midRow][midCol] > item){
         if(Math.abs(midRow - startRow) <= 1 || Math.abs(midCol - startCol) <= 1){
            populate(output, startRow, startCol, endRow, endCol);
            return;
         }
         search(matrix, startRow, startCol, midRow, midCol, item, output);
      }

      else
      {
         if(Math.abs(midRow - endRow) <= 1 || Math.abs(midCol - endCol) <= 1){
            populate(output, midRow, midCol, endRow, endCol);
            return;
         }
         search(matrix, midRow, midCol, matrix.length -1 , matrix[0].length - 1, item, output);
      }
   }

   private void populate(int[] output, int startRow, int startCol, int endRow, int endCol) {
      output[0] = startRow;
      output[1] = startCol;
      output[2] = endRow;
      output[3] = endCol;
   }

}
