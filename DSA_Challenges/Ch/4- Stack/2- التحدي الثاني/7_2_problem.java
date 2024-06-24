import java.util.*;

/*
 * Implement a Data Structure SpecialStack that supports all the stack
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
	Stack<Integer> _Stack;
	Stack<Integer> _MinStack;
	int minValu = Integer.MAX_VALUE;

    public SpecialStack() {
	_Stack = new Stack<Integer>();
	_MinStack = new Stack<Integer>();
    }

    /**
     * Calculates the number of elements that exist in the stack so far.
     *
     * @return The number of elements existing in the stack.
     */
    public int size() {
        // Implement this method.
        return _Stack.size();
    }

    /**
     * Returns whether the stack has no values.
     * @return True if the stack has no elements. False otherwise.
     */
    public boolean empty() {
        // Implement this method
        return _Stack.isEmpty();
    }

    /**
     * Takes a value out of top of Stack and returns it.
     * The value is removed from stack after this method is called.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer pop() throws EmptyStackException {
        
		_MinStack.pop();
        return _Stack.pop();
    }

    /**
     * Adds a new value to the top of stack
     * 
     * @param value The new value to add to the stack.
     */
    public void push(Integer value) {
		if(_MinStack.isEmpty() || value < _MinStack.peek())
		{
			_MinStack.push(value);
		}
		else{
			_MinStack.push(_MinStack.peek());
		}

	_Stack.push(value);
    }

    /**
     * Returns the value at the top of stack if one exists without
     * removing the item from stack.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer peek() throws EmptyStackException {
        return _Stack.peek();
    }
    

    /**
     * Returns the item with the minimum value in the stack.
     * 
     * @returns The item with minimum value in the stack.
     * @throws EmptyStackException if stack is empty
     */
    public Integer getMin() throws EmptyStackException {
        // Implement this method.
	return _MinStack.peek();
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
            assertVal(expected[i], stack.getMin(), "getMin");
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
