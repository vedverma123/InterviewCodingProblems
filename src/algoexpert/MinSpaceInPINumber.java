package algoexpert;

import java.util.*;

public class MinSpaceInPINumber {

    public int getMinSpace(String input, String[] nums){
        if(input == null || nums == null || nums.length == 0)
            return 0;

        int length = input.length();

        Set<String> strings = new HashSet(Arrays.asList(nums));
        int[] indexes = new int[length];

        int minSpace = getMinSpace(input, strings, indexes, 0);
        return minSpace == Integer.MAX_VALUE ? -1 : minSpace;
    }

    private int getMinSpace(String input, Set<String> nums, int[] indexes, int idx) {
        if(idx == input.length())
            return -1;
        if(indexes[idx] != 0)
            return indexes[idx];
        int minSpace = Integer.MAX_VALUE;
        for(int i = idx; i < input.length(); i ++){
            String substring = input.substring(idx, i + 1);
            if(nums.contains(substring)){
                int minSpaceInSuffix = getMinSpace(input, nums, indexes, i + 1);
                minSpace = Math.min(minSpace, minSpaceInSuffix + 1);
            }
        }
        indexes[idx] = minSpace;
        return indexes[idx];
    }

    public static void main(String[] args) {
        String input = "3141592";
        String[] nums = {"3141", "5", "31", "2", "4159", "9", "42"};
        System.out.println(new MinSpaceInPINumber().getMinSpace(input, nums));
    }
}
