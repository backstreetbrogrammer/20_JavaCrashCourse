package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch03_arraysCollections;

import java.util.concurrent.atomic.AtomicInteger;

public class RingBuffer<E> {

    private static final int DEFAULT_CAPACITY = 8;

    private final int capacity;
    private final E[] data;
    private final AtomicInteger writeSequence = new AtomicInteger(-1);
    private final AtomicInteger readSequence = new AtomicInteger();

    public RingBuffer(final int capacity) {
        this.capacity = (capacity < 1) ? DEFAULT_CAPACITY : capacity;
        this.data = (E[]) new Object[this.capacity];
    }

    public boolean offer(final E element) {
        if (isNotFull()) {
            data[writeSequence.incrementAndGet() % capacity] = element;
            return true;
        }

        return false;
    }

    public E poll() {
        if (isNotEmpty()) {
            return data[readSequence.getAndIncrement() % capacity];
        }

        return null;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return (writeSequence.get() - readSequence.get()) + 1;
    }

    public boolean isEmpty() {
        return writeSequence.get() < readSequence.get();
    }

    public boolean isFull() {
        return size() >= capacity;
    }

    private boolean isNotEmpty() {
        return !isEmpty();
    }

    private boolean isNotFull() {
        return !isFull();
    }

}
