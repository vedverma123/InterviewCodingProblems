package datastructure.queue;

import java.util.Arrays;

public class PriorityQueueUsingArray {

   private int[] items;
   private int initialCapacity;
   private int count ;

   public PriorityQueueUsingArray(int initialCapacity){
      this.initialCapacity = initialCapacity;
      items = new int[initialCapacity];
   }

   public void add(int item){
      if(count >= items.length){
         throw new IllegalStateException();
      }
      int index = count -1;
      while(index >= 0 && items[index] > item){
         items[index + 1] = items[index];
         index --;
      }
      items[index + 1] = item;
      count ++;
   }

   @Override
   public String toString() {
      return Arrays.toString(Arrays.copyOfRange(items, 0, count));
   }

   public int remove(){
      if(isEmpty())
         throw new IllegalStateException();

      int item = items[0];
      for (int index = 1; index < count ; index ++){
         items[index - 1] = items[index];
      }
      count --;
      return item;
   }

   public boolean isEmpty(){
      return count == 0;
   }

   public static void main(String[] args) {
      PriorityQueueUsingArray queue = new PriorityQueueUsingArray(5);
      queue.add(10);
      queue.add(20);
      queue.add(8);
      System.out.println(queue);
      System.out.println(queue.remove());
      queue.add(12);
      queue.add(10);
      queue.add(18);
      System.out.println(queue);
      System.out.println(queue.remove());
      System.out.println(queue);
      System.out.println(queue.remove());
      System.out.println(queue);
      queue.add(15);
      queue.add(21);
      System.out.println(queue);
   }

}
