import java.util.*;

/*
 * Impelement Two stacks using a SINGLE array to store the values.
 * The array can have a maximum size of N and doesn't grow beyond N.
 * 
 * All of the stack operations must be O(1)
 * 
 * Assume Data Type is Integer.
 * 
 * This problem is derived from
 * https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
// We can cut the array in half. so one stack starts from index 0
// The other stack starts from index N / 2
class TwoStacks {
    Integer[] stacksStore;
    // We just need to track the current index of every stack.
    // The index points to the next empty space.
    int head1;
    int head2;
    int start2;
    /**
     * Initializer for the stacks (DO NOT CHANGE)
     * @param capacity The size of the array holding the stacks
     */
    public TwoStacks(int capacity) {
        stacksStore = new Integer[capacity];
        head1 = 0;
        head2 = capacity / 2;
        start2 = head2;
    }

    /**
     * Calculates the number of elements that exist in the first stack so far.
     *
     * @return The number of elements existing in the first stack.
     */
    public int size1() {
        return head1;
    }

    /**
     * Calculates the number of elements that exist in the second stack so far.
     *
     * @return The number of elements existing in the second stack.
     */
    public int size2() {
        return head2 - start2;
    }

    /**
     * Returns whether the first stack has no values.
     * @return True if the first stack has no elements.
     *  False otherwise.
     */
    public boolean empty1() {
        return head1 == 0;
    }

    /**
     * Returns whether the second stack has no values.
     * @return True if the second stack has no elements.
     *  False otherwise.
     */
    public boolean empty2() {
        return head2 == start2;
    }

    /**
     * Takes a value out of top of the first stack and returns it.
     * The value is removed from stack after this method is called.
     * 
     * @return The value at the top ofthe first stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer pop1() throws EmptyStackException {
        if (head1 == 0) {
            throw new EmptyStackException();
        }
        return stacksStore[--head1];
    }

    /**
     * Takes a value out of top of the second stack and returns it.
     * The value is removed from stack after this method is called.
     * 
     * @return The value at the top of the second stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer pop2() throws EmptyStackException {
        if (head2 == start2) {
            throw new EmptyStackException();
        }
        return stacksStore[--head2];
    }

    /**
     * Adds a new value to the top of the first stack
     * 
     * @param value The new value to add to the stack.
     */
    public void push1(Integer value) {
        if (head1 < start2) {
            stacksStore[head1++] = value;
        }

    }

    /**
     * Adds a new value to the top of the second stack
     * 
     * @param value The new value to add to the stack.
     */
    public void push2(Integer value) {
        if (head2 < stacksStore.length) {
            stacksStore[head2++] = value;
        }
    }

    /**
     * Returns the value at the top of the first stack if one exists
     * without removing the item from stack.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer peek1() throws EmptyStackException {
        if (head1 == 0) {
            throw new EmptyStackException();
        }
        return stacksStore[head1 - 1];
    }

    /**
     * Returns the value at the top of the second stack if one exists
     * without removing the item from stack.
     * 
     * @return The value at the top of stack.
     * @throws EmptyStackException If the stack is empty.
     */
    public Integer peek2() throws EmptyStackException {
        if (head2 == start2) {
            throw new EmptyStackException();
        }
        return stacksStore[head2 - 1];
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        checkStacks(new Integer[]{
            Integer.valueOf(20),
            Integer.valueOf(17),
            Integer.valueOf(42),
            Integer.valueOf(12),
            Integer.valueOf(35),
            Integer.valueOf(7)
        }, new Integer[] {
            Integer.valueOf(10),
            Integer.valueOf(8),
            Integer.valueOf(5),
        });
    }

    private static void checkStacks(Integer[] stack1, Integer[] stack2) {
        TwoStacks stack = new TwoStacks(100);
        assertBool(true, stack.empty1(), "empty1");
        assertBool(true, stack.empty2(), "empty2");
        System.out.println();

        int len1 = stack1.length;
        int len2 = stack2.length;
        System.out.println("Stack1 Add Part1");
        for(int i = 0; i < len1 / 2; i++) {
            System.out.printf("Add item %d\n", stack1[i].intValue());
            stack.push1(stack1[i]);
            assertSize(i + 1, 0, stack);
            assertVal(stack1[i], stack.peek1(), "peek1");
            assertBool(false, stack.empty1(), "empty1");
            assertBool(true, stack.empty2(), "empty2");
        }
        System.out.println();

        System.out.println("Stack2 Add Part1");
        for(int i = 0; i < len2 / 2; i++) {
            System.out.printf("Add item %d\n", stack2[i].intValue());
            stack.push2(stack2[i]);
            assertSize(len1/2, i + 1, stack);
            assertVal(stack2[i], stack.peek2(), "peek2");
            assertBool(false, stack.empty1(), "empty1");
            assertBool(false, stack.empty2(), "empty2");
        }
        System.out.println();

        System.out.println("Stack1 Add Part2");
        for(int i = len1 / 2; i < len1; i++) {
            System.out.printf("Add item %d\n", stack1[i].intValue());
            stack.push1(stack1[i]);
            assertSize(i + 1, len2 / 2, stack);
            assertVal(stack1[i], stack.peek1(), "peek1");
            assertBool(false, stack.empty1(), "empty1");
            assertBool(false, stack.empty2(), "empty2");
        }
        System.out.println();

        System.out.println("Stack2 Add Part2");
        for(int i = len2 / 2; i < len2; i++) {
            System.out.printf("Add item %d\n", stack2[i].intValue());
            stack.push2(stack2[i]);
            assertSize(len1, i + 1, stack);
            assertVal(stack2[i], stack.peek2(), "peek2");
            assertBool(false, stack.empty1(), "empty1");
            assertBool(false, stack.empty2(), "empty2");
        }
        System.out.println();

        System.out.println("Removing from Stack1");
        for(int i =len1 - 1; i >= 0; i--) {
            assertVal(stack1[i], stack.pop1(), "pop1");
            assertSize(i, len2, stack);
        }
        assertBool(true, stack.empty1(), "empty1");
        assertBool(false, stack.empty2(), "empty2");
        System.out.println();

        System.out.println("Removing from Stack2");
        for(int i =len2 - 1; i >= 0; i--) {
            assertVal(stack2[i], stack.pop2(), "pop2");
            assertSize(0, i, stack);
        }
        assertBool(true, stack.empty1(), "empty1");
        assertBool(true, stack.empty2(), "empty2");
    }

    public static void assertSize(int expected1, int expected2, TwoStacks stack) {
        if (stack.size1() == expected1) {
            System.out.println("PASS! Stack size1 check");
        } else {
            System.out.printf("FAIL! Stack size1 check. Expected %d, Actual %d \n",
                expected1, stack.size1());
        }

        if (stack.size2() == expected2) {
            System.out.println("PASS! Stack size2 check");
        } else {
            System.out.printf("FAIL! Stack size2 check. Expected %d, Actual %d \n",
                expected2, stack.size2());
        }
    }

    public static void assertBool(boolean expected, boolean actual, String operation) {
        if (expected == actual) {
            System.out.printf("PASS! Stack %s check\n", operation);
        } else {
            System.out.printf("FAIL! Stack %s check. Expected: %b, Actual %b \n",
                operation, expected, actual);
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
