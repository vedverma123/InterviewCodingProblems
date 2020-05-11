package datastructure.map;

import java.util.Iterator;
import java.util.LinkedList;

public class HashMapUsingLinkedList {

   private LinkedList<Entry>[] items;
   private int count ;

   public HashMapUsingLinkedList(){
      items = new LinkedList[5];
   }

   public void put(int key, String value){
      Entry item = new Entry(key, value);
      int hashcode = hashCode(key);
      final LinkedList<Entry> existing = items[hashcode];
      if(existing != null){
         Iterator<Entry> iterator = existing.iterator();
         while(iterator.hasNext()){
            Entry entry = iterator.next();
            if(entry.key == key){
               entry.value = value;
               return;
            }
         }
         existing.addLast(item);
      }
      else{
         LinkedList<Entry> entries = new LinkedList<>();
         entries.add(item);
         items[hashcode] = entries;
      }

   }

   public String get(int key){
      final LinkedList<Entry> item = items[hashCode(key)];
      if(item != null){
         if (item.size() == 1 )
            return item.getFirst().value;

         final Iterator<Entry> iterator = item.iterator();
         while (iterator.hasNext()){
            final Entry next = iterator.next();
            if(next.key == key)
               return next.value;
         }
      }
      return null;
   }

   public void remove(int key){
      final LinkedList<Entry> entries = items[hashCode(key)];
      if(entries != null){
         for(var entry : entries){
            if(entry.key == key){
               entries.remove(entry);
               return;
            }
         }
      }
   }

   private class Entry{
      private int key;
      private String value;

      public Entry(int key, String value){
         this.key = key;
         this.value = value;
      }
   }

   @Override
   public String toString() {
      StringBuilder stringBuilder = new StringBuilder("{ ");
      for (LinkedList<Entry> item : items){
         if(item != null){
            final Iterator<Entry> iterator = item.iterator();
            while(iterator.hasNext()){
               final Entry entry = iterator.next();
               stringBuilder.append(entry.key + " = " + entry.value).append(" ");
            }
            stringBuilder.append(",");
         }
      }
      return stringBuilder.append("}").toString();
   }


   private int hashCode(int key) {
      return key % items.length;
   }

   public static void main(String[] args) {
      HashMapUsingLinkedList map = new HashMapUsingLinkedList();
      map.put(3,"A");
      map.put(3,"B");
      map.put(5,"D");
      map.put(6,"C");
      map.put(1,"Z");
      map.put(8,"ABC");
      System.out.println(map);
      System.out.println(map.get(3));
      map.remove(8);
      map.remove(3);
      map.put(8,"DEF");
      System.out.println(map);
   }
}
