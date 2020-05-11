import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountTriplet {
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
         countTriplet(arr);
         t--;
      }
   }

   public static void countTriplet(int[] arr) {

      Map<Integer, Integer> map = new HashMap<>();
      for(int index = 0; index < arr.length; index ++){
         map.put(arr[index], index);
      }

      int count = 0;
      for(int i = 0; i < arr.length; i ++){
         int sum = arr[i];
         for(int j = i +1 ; j < arr.length; j ++)
            if(map.containsKey(sum + arr[j]))
               count ++;
      }
      System.out.println(count == 0 ? -1 : count);
   }
}
