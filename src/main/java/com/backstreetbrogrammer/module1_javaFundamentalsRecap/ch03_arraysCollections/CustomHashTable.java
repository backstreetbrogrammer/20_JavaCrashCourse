package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch03_arraysCollections;

import java.util.ArrayList;

public class CustomHashTable<K, V> {

    // DoublyLinkedList node
    private static class LinkedListNode<K, V> {
        public LinkedListNode<K, V> next;
        public LinkedListNode<K, V> prev;
        public K key;
        public V value;

        public LinkedListNode(final K key, final V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedListNode<K, V>> array;

    public CustomHashTable(final int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity can not be less than 1");
        }
        array = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            array.add(null);
        }
    }

    /**
     * Insert key-value pair into hash table.
     *
     * @param key
     * @param value
     */
    public void put(final K key, final V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null");
        }
        LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null) { // already there
            node.value = value; // just update the value
            return;
        }

        node = new LinkedListNode<>(key, value);
        int index = getIndexForKey(key);
        if (array.get(index) != null) { // collision
            final int n = getAvailableIndexAfterLinearProbing();
            if (n == -1) { // no available index
                node.next = array.get(index);
                node.next.prev = node;
            } else {
                index = n;
            }
        }
        array.set(index, node);
    }

    /**
     * Get the value associated with the given key from hash table
     *
     * @param key
     * @return
     */
    public V get(final K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        final LinkedListNode<K, V> node = getNodeForKey(key);
        V value = null;
        if (node == null) {
            // may be indexed using linear probing - will always be head
            for (final LinkedListNode<K, V> lln : array) {
                if (lln != null && lln.key == key) {
                    value = lln.value;
                    break;
                }
            }
        } else {
            value = node.value;
        }
        return value;
    }

    /**
     * Remove key-value pair associated with the given key from hash table
     *
     * @param key
     */
    public void remove(final K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null");
        }

        final LinkedListNode<K, V> node = getNodeForKey(key);
        if (node != null && node.prev != null) {
            node.prev.next = node.next;
        } else {
            // Removing head - update
            final int hashKey = getIndexForKey(key);
            array.set(hashKey, node.next);
        }

        if (node.next != null) { // not a tail
            node.next.prev = node.prev;
        }
    }

    private int getAvailableIndexAfterLinearProbing() {
        int idx = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == null) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    // Get LinkedListNode associated with a given key
    private LinkedListNode<K, V> getNodeForKey(final K key) {
        final int index = getIndexForKey(key);
        LinkedListNode<K, V> current = array.get(index);
        while (current != null) { // collision
            if (current.key == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private int getIndexForKey(final K key) {
        // mask off the sign bit - turn 32-bit number into a 31-bit positive integer
        return (key.hashCode() & 0x7fffffff) % array.size();
    }
}
