package datastructure.stack;

public class StackUsingArray {

   private int[] items ;
   private int size;
   private int initialCapacity;

   public StackUsingArray(){
      initialCapacity = 5;
      items = new int[initialCapacity];
   }

   public void push(int item){
      if(size >= initialCapacity){
         initialCapacity = initialCapacity * 2;
         int[] newItems = new int[initialCapacity];
         copyItems(items, newItems);
         items = newItems;
      }
      items[size ++] = item;
   }

   private void copyItems(int[] items, int[] newItems) {
      for(int count = 0; count < size; count ++ )
         newItems[count] = items[count];
   }

   public int pop(){
      if(size == 0)
         throw new IllegalStateException();
      return items[--size];
   }

   public int peek(){
      if(size == 0)
         throw new IllegalStateException();
      return items[size - 1];
   }

   public boolean isEmpty(){
      return size == 0;
   }

   public static void main(String[] args) {
      StackUsingArray stack = new StackUsingArray();
      stack.push(10);
      stack.push(20);
      stack.push(30);
      stack.push(40);
      stack.push(50);
      stack.push(60);

      System.out.println(stack.peek());
      System.out.println(stack.pop());
      System.out.println(stack.pop());

      stack.push(140);
      stack.push(150);
      stack.push(160);

      System.out.println(stack.pop());
      System.out.println(stack.pop());

      System.out.println(stack.isEmpty());
   }
}
