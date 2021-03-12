package algoexpert;

import java.util.Arrays;

public class ZigzagTraverse {

    public int[] traverse(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return new int[0];
        int[] output = new int[matrix.length * matrix[0].length];
        int width = matrix[0].length - 1;
        int height = matrix.length - 1;
        int row = 0, col = 0;
        boolean isGoingDown = true;
        int k = 0;
        while(!isOutOfOrder(row, col, width, height)){
            output[k] = matrix[row][col];

            if(isGoingDown){
                if(col == 0 || row == height){
                    isGoingDown = false;
                    if(col == 0)
                        row += 1;
                    else
                        col += 1;
                }else{
                    col -= 1;
                    row += 1;
                }
            }else{
                if(row == 0 || col == width){
                    isGoingDown = true;
                    if(row == 0)
                        col += 1;
                    else
                        row += 1;
                }else{
                    col += 1;
                    row -= 1;
                }
            }
            k ++;
        }
        return output;
    }

    public boolean isOutOfOrder(int row, int col, int width, int height){
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,3,4,10},{2,5,9,11},{6,8,12,15},{7,13,14,16}};
        ZigzagTraverse obj = new ZigzagTraverse();
        System.out.println(Arrays.toString(obj.traverse(matrix)));
    }
}
