package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Problem of Dynamic Programming.
// Time Complexity - O(n^2)
// Space Complexity - O(n)
public class DiskStacking {

    public List<Integer[]> maxHeight(int[][] input){

        if(input == null || input.length == 0)
            return new ArrayList<>();

        //sort the 2d array based on height.
        Arrays.sort(input, (a, b) -> Integer.compare(a[2], b[2]));

        int length = input.length;

        int[] sequence = new int[length];
        for(int i = 0; i < length ; i ++)
            sequence[i] = -1;

        int[] heights = new int[length];
        for(int i = 0; i < length; i ++){
            heights[i] = input[i][2];
        }

        int maxHeightIdx = 0;

        for(int i = 1; i < length; i ++){
            int[] currentDisk = input[i];
            for(int j = 0; j < i; j ++){
                int[] otherDisk = input[j];
                if(isValidDimension(otherDisk, currentDisk)){
                    if(heights[i] <= currentDisk[2] + heights[j]){
                        heights[i] = Math.max(heights[i], currentDisk[2] + heights[j]);
                        sequence[i] = j;
                    }
                }
            }

            if(heights[i] >= heights[maxHeightIdx])
                maxHeightIdx = i;
        }

        return buildSequence(maxHeightIdx, input, sequence);
    }

    private List<Integer[]> buildSequence(int maxHeightIdx, int[][] input, int[] sequence) {
        List<Integer[]> diskStacked = new ArrayList<>();
        while(maxHeightIdx != -1){
            diskStacked.add(Arrays.stream(input[maxHeightIdx]).boxed().toArray( Integer[]::new ));
            maxHeightIdx = sequence[maxHeightIdx];
        }
        Collections.reverse(diskStacked);
        return diskStacked;
    }

    private boolean isValidDimension(int[] otherDisk, int[] currentDisk) {
        return otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] && otherDisk[2] < currentDisk[2];
    }

    public static void main(String[] args) {
        int[][] input = {{2,2,1},{2,1,2},{3,2,3},{2,3,4},{4,4,5},{2,2,8}};
        System.out.println(new DiskStacking().maxHeight(input));
    }
}
