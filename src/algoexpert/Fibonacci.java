package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {


   //Space complexity - O(n) : Because at a time, algo will be storing n call stack in the memory.
   //Time complexity - O(2^n) : because every fibnocci number invokes further 2 calls and so on.
   public int fibonacci(int number){
      if(number == 0)
         return 0;

      else if(number == 1)
         return 1;

      return fibonacci(number - 1) + fibonacci(number - 2);
   }

   //Space complexity - O(n) : Because at a time, algo will be storing n call stack in the memory.
   //Time complexity - O(n) : because now we are going to call every fibonacci number once and store it into HashMap. Because
   // hashmap add operation takes constant time.
   public int fibonacciUsingMap(int number){
      Map<Integer, Integer> map = new HashMap<>();
      return fibonacciUsingMap(number, map);
   }

   private int fibonacciUsingMap(int number, Map<Integer, Integer> map) {
      if(map.containsKey(number))
         return map.get(number);
      if(number == 0)
         return 0;
      else if(number == 1)
         return 1;

      int fibonacci = fibonacciUsingMap(number - 1 , map) + fibonacciUsingMap(number - 2, map);
      map.put(number, fibonacci);
      return map.get(number);
   }

   //Time Complexity - O(n)
   // Space complexity - O(1).
   public int fibonacciUsingArray(int number){
      int[] array = {0,1};
      int next = 0, count = 2;
      while(count <= number){
         next = array[0] + array[1];
         array[0] = array[1];
         array[1] = next;
         count ++;
      }
      return number > 1  ? array[1] : array[0];
   }

   public static void main(String[] args){
      Fibonacci obj = new Fibonacci();
      System.out.println(obj.fibonacci(10));
      System.out.println(obj.fibonacciUsingMap(10));
      System.out.println(obj.fibonacciUsingArray(100));
   }

}
