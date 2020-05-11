import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class NumberOfPairs {

   static int findPairs(int[] x, int[] y){
      int count  = 0;
      for(int i = 0; i < x.length; i ++)
         for(int j = 0; j < y.length; j ++){
            BigDecimal bigDecimal1 = new BigDecimal(Math.pow(x[i], y[j]));
            BigDecimal bigDecimal2 = new BigDecimal(Math.pow(y[j], x[i]));
            if(bigDecimal1.compareTo(bigDecimal2) == 1)
               count ++;
         }
      return count;
   }

   public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(reader.readLine());
      while(t>0)
      {
         String[] split = reader.readLine().split(" ");
         int m = Integer.parseInt(split[0]);
         int n = Integer.parseInt(split[1]);
         int x[] = new int[m];
         int y[] = new int[n];
         split = reader.readLine().split(" ");
         for(int i = 0; i<m ;i++)
         {
            x[i] = Integer.parseInt(split[i]);
         }
         split = reader.readLine().split(" ");
         for(int i = 0; i<n ;i++)
         {
            y[i] = Integer.parseInt(split[i]);
         }

         System.out.println(findPairs(x, y));
         t--;
      }
   }

}
