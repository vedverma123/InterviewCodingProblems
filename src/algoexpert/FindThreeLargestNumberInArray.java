package algoexpert;

import java.util.Arrays;

/**
 * Time - O(n)
 * Space - O(1)
 */
public class FindThreeLargestNumberInArray {

    public int[] findThreeLargest(int[] input){
        if(input == null || input.length < 4)
            return input;

        int[] threeLargest = new int[3];
        for(int i = 0; i < threeLargest.length; i ++)
            threeLargest[i] = Integer.MIN_VALUE;
        for(int item : input)
            updateLargest(threeLargest, item);
        return threeLargest;
    }

    private void updateLargest(int[] threeLargest, int item) {
        if(threeLargest[2] == Integer.MIN_VALUE || threeLargest[2] < item)
            shiftAndUpdate(threeLargest,item, 2);
        else if(threeLargest[1] == Integer.MIN_VALUE || threeLargest[1] < item)
            shiftAndUpdate(threeLargest,item, 1);
        else if(threeLargest[0] == Integer.MIN_VALUE || threeLargest[0] < item)
            shiftAndUpdate(threeLargest,item, 0);

    }

    private void shiftAndUpdate(int[] threeLargest, int item, int index) {
        for(int i = 0; i < index; i ++)
            threeLargest[i] = threeLargest[i + 1];
        threeLargest[index] = item;
    }

    public static void main(String[] args){
        int[] input = {141,1,17,-7,-17,-27,18,541,8,7,7};
        System.out.println(Arrays.toString(new FindThreeLargestNumberInArray().findThreeLargest(input)));
    }
}
