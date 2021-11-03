package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem of Dynamic Programming.
// I/P [8,12,2,3,15,5,7]
// sum [8,20,2,5,35,10,17]
// sequence[-1,0,-1,2,1,3,5]
// Ans - 35.
public class MaxSumIncreasingSubsequence {
    //O(n^2)
    public Integer[] getIncreasingSubsequence(int[] input){
        if(input == null || input.length == 0)
            return new Integer[0];

        int[] sum = new int[input.length];
        int[] sequence = new int[input.length];

        for(int i = 0; i < sequence.length; i ++)
            sequence[i] = -1;

        for(int i = 0; i < input.length; i ++){
            sum[i] = input[i];
            int j = 0;
            while(j < i){
                if(input[j] < input[i]){
                    if(sum[j] + input[i] > sum[i]){
                        sum[i] = sum[j] + input[i];
                        sequence[i] = j;
                    }

                }
                j++;
            }
        }
        int maxSumIdx = -1;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < sum.length; i ++){
            if(maxSum < sum[i]){
                maxSumIdx = i;
                maxSum = sum[i];
            }
        }
        List<Integer> increasingSeq = new ArrayList<>();
        while(maxSumIdx != -1){
            increasingSeq.add(maxSumIdx);
            maxSumIdx = sequence[maxSumIdx];
        }
        return increasingSeq.toArray(new Integer[0]);
    }

    public static void main(String[] args){
        int[] input = {8,12,2,3,15,5,7};
        System.out.println(Arrays.toString(new MaxSumIncreasingSubsequence().getIncreasingSubsequence(input)));
    }

}
