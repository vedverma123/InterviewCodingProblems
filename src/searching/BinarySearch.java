package searching;

public class BinarySearch {

   public int recursiveSearch(int[] input, int item){
      if(input.length == 0)
         return - 1;

      if(input.length == 1)
         return input[0] == item ? 0 : -1;

      return recursiveSearch(input, item, 0, input.length - 1);
   }

   private int recursiveSearch(int[] input, int item, int left, int right){

      if(right - left == 1)
         return input[left] == item ? left : input[right] == item ? right : -1;

      int middle = (left + right) / 2;

      if(input[middle] >= item)
         return recursiveSearch(input, item, 0, middle);
      else
         return recursiveSearch(input, item, middle, right);
   }

   public int iterativeSearch(int[] input, int item){
      if(input.length == 0)
         return - 1;
      if(input.length == 1)
         return input[0] == item ? 0 : -1;

      int left = 0, right = input.length - 1;
      while(right - left != 1){
         int middle = (left + right) / 2;
         if(input[middle] >= item)
            right = middle;
         else
            left = middle;
      }
      return input[left] == item ? left : input[right] == item ? right : -1;
   }


   public static void main(String[] args) {
      int[] input = {2,4,6,30};
      BinarySearch obj = new BinarySearch();
      System.out.println("Using Recursion ----------->" + obj.recursiveSearch(input, 3));
      System.out.println("Using Iteration ----------->" + obj.iterativeSearch(input, 30));
   }

}
