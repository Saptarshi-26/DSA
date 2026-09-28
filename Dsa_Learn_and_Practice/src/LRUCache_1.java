import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

class LRUCache_1 {
    private final int capacity;
    private int currentCapacity=0;

    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();




    public LRUCache_1(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {

        if(!map.containsKey(key)){
            if(currentCapacity<capacity){
                currentCapacity++;
            }
            else {
                map.remove(map.firstEntry().getKey());
            }
        }
        map.remove(key);
        map.put(key, value);
    }

    static void main() {
        LRUCache_1 lru = new LRUCache_1(2);
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