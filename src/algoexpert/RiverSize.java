package algoexpert;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a 2D matrix(not necessarily square matrix) of numbers 0 and 1 represents land and river respectively.
 * A river is a combination of adjacent(top/left/right/bottom) 1's.
 * Return an array of total river with size.
 * eg: for input below, output is [2, 1, 5, 2, 2].
 */

//Time complexity : O(n), where n is total number of elements into the given matrix.
//Space complexity : O(n) : using visited matrix.
public class RiverSize {

   public Integer[] getRiverSize(int[][] matrix){
      if(matrix == null)
         return new Integer[0];

      Stack<Integer> totalRiver = new Stack<>();
      boolean[][] visitedMatrix = new boolean[matrix.length][matrix[0].length];

      for(int i = 0; i < matrix.length; i ++){
         for(int j = 0; j < matrix[i].length; j ++){
            if(visitedMatrix[i][j] || matrix[i][j] == 0)
               continue;
            visitedMatrix[i][j] = true;
            totalRiver.push(1);
            visitNeighbours(i, j, matrix, visitedMatrix, totalRiver);
         }
      }
      return totalRiver.toArray(new Integer[0]);
   }

   private void visitNeighbours(int i, int j, int[][] matrix, boolean[][] visitedMatrix, Stack<Integer> totalRiver) {
      visitNeighbour(i -1 , j, totalRiver, visitedMatrix, matrix);
      visitNeighbour(i + 1 , j, totalRiver, visitedMatrix, matrix);
      visitNeighbour(i , j - 1, totalRiver, visitedMatrix, matrix);
      visitNeighbour(i , j + 1, totalRiver, visitedMatrix, matrix);
   }

   private void visitNeighbour(int i, int j, Stack<Integer> totalRiver, boolean[][] visitedMatrix, int[][] matrix) {
      if(i >=0 && i < matrix.length && j >=0 && j < matrix[i].length && matrix[i][j] == 1 && !visitedMatrix[i][j]){
         int riverSize = totalRiver.pop();
         totalRiver.push(++riverSize);
         visitedMatrix[i][j] = true;
         visitNeighbours(i, j, matrix, visitedMatrix, totalRiver);
      }
   }

   public static void main(String[] args) {
      int[][] matrix = {{1,0,1,1,0},
                        {1,0,1,0,0},
                        {0,0,1,0,1},
                        {1,0,1,0,1},
                        };
      System.out.print(Arrays.toString(new RiverSize().getRiverSize(matrix)));
   }
}
