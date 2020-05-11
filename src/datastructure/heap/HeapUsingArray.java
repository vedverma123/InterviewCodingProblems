package datastructure.heap;

import java.util.Arrays;

public class HeapUsingArray {

   private int[] items;
   private int count;

   public HeapUsingArray() {
      items = new int[10];
   }

   public void insert(int item){
      if(count > items.length - 1)
         throw new IllegalStateException();
      items[count ++] = item;
      bubbleUp();
   }

   private void bubbleUp(){
      int index = count - 1;
      while(index > 0 && items[index] > items[parentIndex(index)]){
         swap(parentIndex(index), index);
         index = parentIndex(index);
      }
   }

   private int parentIndex(int index){
      return (index - 1)/2;
   }

   private void swap(int parentIndex, int childIndex) {
      int temp = items[parentIndex];
      items[parentIndex] = items[childIndex];
      items[childIndex] = temp;
   }

   public void remove(){
      if(count == 0)
         throw new IllegalStateException();
      items[0] = items[--count];
      int index = 0;
      while(index <= count && items[index] < leftChild(index) && items[index] < rightChild(index)){
         int largerChildIndex = largerChildIndex(index);
         swap(index, largerChildIndex);
         index = largerChildIndex;
      }
   }

   private int largerChildIndex(int index){
      return leftChild(index) > rightChild(index) ? leftChildIndex(index) : rightChildIndex(index);
   }

   private int leftChild(int index){
      return items[leftChildIndex(index)];
   }

   private int rightChild(int index){
      return items[rightChildIndex(index)];
   }

   private int rightChildIndex(int index){
      return 2*index + 2;
   }

   private int leftChildIndex(int index){
      return 2*index + 1;
   }

   public static void main(String[] args) {

      HeapUsingArray heap = new HeapUsingArray();
      heap.insert(10);
      heap.insert(12);
      heap.insert(15);
      heap.insert(4);
      heap.insert(40);
      heap.remove();
      heap.insert(5);
      heap.remove();
      System.out.println(Arrays.toString(heap.items));
   }
}
