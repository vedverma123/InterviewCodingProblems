package gfg;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
 * Find out how many hours does it take to infect all humans?
 *
 * Example:Input:[[0, 1, 1, 0, 1],[0, 1, 0, 1, 0],[0, 0, 0, 0, 1],[0, 1, 0, 0, 0]]
 * Output: 2
 */
public class ZombieAndHumanProblem {

   int getHoursToTurnIntoZombie(int[][] input){
      if(input == null || input.length == 0)
         return -1;

      int hours = 0;
      int rows = input.length;
      int cols = input[0].length;
      int totalElements = rows*cols;
      int count  = 0;
      Queue<int[]> zombieQueue = new LinkedList<>();
      for(int i =0; i < input.length; i ++){
         for(int j = 0; j < input[i].length; j ++){
            if(input[i][j] == 1){
               zombieQueue.offer(new int[]{i,j});
               count ++;
            }
         }
      }

      int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
      while(!zombieQueue.isEmpty()){
         int size = zombieQueue.size();
         if(count == totalElements)
            return hours;
         for(int i = 0; i < size; i ++){
            final int[] current = zombieQueue.poll();
            for(int[] direction : directions){
               int row = direction[0] + current[0];
               int col = direction[1] + current[1];
               if(row >= 0 && row < rows && col >= 0 && col < cols && input[row][col] == 0){
                  input[row][col] = 1;
                  count ++;
                  zombieQueue.offer(new int[]{row,col});
               }
            }
         }
         hours ++;
      }

      return hours;
   }

   public static void main(String[] args) {
      ZombieAndHumanProblem obj = new ZombieAndHumanProblem();
      int[][] input = {{0, 1, 1, 0, 1},{0, 1, 0, 1, 0},{0, 0, 0, 0, 1},{0, 1, 0, 0, 0}};
      System.out.println(obj.getHoursToTurnIntoZombie(input));
   }

}
