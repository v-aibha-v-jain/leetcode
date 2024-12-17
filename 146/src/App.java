import java.util.Map;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        // Create an LRUCache object with capacity 3
        LRUCache lruCache = new LRUCache(3);

        // Put some key-value pairs into the cache
        lruCache.put(1, 100);
        lruCache.put(2, 200);
        lruCache.put(3, 300);

        // Access some keys to test the LRU behavior
        System.out.println("Get key 1: " + lruCache.get(1)); // Output: 100
        System.out.println("Get key 2: " + lruCache.get(2)); // Output: 200

        // Add a new key-value pair, this should evict the least recently used key
        lruCache.put(4, 400);

        // Test eviction
        System.out.println("Get key 3: " + lruCache.get(3)); // Output: -1 (evicted)
        System.out.println("Get key 4: " + lruCache.get(4)); // Output: 400

        // Add another key-value pair
        lruCache.put(5, 500);

        // Test eviction
        System.out.println("Get key 1: " + lruCache.get(1)); // Output: -1 (evicted)
        System.out.println("Get key 2: " + lruCache.get(2)); // Output: 200
        System.out.println("Get key 5: " + lruCache.get(5)); // Output: 500
    }
}
class LRUCache {
    Map<Integer, Integer> map = new HashMap<>(); // stores key-value pairs
    Deque<Integer> deque; // stores keys in order of usage
    int capacity; // maximum capacity of the cache

    public LRUCache(int capacity) {
        this.deque = new ArrayDeque<>(capacity); // initialize deque with given capacity
        this.capacity = capacity; // set the capacity
    }

    public int get(int key) {
        if (map.containsKey(key)) { // if key is present in the map
            deque.removeFirstOccurrence(key); // remove the key from its current position in deque
            deque.addLast(key); // add the key to the end of deque
            return map.get(key); // return the value associated with the key
        }
        return -1; // return -1 if key is not present
    }
    
    public void put(int key, int value) {
        if (map.size() < capacity || map.containsKey(key)) { // if there is space or key is already present
            deque.removeFirstOccurrence(key); // remove the key from its current position in deque
        } else {
            int lastkey = deque.pollFirst(); // remove the least recently used key from deque
            map.remove(lastkey); // remove the least recently used key from map
        }
        map.put(key, value); // add the key-value pair to the map
        deque.addLast(key); // add the key to the end of deque
    }
}