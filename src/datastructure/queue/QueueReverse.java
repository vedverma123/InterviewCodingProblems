package datastructure.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse {

   public static void main(String[] args) {
      Queue<Integer> queue = new ArrayDeque<>();

      queue.add(10);
      queue.add(20);
      queue.add(30);
      queue.add(40);
      System.out.println("Queue before reverse");
      System.out.println(queue);
      System.out.println("Queue after reverse");
      reverse(queue);
      System.out.println(queue);
   }

   public static void reverse(Queue<Integer> queue){
      //appraoch 1 : Using datastructure.array.stack.
      Stack<Integer> stack = new Stack<>();
      while(!queue.isEmpty()){
         stack.push(queue.remove());
      }
      while (!stack.isEmpty()){
         queue.add(stack.pop());
      }
      stack = null;
   }
}
