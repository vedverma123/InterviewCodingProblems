package datastructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArrayWithDesiredSum {

   public static void subArray(int[] input, int sum){
      int desiredSum = 0;
      int left = 0, right = 0;
      boolean isSubArrayFound = false;
      while(right < input.length){
         if(desiredSum == sum){
            isSubArrayFound = true;
            break;
         }
         else if(desiredSum < sum && right <= input.length - 1){
            desiredSum += input[right];
            right ++;
         }
         else if(left <= input.length - 1){
            desiredSum -= input[left];
            left ++;
         }
      }
      if(isSubArrayFound)
         System.out.println(new StringBuffer().append(left + 1).append(" ").append(right));
      else
         System.out.println("-1");
   }

   public static void main(String[] args) throws IOException {

      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(reader.readLine());
      while(t>0)
      {
         String[] split = reader.readLine().split(" ");
         int n = Integer.parseInt(split[0]);
         int s = Integer.parseInt(split[1]);
         int arr[] = new int[n];
         split = reader.readLine().split(" ");
         for(int i = 0; i<n;i++)
         {
            arr[i] = Integer.parseInt(split[i]);
         }
         subArray(arr,s);
         System.out.println();
         t--;
      }

   }
}
