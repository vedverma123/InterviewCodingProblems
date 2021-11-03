package leetcode;

import java.util.Arrays;

//{1,1}, {2,3}, {4,5}, {4,6}, {6,7}
//Its incomplete.
public class RussianDoll {
    public int maxEnvelopes(int[][] input) {
        if(input == null || input.length == 0)
            return 0;

        //sort the 2d array based on height.
        Arrays.sort(input, (a, b) -> Integer.compare(a[1], b[1]));

        int length = input.length;
        int[] maxEnvelope = new int[length];

        for(int i = 0; i < length; i ++){
            maxEnvelope[i] = 1;
        }

        for(int i = 1; i < length; i ++){
            int count = 1;
            int[] currentDisk = input[i];

            for(int j = 0; j < i; j ++){
                int[] otherDisk = input[j];

                if(otherDisk[0] < currentDisk[0] && otherDisk[1] < currentDisk[1] ){
                    count ++;
                    maxEnvelope[i] = Math.max(maxEnvelope[i], count);
                }
            }
        }

        return maxEnvelope[length - 1];
    }

    public static void main(String[] args) {
        int[][] input = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(new RussianDoll().maxEnvelopes(input));
    }
}
