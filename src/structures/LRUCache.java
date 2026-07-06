package structures;

import java.util.ArrayDeque;
import java.util.HashMap;

class LRUCache {
    private HashMap<Integer, Integer> hash;
    private ArrayDeque<Integer> queue;
    private int capacity;

    public LRUCache(int capacity, ArrayDeque<Integer> queue) {
        this.queue = new ArrayDeque<>();
        this.hash = new HashMap<>();
        this.capacity = capacity;

//        HashMap<Integer, Integer> hash;
//        ArrayDeque<Integer> queue;

    }

    public int get(int key) {

        if (hash.containsKey(key)){
            int val = hash.get(key);
            queue.remove(key);
            queue.addFirst(key);
            return val;
        }

        return -1;
    }

    public void put(int key, int value) {
        // check if it exists
        if (hash.containsKey(key)){
            hash.put(key, value);
            queue.remove(key);
            queue.addFirst(key);
            return;
        }

        // check capacity
        if (hash.size() >= capacity){
            hash.remove(key);
            hash.put(key, value);

            queue.removeLast();
            queue.addFirst(key);
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */