package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskExecutor{
    public static List<Integer> rodOffcut(List<Integer> lengths) {
        if(lengths == null || lengths.isEmpty()){
            return new ArrayList<>();
        }
        List<Integer> output = new ArrayList<>();

        while(!lengths.isEmpty()){
            output.add(lengths.size());
            int min = findShortest(lengths);
            lengths = discardAndCut(min, lengths);
        }
        return output;

    }

    public static List<Integer> discardAndCut(int min, List<Integer> lengths){
        List<Integer> output = new ArrayList<>();
        for(int num : lengths){
            if(num > min){
                output.add(num - min);
            }
        }
        return output;
    }

    public static int findShortest(List<Integer> nums){
        Collections.sort(nums);
        return nums.get(0);
    }

    public static void main(String[] args) {
        Integer[] a = {1,1,3,4};

        new TaskExecutor().rodOffcut(Arrays.asList(a));
    }

}