package gfg;

import java.util.Arrays;

public class ProductArray {

    public long[] productArray(int[] nums){
        if(nums == null || nums.length == 0)
            return null;

        long[] productArray = new long[nums.length];
        Long[] left = new Long[nums.length];

        long temp = 1;
        for(int i = 0; i < nums.length ; i ++){
            left[i] = temp;
            temp *= nums[i];
        }
        //{1, 10, 30, 150, 900}

        temp = 1;
        for(int i = nums.length - 1; i>=0; i --){
            productArray[i] = temp;
            temp *= nums[i];
        }
        //{180,60,12,2,1}

        for(int i = 0; i < productArray.length; i ++){
            productArray[i] *= left[i];
        }

        return productArray;
    }

    public static void main(String[] args){
        ProductArray obj = new ProductArray();
        System.out.println(Arrays.toString(obj.productArray(new int[]{10, 3, 5, 6, 2})));
    }
}
