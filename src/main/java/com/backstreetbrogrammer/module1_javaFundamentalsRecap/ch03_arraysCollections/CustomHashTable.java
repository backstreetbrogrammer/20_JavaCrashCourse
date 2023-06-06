package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch03_arraysCollections;

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


}
