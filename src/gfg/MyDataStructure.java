package gfg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports insert, delete, search and getRandom in O(1) time.
 */
public class MyDataStructure {

   private Map<Integer,Integer> map;
   private List<Integer> list;

   public MyDataStructure() {
      map = new HashMap<>();
      list = new ArrayList<>();
   }

   private boolean isEmpty(){
      return map.size() ==0 && list.size() == 0;
   }

   public void insert(int item){
      if(!map.containsKey(item)){
         int size = list.size();
         list.add(item);
         map.put(item, size);
      }
   }

   public void remove(int item){
      if(isEmpty())
         return;
      Integer index = map.get(item);
      if(index == null)
         return;
      map.remove(item);
      int size = list.size();
      int lastElement = list.get(size - 1);
      Collections.swap(list, index, size - 1);
      list.remove(size - 1);
      map.put(lastElement, index);
   }

   public Integer search(int item){
      return map.get(item);
   }

   public int getRandom(){
      Random random = new Random();
      return list.get(random.nextInt(list.size()));
   }

   public static void main(String[] args) {
      MyDataStructure obj = new MyDataStructure();
      obj.insert(10);
      obj.insert(20);
      obj.insert(30);
      obj.insert(40);
      obj.insert(50);
      obj.remove(30);
      obj.insert(60);
   }

}
