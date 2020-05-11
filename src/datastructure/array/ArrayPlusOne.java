package datastructure.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayPlusOne {
   public int[] plusOne(int[] digits) {
      List<Integer> output = new ArrayList<>();
      int temp = 0;
      int num=0;
      for(int i = digits.length - 1 ; i >=0; i --){
         if(i ==digits.length - 1){
            num = digits[i] + 1;
         }else{
            num = digits[i] + temp;
            temp = 0;
         }
         if(num ==10){
            output.add(0);
            temp = 1;
         }else{
            output.add(num);
         }

         if(i == 0 && temp == 1){
            output.add(1);
         }
      }

      int[] outputArray = new int[output.size()];
      int j=0;
      for(int i = output.size() - 1; i >= 0 ;i --){
         outputArray[j] = output.get(i);
         j++;
      }
      return outputArray;
   }

   public static void main(String[] args) {
      ArrayPlusOne obj = new ArrayPlusOne();
      int[] output = obj.plusOne(new int[]{8,9,9,9});
      for(int i : output){
         System.out.print(i);
      }
   }
}
