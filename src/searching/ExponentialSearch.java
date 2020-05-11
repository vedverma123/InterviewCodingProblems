package searching;

import java.util.Arrays;

public class ExponentialSearch {

   public int search(int[] numbers, int item){

      if(numbers.length == 0)
         return -1;

      int bound = 1;
      int prevBound = 0;
      while(bound <= numbers.length -1 && numbers[bound] < item){
         prevBound = bound;
         bound *= 2;
      }

      if(bound >= numbers.length)
         bound = numbers.length - 1;

      if(item >= numbers[prevBound] && item <= numbers[bound]){
         BinarySearch binarySearch = new BinarySearch();
         int index = binarySearch.recursiveSearch(Arrays.copyOfRange(numbers, prevBound, bound + 1), item);
         return index != -1 ? prevBound + index : -1;
      }

      return -1;
   }

   public static void main(String[] args) {
      ExponentialSearch obj = new ExponentialSearch();
      int[] numbers = {20,21};
      System.out.print(obj.search(numbers, 22));
   }

}
