package datastructure.array;

import java.util.Arrays;

public class Array {
   private int length;
   private int[] array;
   private int index;

   public Array(int length){
      this.length = length;
      array = new int[this.length];
      index = 0;
   }

   public void insert(int item){
      if(index == this.array.length){
         int[] temp = new int[index + 1];
         for (int count = 0; count < this.array.length ; count ++){
            temp[count] = this.array[count];
         }
         temp[index] = item;
         this.array = temp;
      }
      else{
         this.array[index] = item;
         index ++;
      }
      print();
   }

   private void print() {
      System.out.println(Arrays.toString(this.array));
   }

   public void removeAt(int index){
      if(index < this.array.length){
         int[] temp = new int[this.array.length - 1];
         int j = 0;
         for(int count = 0; count < array.length ; count ++){
            if(count != index){
               temp[j] = array[count];
               j++;
            }
         }
         this.array = temp;
         print();
      }
      else{
         System.out.println(index +" is greater than datastructure.array length");
      }
   }

   public int indexOf(int number){
      for(int count = 0; count < array.length; count ++){
         if(array[count] == number){
            return count;
         }
      }
      return -1;
   }

   public static void main(String[] args) {
      Array numbers = new Array(3);
      numbers.insert(10);
      numbers.insert(20);
      numbers.insert(30);
      numbers.insert(40);
      numbers.removeAt(1);
      numbers.insert(60);
      System.out.println(numbers.indexOf(60));
   }
}
