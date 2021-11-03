package algoexpert;

public class MinJump {

    //Space - O(n) and Time - O(n^2)
    public int minJump(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        int length = arr.length;
        int[] jumps = new int[length];
        jumps[0] = 0;

        for(int i = 1; i < length; i ++)
            jumps[i] = Integer.MAX_VALUE;

        for(int i = 1; i < length; i ++){
            int j = 0;
            while(j < i){
                if(arr[j] + j >= i){
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
                j ++;
            }
        }
        return jumps[length - 1];
    }

    public static void main(String[] args){
        System.out.println(new MinJump().minJump(new int[]{3,4,2,1,2,3,7,1,1,1,1,3}));
    }
}
