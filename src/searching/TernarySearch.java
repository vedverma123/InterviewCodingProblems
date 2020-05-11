package searching;

public class TernarySearch {

   public int search(int[] input, int item){
      if(input.length == 0)
         return -1;

      if(input.length == 1)
         return input[0] == item ? 0 : -1;

      int left = 0, right = input.length - 1;
      return search(input, item, left, right);
   }

   private int search(int[] input, int item, int left, int right){
      int partitions = (right - left) / 3;
      int mid1 = left + partitions, mid2 = right - partitions;

      if(right - left <= 1)
         return input[left] == item ? left : input[right] == item ? right : -1;

      if(item == input[mid1])
         return mid1;

      if(item == input[mid2])
         return mid2;

      if(item < input[mid1])
         return search(input, item, left, mid1 - 1);

      else if(item > input[mid1] && item < input[mid2])
         return search(input, item, mid1 + 1, mid2 - 1);

      else
         return search(input, item, mid2 + 1, right);
   }

   public static void main(String[] args) {
      TernarySearch obj = new TernarySearch();
      int[] input = {1,9,20,24,25};
      System.out.print(obj.search(input, 25));
   }

}
