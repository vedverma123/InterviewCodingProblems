package gfg;

import java.util.LinkedList;
import java.util.Queue;

/*
{
  { 0, 0, 0, 0 },
  { 2, 0, 0, 0 },
  { 2, 1, 0, 0 },
  { 2, 2, 0, 0 }
 }
*/

public class MinMovesRequiredInGrid {
    static class Pair{
        int x,y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int minMovesRequired(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return 0;

        Queue<Pair> personQ = new LinkedList();
        Queue<Pair> fireQ = new LinkedList();

        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col ++){
                if(matrix[row][col] == 0)
                    continue;
                else if(matrix[row][col] == 1){
                    personQ.add(new Pair(row,col));
                }else{
                    fireQ.add(new Pair(row, col));
                }
            }
        }

        boolean[][] visited = new boolean[rows][cols];
        int depth = 0;
        while(!personQ.isEmpty()){
            int size = personQ.size();
            depth ++;
            for(int count = size; count > 0; count --){

                Pair current = personQ.remove();

                if(matrix[current.x][current.y] == 2)
                    continue;

                //get all the neighbours and add them in queue.
                boolean isBorderFound = visitNeighbours(personQ, current, visited, matrix);
                if(isBorderFound)
                    return depth;
            }

            int fireSize = fireQ.size();

            for(int count = fireSize; count > 0; count --){
                Pair current = fireQ.remove();
                visitFireNeighbours(current, fireQ, matrix);
            }
        }
        return -1;
    }

    public void visitFireNeighbours(Pair current, Queue<Pair> fireQ, int[][] matrix){
        int x = current.x;
        int y = current.y;
        visitFireNeighbour(x + 1, y, fireQ, matrix);
        visitFireNeighbour(x - 1, y, fireQ, matrix);
        visitFireNeighbour(x, y + 1, fireQ, matrix);
        visitFireNeighbour(x, y - 1, fireQ, matrix);
    }

    public void visitFireNeighbour(int x, int y, Queue<Pair> fireQ, int[][] matrix){
        if(isValid(x,y,matrix.length, matrix[0].length) && matrix[x][y] != 2){
            matrix[x][y] = 2;
            fireQ.add(new Pair(x,y));
        }
    }

    public boolean visitNeighbours(Queue<Pair> personQ, Pair current, boolean[][] visited, int[][] matrix){
        int x = current.x;
        int y = current.y;
        if(visitNeighbour(x + 1, y, visited, personQ, matrix) || visitNeighbour(x - 1, y, visited, personQ, matrix)
            || visitNeighbour(x, y + 1, visited, personQ, matrix) || visitNeighbour(x, y - 1, visited, personQ, matrix))
            return true;
        return false;
    }

    public boolean visitNeighbour(int x, int y, boolean[][] visited, Queue<Pair> personQ, int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(isValid(x,y, matrix.length, matrix[0].length) && !visited[x][y] && matrix[x][y] != 2){
            visited[x][y] = true;
            personQ.add(new Pair(x,y));
            if(isBorder(x,y, rows, cols)){
                return true;
            }
        }
        return false;
    }

    public boolean isValid(int x, int y, int rows, int cols){
        return x >=0 && x < rows && y >=0 && y < cols;
    }

    public boolean isBorder(int x, int y, int rows, int cols){
        return (x == 0 || x == rows - 1) || (y == 0 || y == cols - 1);
    }

    public static void main(String[] args){
        int[][] matrix = {
                { 0, 0, 0, 0 },
                { 2, 0, 0, 0 },
                { 2, 1, 0, 0 },
                { 2, 2, 0, 0 }
        };
        System.out.println(new MinMovesRequiredInGrid().minMovesRequired(matrix));
    }
}
