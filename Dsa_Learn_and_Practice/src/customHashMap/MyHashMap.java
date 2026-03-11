package customHashMap;
import java.util.*;
public class MyHashMap <K,V>{

    @SuppressWarnings("unchecked")
    MyHashMap(){
        Capacity=16;
        size=0;
        bucket= (Entry<K, V>[]) new Entry[Capacity];
    }

    int Capacity;
    int size;
    Entry<K,V>[] bucket;

   class Entry <K,V> {
       K key;
       V value;
       Entry<K,V> next;

       public Entry(K key, V value) {
           this.key=key;
           this.value= value;
       }
   }


   void put(K key , V value){

       int index = Math.abs(key.hashCode()) % Capacity;
        Entry<K,V> head = bucket[index];
        Entry<K,V> current = head;
         while(current!=null){
             if(current.key.equals(key)){
                 current.value=value;
                 return ;
             }
             current=current.next;
       }
         Entry<K, V> newEntry = new Entry<>(key,value);
         newEntry.next = head;
         bucket[index] = newEntry;
         size++;

   }

   V get(K key){
       int index = Math.abs(key.hashCode()) % Capacity;
       Entry < K , V> head = (Entry < K , V > ) bucket[index];
       Entry < K , V > current = head;
       while(current!=null){
           if(current.key.equals(key))
               return current.value;
           current=current.next;
       }
       System.out.println(new NullPointerException("Key not found").toString());
       return null;
   }
   void remove (K key){
       int index = Math.abs(key.hashCode()) % Capacity;
       Entry < K , V> current = (Entry < K , V > ) bucket[index];
       Entry < K , V > prev  = null;
       while(current!=null){
              if(current.key.equals(key)){
                  if(prev==null){
                      bucket[index]=current.next;
                  }
                  else{
                      prev.next=current.next;
                  }
                  size--;
                  return ;
              }
              prev=current;
              current=current.next;

       }

       System.out.println(new NullPointerException("Key not found").toString());

   }

}
