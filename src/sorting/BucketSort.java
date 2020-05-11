package sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

   private static int BUCKET_SIZE = 5;

   public void sort(int[] input){
      List<Integer>[] buckets = new LinkedList[BUCKET_SIZE];

      //create buckets
      createBuckets(buckets, input);

      //sort buckets
      sortBuckets(buckets);

      //combine sorted buckets result to the input array.
      int index = 0;
      for(var bucket : buckets){
         if(bucket != null){
            Iterator<Integer> iterator = bucket.iterator();
            while(iterator.hasNext())
               input[index ++] = iterator.next();
         }
      }


   }

   private void createBuckets(List<Integer>[] buckets, int[] input) {
      for(int item : input){
         if(buckets[item/BUCKET_SIZE] == null){
            List<Integer> list = new LinkedList<>();
            buckets[item/BUCKET_SIZE] = list;
         }
         buckets[item/BUCKET_SIZE].add(item);
      }
   }

   private void sortBuckets(List<Integer>[] buckets) {
      InsertionSort insertionSort = new InsertionSort();
      for(int i = 0; i < buckets.length; i ++){
         List<Integer> bucket = buckets[i];
         if(bucket != null){
            buckets[i] = createList(insertionSort.sort(bucket.toArray(new Integer[0])));
         }
      }
   }

   private List<Integer> createList(Integer[] sort) {
      List<Integer> list = new LinkedList<>();
      for(var num : sort)
         list.add(num);
      return list;
   }

   public static void main(String[] args){
      BucketSort obj = new BucketSort();
      int[] input = {2,4,1,7,4,9,20};
      obj.sort(input);
      System.out.println(Arrays.toString(input));
   }
}
