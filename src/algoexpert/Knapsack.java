package algoexpert;

import java.util.Arrays;

public class Knapsack{

    public int[][] findMaxKnapsack(int [][] input, int maxCapacity){

        int[][] values = new int[input.length][2];
        if(input == null || input.length == 0)
            return values;

        int rows = input.length + 1;
        int cols = maxCapacity + 1;
        int[][] maxKnapsack = new int[rows][cols];

        for(int i = 1; i < rows; i ++){
            int weightValue[] = input[i - 1];
            int currentWeight = weightValue[1];
            int currentValue = weightValue[0];
            for(int currentCapacity = 0; currentCapacity < cols; currentCapacity ++){
                if(currentCapacity >= currentWeight){
                    maxKnapsack[i][currentCapacity] =
                            Math.max(maxKnapsack[i - 1][currentCapacity], maxKnapsack[i - 1][currentCapacity - currentWeight] + currentValue);
                }else{
                    maxKnapsack[i][currentCapacity] = maxKnapsack[i - 1][currentCapacity];
                }
            }
        }

        int i = maxKnapsack.length - 1;
        int j = maxKnapsack[0].length - 1;
        int count = 0;
        while(maxKnapsack[i][j] != 0){
            if(maxKnapsack[i][j] != maxKnapsack[i - 1][j]){
                int[] value = input[i - 1];
                values[count] = value;
                i = i -1;
                j = j - value[1];
                count ++;
            }else{
                i = i - 1;
            }
        }
        int[][] finalArr = new int[count][2];
        System.arraycopy(values, 0, finalArr , 0, count);
        return finalArr;
    }

    public static void main(String[] args){
        int input[][] = {{1,2},{4,3},{5,6},{6,7}};
        final int[][] maxKnapsack = new Knapsack().findMaxKnapsack(input, 10);
        for(int[] maxVal : maxKnapsack)
            System.out.println(Arrays.toString(maxVal));
    }
}