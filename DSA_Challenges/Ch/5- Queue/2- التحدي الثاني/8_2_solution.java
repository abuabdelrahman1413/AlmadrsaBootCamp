import java.util.*;

/*
 * Implement Stack and Queue using ArrayDeque Deque interface functions only.
 * ArrayDeque extends Deque which extends Queue interface. It has methods for both
 * Queue & Deque.
 * 
 * Your goal is to create Custom Queue And Stack class (StackAndQueue) using only Deque methods.
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
class StackAndQueue {
    Deque<Integer> data;
    int dataSize;

    public StackAndQueue() {
        data = new ArrayDeque<Integer>();
        dataSize = 0;
    }

    /**
     * Returns the number of elements in the Collection
     * @return the number of elements in the Collection.
     */
    public int size() {
        return dataSize;
    }

    /**
     * Returns whether the collection has no elements.
     * @return True if the collection has no elements. False otherwise.
     */
    public boolean empty() {
        return dataSize == 0;
    }

    /**
     * Enqueue new element to the Collection.
     * @param val The value to be enqueued to the Collection (Queue behavior).
     */
    public void enqueue(Integer val) {
        data.offerFirst(val);
        dataSize++;
    }

    /**
     * Push new element to the Collection.
     * @param val The value to be pushed to the Collection (Stack behavior)
     */
    public void push(Integer val) {
        data.offerFirst(val);
        dataSize++;
    }

    /**
     * Takes an element out of the collection and return it (Queue behavior).
     * The element returned is the first element added to the collection.
     * Element could have been added using Push or Enqueue.
     * Return null if collection is empty.
     * 
     * @return The value to be dequeued, null if collection is empty.
     */
    public Integer dequeue() {
        Integer res = data.pollLast();
        if (res != null) {
            dataSize--;
        }
        return res;
    }

    /**
     * Takes an element out of the collection and return it (Stack behavior).
     * The element returned is the last element added.
     * Element could have been added using Push or Enqueue.
     * Return NULL if collection is empty.
     * 
     * @return The last element added to the collection.
     */
    public Integer pop() {
        Integer res = data.pollFirst();
        if (res != null) {
            dataSize--;
        }
        return res;
    }

    /**
     * Returns the value at the top of queue if one exists without
     * removing the item from the queue. null if queue is empty.
     * 
     * @return The value at the top of queue if queue is not empty. null otherwise.
     */
    public Integer peekQueue() {
        return data.peekLast();
    }

    /**
     * Returns the value at the top of stack if one exists without
     * removing the item from the stack. null if stack is empty.
     * 
     * @return The value at the top of stack if stack is not empty. null otherwise.
     */
    public Integer peekStack() {
        return data.peekFirst();
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        Integer[] inputs = new Integer[]{
            Integer.valueOf(1),
            Integer.valueOf(10),
            Integer.valueOf(7),
            Integer.valueOf(8),
            Integer.valueOf(5),
            Integer.valueOf(9),
            Integer.valueOf(3),
            Integer.valueOf(4),
        };

        System.out.println("Queue Only");
        checkQueue(inputs);
        System.out.println("Stack Only");
        checkStack(inputs);
        System.out.println("Hybrid collection (Stack & Queue)");
        checkHybrid(inputs);  
    }

    private static void checkQueue(Integer[] expected) {
        StackAndQueue queue = new StackAndQueue();
        System.out.println("Check Initial Queue status");
        assertSize(0, queue);

        System.out.println("Enqueue Part1");
        int len = expected.length;
        for(int i = 0; i < len/2; i++) {
            System.out.printf("Enqueue item %d\n", expected[i].intValue());
            queue.enqueue(expected[i]);
            assertSize(i + 1, queue);
            assertVal(expected[0], queue.peekQueue(), "peekQueue");
        }
        System.out.println();

        System.out.println("Dequeue Part1");
        for(int i = 0; i < len/2; i++) {
            assertVal(expected[i], queue.peekQueue(), "peekQueue");
            assertVal(expected[i], queue.dequeue(), "dequeue");
            assertSize(len / 2 - i - 1, queue);
        }
        System.out.println();

        System.out.println("Enqueue Part2");
        for(int i = len / 2; i < len; i++) {
            System.out.printf("Enqueue item %d\n", expected[i].intValue());
            queue.enqueue(expected[i]);
            assertSize(i + 1 - len / 2, queue);
            assertVal(expected[len / 2], queue.peekQueue(), "peekQueue");
        }
        System.out.println();

        System.out.println("Dequeue Part2");
        for(int i = len / 2; i < len; i++) {
            assertVal(expected[i], queue.peekQueue(), "peekQueue");
            assertVal(expected[i], queue.dequeue(), "dequeue");
            assertSize(len - i - 1, queue);
        }
        System.out.println();

        System.out.println("One extra dequeue shoudn't decrease size below zero");
        queue.dequeue();
        assertSize(0, queue);
        System.out.println();
    }

    private static void checkStack(Integer[] expected) {
        StackAndQueue stack = new StackAndQueue();
        System.out.println("Check Initial Collection status");
        assertSize(0, stack);

        System.out.println("Push Part1");
        int len = expected.length;
        for(int i = 0; i < len/2; i++) {
            System.out.printf("Push item %d\n", expected[i].intValue());
            stack.push(expected[i]);
            assertSize(i + 1, stack);
            assertVal(expected[i], stack.peekStack(), "peekStack");
        }
        System.out.println();

        System.out.println("Pop Part1");
        for(int i = len / 2 - 1; i >= 0; i--) {
            assertVal(expected[i], stack.peekStack(), "peekStack");
            assertVal(expected[i], stack.pop(), "pop");
            assertSize(i, stack);
        }
        System.out.println();

        System.out.println("Push Part2");
        for(int i = len / 2; i < len; i++) {
            System.out.printf("Push item %d\n", expected[i].intValue());
            stack.push(expected[i]);
            assertSize(i + 1 - len / 2, stack);
            assertVal(expected[i], stack.peekStack(), "peekStack");
        }
        System.out.println();

        System.out.println("Pop Part2");
        for(int i = len - 1; i >= len/ 2; i--) {
            assertVal(expected[i], stack.peekStack(), "peekStack");
            assertVal(expected[i], stack.pop(), "pop");
            assertSize(i - len / 2, stack);
        }
        System.out.println();
    }

    private static void checkHybrid(Integer[] expected) {
        StackAndQueue collection = new StackAndQueue();

        System.out.println("Enqueue Part1");
        int len = expected.length;
        for(int i = 0; i < len/2; i++) {
            System.out.printf("Enqueue item %d\n", expected[i].intValue());
            collection.enqueue(expected[i]);
            assertSize(i + 1, collection);
            assertVal(expected[0], collection.peekQueue(), "peekQueue");
        }
        System.out.println();

        System.out.println("Pop Part1");
        for(int i = len / 2 - 1; i >= 0; i--) {
            assertVal(expected[i], collection.peekStack(), "peekStack");
            assertVal(expected[i], collection.pop(), "pop");
            assertSize(i, collection);
        }
        System.out.println();

        System.out.println("Push Part2");
        for(int i = len / 2; i < len; i++) {
            System.out.printf("Push item %d\n", expected[i].intValue());
            collection.push(expected[i]);
            assertSize(i + 1 - len / 2, collection);
            assertVal(expected[i], collection.peekStack(), "peekStack");
        }
        System.out.println();

        System.out.println("Dequeue Part2");
        for(int i = len / 2; i < len; i++) {
            assertVal(expected[i], collection.peekQueue(), "peekQueue");
            assertVal(expected[i], collection.dequeue(), "dequeue");
            assertSize(len - i - 1, collection);
        }
        System.out.println();

    }
    
    public static void assertSize(int expected, StackAndQueue collection) {
        if (collection.size() == expected) {
            System.out.println("PASS! Collection size check");
        } else {
            System.out.printf("FAIL! Collection size check. Expected %d, Actual %d \n",
                expected, collection.size());
        }
    }

    public static void assertVal(Integer expected, Integer actual, String operation) {
        if (expected.equals(actual)) {
            System.out.printf("PASS! Collection %s check \n", operation);
        } else {
            System.out.printf("FAIL! Collection %s check. Expected: %d, Actual %d \n",
                operation, expected.intValue(), actual.intValue());
        }
    }
}
