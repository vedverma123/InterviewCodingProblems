package datastructure.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CustomHashMap<K,V> {

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1,"Ved");
        map.put(2,"Dev");
        map.put(6,"AK");
        map.put(11,"HELLO");
        map.put(0,"HELLO");
        map.put(2,"HEYYY");

        System.out.println(map);
        System.out.println(map.get(3));
        System.out.println(map.containsKey(1));
        System.out.println(map.get(6));
        map.remove(11);
        System.out.println(map);
        System.out.println(map.get(11));
    }

    private List<Entry>[] entries;
    private int capacity = 5;

    public CustomHashMap(){
        entries = new LinkedList[capacity];
    }

    @Override
    public String toString() {
        return "{" +
                "" + Arrays.toString(entries) +
                '}';
    }

    public int hashCode(K key) {
        return key instanceof Integer ? (Integer) key % capacity : 0;
    }

    public void put(K key, V value){
        Entry<K, V> entry = new Entry<>(key, value);
        //get the hash
        int hash = hashCode(key);
        List<Entry> bucket;
        if(entries[hash] == null){
            bucket = new LinkedList<>();
            entries[hash] = bucket;
        }else{
            bucket = entries[hash];
            for(Entry bucketEntry : bucket){
                if(bucketEntry.getKey().equals(key)){
                    bucketEntry.value = value;
                    return;
                }
            }
        }
        bucket.add(entry);
    }

    public boolean containsKey(K key){
        return entries[hashCode(key)] != null;
    }

    public void remove(K key){
        int hash = hashCode(key);
        if(entries[hash] != null){
            final List<Entry> list = entries[hash];
            final Iterator<Entry> iterator = list.iterator();
            while(iterator.hasNext()){
                final Entry entry = iterator.next();
                if(key.equals(entry.getKey())){
                    iterator.remove();
                }
            }
        }
    }

    public V get(K key){
        int hash = hashCode(key);
        if(entries[hash] != null){
            final List<Entry> list = entries[hash];
            final Optional<Entry> opt = list.stream().filter(entry -> key.equals(entry.getKey())).findFirst();
            return opt.isPresent() ? (V) opt.get().getValue() : null;
        }
        return null;
    }


    private class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}
