package algoexpert;

import java.util.Arrays;

public class MinMaxStackUsingArray {

   private int[] items;
   private int top;
   private int max;
   private int min;
   public MinMaxStackUsingArray(int initialCapacity) {
      items = new int[initialCapacity];
   }

   public void push(int item){
      if(!isFull()){
         max = top == 0 ? item : max > item ? max : item;
         min = top == 0 ? item : min < item ? min : item;
         items[top ++] = item;
      }
   }

   public int peek(){
      return items[top - 1];
   }

   public int pop(){
      if(isEmpty())
         throw new IllegalStateException("Stack is empty");

      return items[--top];
   }

   public int max(){
      return max;
   }

   public int min(){
      return min;
   }

   private boolean isEmpty(){
      return top <=0;
   }

   private boolean isFull(){
      return top >= items.length;
   }

   private void print(){
      System.out.println(Arrays.toString(Arrays.copyOfRange(items, 0, top)));
   }

   public static void main(String[] args) {
      MinMaxStackUsingArray stack = new MinMaxStackUsingArray(10);
      stack.push(5);
      stack.push(10);
      stack.push(7);
      stack.print();
      System.out.println(stack.max());
      System.out.println(stack.min());
      System.out.println(stack.peek());
      System.out.println(stack.pop());
      System.out.println(stack.peek());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      stack.push(8);
      stack.print();
      System.out.println(stack.peek());
      System.out.println(stack.pop());
      stack.print();
   }
}
