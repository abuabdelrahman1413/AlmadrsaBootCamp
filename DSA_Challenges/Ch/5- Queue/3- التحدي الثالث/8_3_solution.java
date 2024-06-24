import java.util.Stack;

/*
 * Implement Queue using Stack class.
 * 
 * Your goal is to create Custom Queue (QueueUsingStacks). It implements a queue behavior
 * using ONE OR MORE stack objects. You can create as many Stack objects internally as you need.
 * 
 * You can ONLY use any of the following methods from Stack class
 * empty => Check if stack is empty
 * peek => Gets the element at the top of the stack
 * push => Add element to the stack
 * pop => Remove element from stack with LIFO behavior (Last In First Out)
 * size => gets the Stack size
 * isEmpty => Checks whether stack is empty.
 * 
 * DO NOT USE any other methods to implement this class and Do not use Dequeue objects.
 * 
 * You can find Stack Java class definition here:
 * https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html
 * 
 * All Operations much has AMORTIZED Time Complexity O(1).
 * 
 * TIP: This is a tricky problem. You need to focus on the difference between
 * FIFO (Queue) and LIFO (Stack) so that elements exit the Queue in the correct order.
 */
class QueueUsingStacks {
    /*
     * The idea is to create two stacks, one for inserting values (Enqueue)
     * Once we need to dequeue and the second stack is empty, we pop all values
     * from Stack 1 into Stack 2. This reverses the order of values and the pop from second stack
     * will be in the same order of the queue.
     */

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<Integer>();
        dequeueStack = new Stack<Integer>();
    }

    /**
     * Returns the number of elements in the Collection
     * @return the number of elements in the Collection.
     */
    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    /**
     * Returns whether the collection has no elements.
     * @return True if the collection has no elements. False otherwise.
     */
    public boolean empty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    /**
     * Adds new element to the Queue.
     * @param val The value to be added to the Queue.
     */
    public void enqueue(Integer val) {
        enqueueStack.push(val);
    }

    /**
     * Dequeues a value from the queue. The value is taken out of the queue.
     * Return NULL if queue is empty.
     * 
     * @return The value to be dequeued, null if queue is empty.
     */
    public Integer dequeue() {
        if (this.empty()) {
            return null;
        }
        if (dequeueStack.isEmpty()) {
            while(!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    /**
     * Returns the value at the top of queue if one exists without
     * removing the item from the queue. null if queue is empty.
     * 
     * @return The value at the top of queue if queue is not empty. null otherwise.
     */
    public Integer peek() {
        if (this.empty()) {
            return null;
        }
        if (dequeueStack.isEmpty()) {
            while(!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
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
        QueueUsingStacks queue = new QueueUsingStacks();
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

    public static void assertSize(int expected, QueueUsingStacks queue) {
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