import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KadaneAlgo {

   public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(reader.readLine());
      while(t>0)
      {
         int n = Integer.parseInt(reader.readLine());
         int arr[] = new int[n];
         String[] split = reader.readLine().split(" ");
         for(int i = 0; i<n;i++)
         {
            arr[i] = Integer.parseInt(split[i]);
         }
         System.out.println(maxSubArray(arr));
         t--;
      }
   }

   static int maxSubArray(int[] input){
      int maxSoFar = Integer.MIN_VALUE;
      int maxEndingHere = 0;

      for(int i = 0; i < input.length; i ++){
         maxEndingHere += input[i];

         if(maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere;
         if(maxEndingHere < 0)
            maxEndingHere = 0;
      }
      return maxSoFar;
   }
}
