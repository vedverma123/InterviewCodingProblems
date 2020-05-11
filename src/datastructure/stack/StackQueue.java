package datastructure.stack;

import java.util.Stack;

public class StackQueue {

   public Stack<Integer> s1;
   public Stack<Integer> s2;

   public StackQueue(){
      s1 = new Stack<>();
      s2 = new Stack<>();
   }

   public void enqueue(int item){
      s1.push(item);
   }

   public int dequeue(){
      if (isEmpyty()){
         throw new IllegalStateException();
      }
      if(s2.isEmpty()){
         while(!s1.isEmpty()){
            s2.push(s1.pop());
         }
      }
      return s2.pop();
   }

   public boolean isEmpyty(){
      return s1.empty() && s2.empty();
   }

   public static void main(String[] args) {
      StackQueue queue = new StackQueue();
      queue.enqueue(10);
      queue.enqueue(20);
      queue.enqueue(30);

      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      queue.enqueue(40);
      queue.enqueue(50);
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());

   }
}
