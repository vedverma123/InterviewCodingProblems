package dynamicprogramming;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][],
 * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 * Each cell of the matrix represents a cost to traverse through that cell.
 * Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination).
 * You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1)
 * and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 *
 */

/**
 * This is not working completely. I have used Dijkastra algo.
 */
public class MinCostPathMatrix {

   public int minCostPath(int[][] matrix, int x, int y){
      if(matrix == null || matrix.length == 0)
         return 0;

      int cost  = matrix[x][y];
      int[] startIndices = {x,y};
      while (startIndices[0] >= 0 && startIndices[1] >= 0){
         if(startIndices[0] == 0 && startIndices[1] == 0)
            return cost;

         else if(startIndices[0] != 0 && startIndices[1] != 0)
            getMinCostIndex(startIndices, matrix, x, y);

         else if(startIndices[0] == 0 && startIndices[1] != 0)
            startIndices[1] = startIndices[1] - 1;
         else
            startIndices[0] = startIndices[0] - 1;

         cost += matrix[startIndices[0]][startIndices[1]];
      }

      return cost;
   }

   private void getMinCostIndex(int[] startIndices, int[][] matrix, int destinationX, int destinationY) {
      int x = startIndices[0], y = startIndices[1];

      int a = matrix[x-1][y-1],b =  matrix[x-1][y], c = matrix[x][y-1];

      if(a <= b && a <= c){
         startIndices[0] = x - 1;
         startIndices[1] = y - 1;
      }else if(b <= a && b <= c)
         startIndices[0] = x - 1;
      else
         startIndices[1] = y - 1;

   }

   public static void main(String[] args) {
      MinCostPathMatrix obj = new MinCostPathMatrix();
      int[][] matrix = {{1,7,3},
                        {4,8,2},
                        {1,1,3}};
      System.out.print(obj.minCostPath(matrix, 1, 2));
   }

}
