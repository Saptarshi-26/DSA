import java.util.*;

class LRUCache {
    private final int capacity;
    private int currentCapacity=0;
    private int max=0;

    HashMap<Integer,Integer> map = new HashMap<>();
    HashMap<Integer,Integer> mapLRU = new HashMap<>();
    TreeSet<Integer> sortedSet = new TreeSet<>(Comparator.comparing(mapLRU::get));



    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        sortedSet.remove(key);
        mapLRU.put(key, ++max);
        sortedSet.add(key);
        return map.get(key);

    }

    public void put(int key, int value) {
       if(!map.containsKey(key)){
           if(currentCapacity<capacity){
               currentCapacity++;

           }
           else {
               int first=sortedSet.first();

               map.remove(first);
               sortedSet.remove(first);
               mapLRU.remove(first);

           }
           map.put(key, value);
           mapLRU.put(key,++max);
           sortedSet.add(key);

       }
       else {
           sortedSet.remove(key);
           mapLRU.put(key, ++max);
           map.put(key, value);
           sortedSet.add(key);
       }
    }

    static void main() {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1); // cache is {1=1}
        lru.put(2, 2); // cache is {1=1, 2=2}
        lru.get(1);    // return 1
        lru.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lru.get(2);    // returns -1 (not found)
        lru.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lru.get(1);    // return -1 (not found)
        lru.get(3);    // return 3
        lru.get(4);    // return 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */