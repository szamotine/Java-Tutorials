package Codex.B;

import java.util.LinkedList;

class Entry<K, V> {
    K key;
    V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class MyHashMap<K, V> {
    private final int capacity = 16; // Initial capacity
    private final LinkedList[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[capacity];
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }

        // Handle duplicates by updating the value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    private int getIndex(K key) {
        // Simple hash function - can be improved upon for distribution
        return Math.abs(key.hashCode() % capacity);
    }
}
