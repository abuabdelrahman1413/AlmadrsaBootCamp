import java.util.*;

/*
 * Implement a Custom Stack class using ArrayList.
 * Assume Data Type is Integer.
 * 
 * All Operations much be O(1) Except for search. search is O(n).
 */
class MyStack {
    ArrayList<Integer> data;
    public MyStack() {
        data = new ArrayList<Integer>();
    }

    /**
     * Calculates the number of elements that exist in the stack so far.
     *
     * @return The number of elements existing in the stack.
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns whether the stack has no values.
     * @return True if the stack has no elements. False otherwise.
     */
    public boolean empty() {
        return data.isEmpty();
    }

    /**
     * Takes a value out of top of Stack and returns it.
     * The value is removed from stack after this method is called.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer pop() throws EmptyStackException {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }

    /**
     * Adds a new value to the top of stack
     * 
     * @param value The new value to add to the stack.
     */
    public void push(Integer value) {
        data.add(value);
    }

    /**
     * Returns the value at the top of stack if one exists without
     * removing the item from stack.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer peek() throws EmptyStackException {
        if(data.isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    /**
     * Search for an item in the stack and return its 1-based index.
     * The index represents how many pops need to happen in order to
     * get that item from the stack.
     * 
     * If more than one occurence of the same object exist in the stack,
     * return the distance to the closest one.
     * 
     * Return -1 if the item doesn't exist in the stack.
     * 
     * Example:
     * If the item is at the top of stack, return 1
     * If the item is at the bottom of stack, return stack size.
     * @param obj
     * @return
     */
    public int search(Integer obj) {
        int rank = 1;
        for(int i = data.size() - 1; i >= 0; i--) {
            if (data.get(i) == obj) {
                break;
            }
            rank++;
        } 
        // Implement this method.
        return rank == data.size() + 1 ? -1 : rank;
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        checkStack(new Integer[]{
            Integer.valueOf(1),
            Integer.valueOf(3),
            Integer.valueOf(4),
            Integer.valueOf(5)
        });  
    }

    private static void checkStack(Integer[] expected) {
        MyStack stack = new MyStack();
        System.out.println("Adding items to stack");
        int len = expected.length;
        for(int i = 0; i < len; i++) {
            System.out.printf("Add item %d\n", expected[i].intValue());
            stack.push(expected[i]);
            assertSize(i + 1, stack);
            assertVal(expected[i], stack.peek(), "peek");
        }
        System.out.println();

        System.out.println("Searching for items in stack");
        for(int i = 0; i < len; i++) {
            assertSearch(len - i, stack.search(expected[i]));
        }
        assertSearch(-1, stack.search(Integer.valueOf(10000)));
        System.out.println();

        System.out.println("Removing items from stack");
        for(int i =len - 1; i >= 0; i--) {
            assertVal(expected[i], stack.pop(), "pop");
            assertSize(i, stack);
        }
    }

    public static void assertSearch(int expected, int actual) {
        if (expected == actual) {
            System.out.println("PASS! Stack search check");
        } else {
            System.out.printf("FAIL! Stack search check. Expected %d, Actual %d \n",
                expected, actual);
        }
    }

    public static void assertSize(int expected, MyStack stack) {
        if (stack.size() == expected) {
            System.out.println("PASS! Stack size check");
        } else {
            System.out.printf("FAIL! Stack size check. Expected %d, Actual %d \n",
                expected, stack.size());
        }
    }

    public static void assertVal(Integer expected, Integer actual, String operation) {
        if (expected.equals(actual)) {
            System.out.printf("PASS! Stack %s check \n", operation);
        } else {
            System.out.printf("FAIL! Stack %s check. Expected: %d, Actual %d \n",
                operation, expected.intValue(), actual.intValue());
        }
    }
}
