import java.util.*;
/*
 * Implement Queue using ArrayDeque Deque interface methods only.
 * ArrayDeque extends Deque which extends Queue interface. It has methods for both
 * Queue & Deque.
 * 
 * Your goal is to create Custom Queue class (MyQueue) using only Deque methods.
 * We can only implement the version that return null (Doesn't throw exceptions) if
 * operation fails.
 * 
 * You can ONLY use any of the following methods from Deque interface
 * offerFirst => Add to the beginning
 * offerLast => Add to the end
 * pollFirst => Remove from the beginning
 * pollLast => Remove from the end
 * peekFirst => Get the first element without removing
 * peekLast => Get the last element without removing
 * 
 * DO NOT USE any other methods to implement this class. You can define any other properties
 * to your own class as you need.
 * 
 * You can find Deque definition here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
 * 
 * All Operations much be O(1).
 */
class MyQueue {
    private ArrayDeque<Integer> data;
    private int dataSize;
    public MyQueue() {
        data = new ArrayDeque<Integer>();
        dataSize = 0;
    }

    /**
     * Returns the number of elements in the Queue
     * @return the number of elements in the Queue.
     */
    public int size() {
        return dataSize;
    }

    /**
     * Returns whether the queue has no elements.
     * @return True if the queue has no elements. False otherwise.
     */
    public boolean empty() {
        return dataSize == 0;
    }

    /**
     * Adds new element to the Queue.
     * @param val The value to be added to the Queue.
     */
    public void enqueue(Integer val) {
        data.offerLast(val);
        dataSize++;
    }

    /**
     * Dequeues a value from the queue. The value is taken out of the queue.
     * Return NULL if queue is empty.
     * 
     * @return The value to be dequeued, null if queue is empty.
     */
    public Integer dequeue() {
        Integer result = data.pollFirst();
        if (result != null) {
            dataSize--;
        }
        return result;
    }

    /**
     * Returns the value at the top of queue if one exists without
     * removing the item from the queue. null if queue is empty.
     * 
     * @return The value at the top of queue if queue is not empty. null otherwise.
     */
    public Integer peek() {
        return data.peekFirst();
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        checkQueue(new Integer[]{
            Integer.valueOf(1),
            Integer.valueOf(10),
            Integer.valueOf(7),
            Integer.valueOf(8),
            Integer.valueOf(5),
            Integer.valueOf(9),
            Integer.valueOf(3),
            Integer.valueOf(4),
        });  
    }

    private static void checkQueue(Integer[] expected) {
        MyQueue queue = new MyQueue();
        System.out.println("Check Initial Queue status");
        assertSize(0, queue);

        System.out.println("Enqueue Part1");
        int len = expected.length;
        for(int i = 0; i < len/2; i++) {
            System.out.printf("Enqueue item %d\n", expected[i].intValue());
            queue.enqueue(expected[i]);
            assertSize(i + 1, queue);
            assertVal(expected[0], queue.peek(), "peek");
        }
        System.out.println();

        System.out.println("Dequeue Part1");
        for(int i = 0; i < len/2; i++) {
            assertVal(expected[i], queue.peek(), "peek");
            assertVal(expected[i], queue.dequeue(), "dequeue");
            assertSize(len / 2 - i - 1, queue);
        }

        System.out.println("Enqueue Part2");
        for(int i = len / 2; i < len; i++) {
            System.out.printf("Enqueue item %d\n", expected[i].intValue());
            queue.enqueue(expected[i]);
            assertSize(i + 1 - len / 2, queue);
            assertVal(expected[len / 2], queue.peek(), "peek");
        }
        System.out.println();

        System.out.println("Dequeue Part2");
        for(int i = len / 2; i < len; i++) {
            assertVal(expected[i], queue.peek(), "peek");
            assertVal(expected[i], queue.dequeue(), "dequeue");
            assertSize(len - i - 1, queue);
        }

        System.out.println("One extra dequeue shoudn't decrease size below zero");
        queue.dequeue();
        assertSize(0, queue);
        System.out.println();
    }

    public static void assertSize(int expected, MyQueue queue) {
        if (queue.size() == expected) {
            System.out.println("PASS! Queue size check");
        } else {
            System.out.printf("FAIL! Queue size check. Expected %d, Actual %d \n",
                expected, queue.size());
        }
    }

    public static void assertVal(Integer expected, Integer actual, String operation) {
        if (expected.equals(actual)) {
            System.out.printf("PASS! Queue %s check \n", operation);
        } else {
            System.out.printf("FAIL! Queue %s check. Expected: %d, Actual %d \n",
                operation, expected.intValue(), actual.intValue());
        }
    }
}
