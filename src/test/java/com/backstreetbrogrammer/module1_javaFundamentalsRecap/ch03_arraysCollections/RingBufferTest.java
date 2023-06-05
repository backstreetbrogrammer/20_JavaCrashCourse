package com.backstreetbrogrammer.module1_javaFundamentalsRecap.ch03_arraysCollections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RingBufferTest {

    private final String[] data = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    private final int defaultCapacity = data.length;

    @Test
    public void givenRingBuffer_whenAnElementIsEnqueued_thenSizeIsOne() {
        final RingBuffer<String> buffer = new RingBuffer<>(defaultCapacity);

        assertTrue(buffer.offer("D"));
        assertEquals(1, buffer.size());
    }

    @Test
    public void givenRingBuffer_whenAnElementIsDequeued_thenElementMatchesEnqueuedElement() {
        final RingBuffer<String> buffer = new RingBuffer<>(defaultCapacity);
        buffer.offer("B");

        final String cellData = buffer.poll();
        assertEquals("B", cellData);
    }

    @Test
    public void givenRingBuffer_whenAnElementIsEnqueuedAndDeququed_thenBufferIsEmpty() {
        final RingBuffer<String> buffer = new RingBuffer<>(defaultCapacity);
        buffer.offer("C");

        assertFalse(buffer.isEmpty());
        assertEquals(1, buffer.size());

        buffer.poll();

        assertTrue(buffer.isEmpty());
    }

    @Test
    public void givenRingBuffer_whenFilledToCapacity_thenNoMoreElementsCanBeEnqueued() {
        final int capacity = data.length;
        final RingBuffer<String> buffer = new RingBuffer<>(capacity);

        assertTrue(buffer.isEmpty());

        for (final String shape : data) {
            buffer.offer(shape);
        }

        assertTrue(buffer.isFull());
        assertFalse(buffer.offer("Octagon"));
    }

    @Test
    public void givenRingBuffer_whenBufferIsEmpty_thenReturnsNull() {
        final RingBuffer<String> buffer = new RingBuffer<>(1);

        assertTrue(buffer.isEmpty());
        assertNull(buffer.poll());
    }

}
