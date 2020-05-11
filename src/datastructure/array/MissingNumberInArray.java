package datastructure.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class MissingNumberInArray {

   public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(reader.readLine());
      while(t>0)
      {
         int n = Integer.parseInt(reader.readLine());
         int arr[] = new int[n];
         String[] split = reader.readLine().split(" ");
         for(int i = 0; i<n -1;i++)
         {
            arr[i] = Integer.parseInt(split[i]);
         }
         System.out.println(findMissingNumber(arr, n));
         t--;
      }
   }

   static int findMissingNumber(int[] input, int maxLimit) {
      Set<Integer> integers = new HashSet<>();
      for(int item : input){
         integers.add(item);
      }

      for(int i = 1; i <= maxLimit; i ++){
         if(!integers.contains(i))
            return i;
      }
      return 0;
   }
}
