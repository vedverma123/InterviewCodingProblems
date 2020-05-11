package datastructure.queue;

import java.util.Arrays;

public class ArrayQueue {

   private int[] items;
   private int initialCapacity;
   private int front;
   private int rear;
   private int count ;

   public ArrayQueue(int initialCapacity){
      this.initialCapacity = initialCapacity;
      items = new int[initialCapacity];
   }

   public void enqueue(int item){
      if(isFull())
         throw new IllegalStateException();
      else{
         items[rear] = item;
         rear = (rear + 1) % items.length;
         count ++;
      }
   }

   public int dequeue(){
      if(isEmpty())
         throw new IllegalStateException();
      int item = items[front];
      count --;
      front = (front + 1) % items.length;
      return item;
   }

   public int peek(){
      return items[front];
   }

   public boolean isEmpty(){
      return count ==0;
   }

   public boolean isFull(){
      return count >= initialCapacity ;
   }

   @Override
   public String toString() {
      return Arrays.toString(items);
   }

   public static void main(String[] args) {
      ArrayQueue queue = new ArrayQueue(5);
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);
      queue.enqueue(40);
      queue.enqueue(50);
      System.out.println(queue);
      System.out.println(queue.dequeue());
      System.out.println(queue);
      queue.enqueue(60);
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue);
      queue.enqueue(160);
      System.out.println(queue);
      System.out.println("rear : " + queue.rear + ", front : " + queue.front + " count : " + queue.count);

   }

}
