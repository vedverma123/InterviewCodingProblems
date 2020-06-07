package gfg;

public class NumberSquareRoot {

   public double getSqrt(int num){
      if(num < 1)
         return 0;
      int i = 1;
      while(i <= num){
         if(num == i * i)
            return i;
         else if(i * i > num)
            break;
         i++;
      }

      return binarySearch(num, i -1, i);
   }

   private double binarySearch(int num, double min, double max) {
      double mid = (max + min)/2;
      double mul = mid * mid;
      if(num == mid * mid || Math.abs(mul - num) < 0.00001)
         return mid;
      else if(num < mul )
         return binarySearch(num, min, mid);
      else
         return binarySearch(num, mid, max);
   }

   public static void main(String[] args) {
      NumberSquareRoot obj = new NumberSquareRoot();
      int num = 3;
      System.out.println(obj.getSqrt(num));
   }

}
