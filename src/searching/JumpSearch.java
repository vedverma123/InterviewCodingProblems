package searching;

public class JumpSearch {

   public int search(int[] numbers, int item){

      if(numbers.length == 1)
         return numbers[0] == item ? 0 : -1;

      int blockSize = (int)Math.ceil(Math.sqrt(numbers.length));
      int left = 0, right = left + blockSize;

      if(numbers.length == 2)
         return numbers[0] == item ? 0 : numbers[1] == item ? 1 : -1;

      while(right >= left && right <= numbers.length - 1){
         if(item == numbers[left])
            return left;

         if(item == numbers[right])
            return right;

         //search within a block
         if(item < numbers[right]){
            return search(item, left, right, numbers);

         } else{
            left = right;
            if(left >= numbers.length)
               break;
            right += blockSize;
            if(right > numbers.length)
               right = numbers.length;
         }
      }
      return -1;
   }

   private int search(int item, int left, int right, int[] numbers) {
      for(int i = left; i <= right; i ++)
         if(numbers[i] == item)
            return i;

      return -1;
   }

   public static void main(String[] args){
      JumpSearch obj = new JumpSearch();
      int[] input = {2,5,7,10,14,15,19,20,30,34,38,39,40};
      System.out.print(obj.search(input, 20));
   }
}
