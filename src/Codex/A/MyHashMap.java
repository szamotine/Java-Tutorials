package Codex.A;

import java.util.LinkedList;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int capacity;
    private final float loadFactor;
    private int size = 0;

    // Array of linked lists to handle collisions
    private LinkedList<Entry<K, V>>[] table;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        table = new LinkedList[capacity];
    }

    // Inner class to store key-value pairs as entries
    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = hash(key);

        // If no list at the index, create one
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Check for existing key in the linked list
        for (Entry<K, V> entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }

        // If not found, add the new entry
        table[index].add(new Entry<>(key, value));
        size++;

        // Check if resizing is necessary
        if ((float) size / capacity >= loadFactor) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    // Simple hash function (replace with a better one in a real implementation)
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Function to resize the hashmap
    private void resize() {
        capacity *= 2;
        LinkedList<Entry<K, V>>[] oldTable = table;
        var tables = new LinkedList<Entry<K, V>>();

        table = new LinkedList[capacity];
        size = 0; // Reset size since we are re-hashing

        for (LinkedList<Entry<K, V>> list : oldTable) {
            if (list != null) {
                for (Entry<K, V> entry : list) {
                    put(entry.key, entry.value);
                }
            }
        }
    }
}