import java.util.*;

/*
 * Impelement a Data Structure SpecialStack that supports all the stack
 * operations: size(), push(), pop(), empty(), peek() and an additional
 * operation getMin() which should return minimum element from the
 * SpecialStack.
 * 
 * Please note that the minimum element changes as you add or remove items
 * to/from the stack.
 * 
 * All these operations of SpecialStack must be O(1).
 * 
 * To implement SpecialStack, you should only use standard Stack data
 * structure and no other data structure like arrays, list, . etc. 
 * 
 * Assume Data Type is Integer.
 * 
 * This problem is derived from
 * https://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/
 */
class SpecialStack {
    // The idea here is to have a parallel stack that tracks the min value with every element
    // added to the stack.
    // so when we pop an element out of the stack we pop the corresponding min equivalent as well
    // This way we maintain parity between the original values entering the stack and the min value
    // at each given value.
    private Stack<Integer> data;
    private Stack<Integer> minData;
    public SpecialStack() {
        data = new Stack<Integer>();
        minData = new Stack<Integer>();
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
        // Popping element from one stack needs popping the equivalent
        // min from the other stack.
        minData.pop();
        return data.pop();
    }

    /**
     * Adds a new value to the top of stack
     * 
     * @param value The new value to add to the stack.
     */
    public void push(Integer value) {
        Integer minValue = empty() ? value : Math.min(value, minData.peek());
        data.push(value);
        minData.push(minValue);
    }

    /**
     * Returns the value at the top of stack if one exists without
     * removing the item from stack.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer peek() throws EmptyStackException {
        return data.peek();
    }
    

    /**
     * Returns the item with the minimum value in the stack.
     * 
     * @returns The item with minimum value in the stack.
     * @throws EmptyStackException if stack is empty
     */
    public Integer getMin() throws EmptyStackException {
        return minData.peek();
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        checkStack(new Integer[]{
            Integer.valueOf(20),
            Integer.valueOf(17),
            Integer.valueOf(42),
            Integer.valueOf(12),
            Integer.valueOf(35),
            Integer.valueOf(7)
        }, new Integer[] {
            Integer.valueOf(20),
            Integer.valueOf(17),
            Integer.valueOf(17),
            Integer.valueOf(12),
            Integer.valueOf(12),
            Integer.valueOf(7),
        });
    }

    private static void checkStack(Integer[] expected, Integer[] expectedMins) {
        SpecialStack stack = new SpecialStack();
        System.out.println("Adding items to stack");
        int len = expected.length;
        for(int i = 0; i < len; i++) {
            System.out.printf("Add item %d\n", expected[i].intValue());
            stack.push(expected[i]);
            assertSize(i + 1, stack);
            assertVal(expected[i], stack.peek(), "peek");
        }
        System.out.println();

        System.out.println("Removing & calculating Min items from stack");
        for(int i =len - 1; i >= 0; i--) {
            assertVal(expectedMins[i], stack.getMin(), "getMin");
            assertVal(expected[i], stack.pop(), "pop");
            assertSize(i, stack);
        }
    }

    public static void assertSize(int expected, SpecialStack stack) {
        if (stack.size() == expected) {
            System.out.println("PASS! Stack size check");
        } else {
            System.out.printf("FAIL! Stack size check. Expected %d, Actual %d \n",
                expected, stack.size());
        }
    }

    public static void assertVal(Integer expected, Integer actual, String operation) {
        if (expected.equals(actual)) {
            System.out.printf("PASS! Stack %s check\n", operation);
        } else {
            System.out.printf("FAIL! Stack %s check. Expected: %d, Actual %d \n",
                operation, expected.intValue(), actual.intValue());
        }
    }
}
