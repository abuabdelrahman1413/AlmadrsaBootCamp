import java.util.Arrays;

/*
 * ArrayList java class doesn't accept primitive int
 * 
 * Create a custom ArrayList of primitive int
 * The array list methods are defined in this file.
 * 
 * Your goal is to implement these methods so that they can be used as
 * an ArrayList.
 * 
 * You need to check for edge cases (e.g. removing value from empty list)
 * and handle copying the array to increase array size.
 * 
 * Initialize the ArrayList with length "2" only when the first element is added
 * When adding a new element and the array is full, double the array size.
 * 
 * Original ArrayList Interface for reference:
 * https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * 
 * 
 * Bonus 1:
 * Create two additional constructors
 * One accepts initial size. In this case you initialize with
 * this size instead of default. The call will look like this:
 * 
 * MyArrayList newList = new MyArrayList(10);
 * 
 * Another constructor accepts an initial array of int[]
 * int[] someValues = {1,2,3,4,5};
 * MyArrayList newList = new MyArrayList(someValues);
 * 
 * Note: You can add as many constructors as you need to the same class
 * as long as each constructor signature is different
 * (i.e. Each constructor takes different types of arguments)
 * 
 * Bonus 2:
 * Implement Copy function, which returns a COPY of the ArrayList
 * into a new ArrayList.
 */

// Fill this class implementation to make it work
// You can define any private members to store any values you need.
// You are expected to define at least 2 members
// One for data (as an int[])
// One for size (as an int)
class MyArrayList {
    int[] data;
    int _size;
    public MyArrayList() {
        data = new int[0];
        _size = 0;
    }

    public MyArrayList(int capacity) {
        data = new int[capacity >= 0 ? capacity : 0];
        _size = 0;
    }

    public MyArrayList(int[] arr) {
        data = arr.clone();
    }

    /**
     * Gives back the actual length of the array storing values.
     * Capacity is larger than or equal to size at any point of time.
     * 
     * @return The length of the underlying array.
     */
    public int capacity() {
        return data.length;
    }

    /**
     * Gives back the current size of the array list.
     * This is the number of elements added to the array list so far.
     * 
     * This value is usually less than Capacity. It equals Capacity if
     * the array list is full.
     * 
     * @return The current size of the array list.
     */
    public int size() {
        return _size;
    }

    /**
     * Returns the value at given index.
     * 
     * @param index The position of the element to return (0 based)
     * @return The value of the element at the given position.
     * @throws IndexOutOfBoundsException If the given index is out of
     * valid range of values of the array list.
     */
    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    /**
     * Change the value at given index.
     * 
     * @param index The position of the element to set (0 based)
     * @param value The new value to change the element to.
     * @throws IndexOutOfBoundsException if index is not within array list
     * valid range of values.
     */
    public void set(int index, int value) throws IndexOutOfBoundsException {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    private void checkSpace() {
        if (_size < data.length) {
            return;
        }
        int newSpace = data.length == 0 ? 1 : data.length * 2;
        int[] newArr = new int[newSpace];
        for(int i = 0; i < data.length; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    /**
     * Adds value to the end of Array List.
     * 
     * Example:
     * If original array list has elements {1, 2, 3, 4}
     * add(100) will result in array list {1, 2, 3, 4, 100}
     * 
     * @param value The value to add to the array list.
     */
    public void add(int value) {
        checkSpace();
        data[_size++] = value;
    }

    /**
     * Inserts value to the given index in the array list.
     * Shifts all subsequent elements by 1 place to the right
     * Example:
     * If original list has elements {1, 2, 3, 4}
     * add(2, 100) will result in list {1, 2, 100, 3, 4}
     * 
     * @param index The position of the element to add (0 based)
     * @param value The new value to add to array list
     */
    public void add(int index, int value) {
        checkSpace();
        for(int i= _size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        _size++;
    }

    /**
     * Removes the last element in Array List.
     * Decreases the array list size by 1
     * 
     * @return The element that was removed from array list
     * @throws IndexOutOfBoundsException if array list is empty.
     */
    public int remove() throws IndexOutOfBoundsException {
        if (_size == 0) {
            throw new IndexOutOfBoundsException();
        }
        _size--;
        return data[_size];
    }

    /**
     * Removes the element at a given index from array list.
     * 
     * @param index Index of the given element to remove (0 based)
     * @return The element that was removed from the array list.
     * @throws IndexOutOfBoundsException If array list is empty.
     */
    public int remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= _size) {
            throw new IndexOutOfBoundsException();
        }
        int res = data[index];
        for(int i = index; i < _size - 1; i++) {
            data[i] = data[i + 1];
        }
        _size--;
        return res;
    }

    /**
     * Removes all elements from the array list.
     * Size should be 0 after the array list is cleared.
     */
    public void clear() {
        for(int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
        _size = 0;
    }

    public MyArrayList copy() {
        MyArrayList res = new MyArrayList(_size);
        for(int i = 0; i < res.size(); i++) {
            res.add(data[i]);
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        MyArrayList arrList = new MyArrayList();
        checkStats(0, 0, arrList);

        System.out.print("Check removing from empty array list: ");
        try {
            arrList.remove();
            System.out.println("Fail! Didn't throw exception");
        } catch(IndexOutOfBoundsException ex) {
            System.out.println("Pass: Exception thrown");
        }
        System.out.println();

        System.out.println("Add fist element to array list");
        arrList.add(10);
        checkStats(1, 1, arrList);

        System.out.println("Add element to array list");
        arrList.add(5);
        checkStats(2, 2, arrList);

        System.out.println("Add element to array list");
        arrList.add(20);
        checkStats(3, 4, arrList);

        System.out.println("Add element to array list");
        arrList.add(0, 30);
        checkStats(4, 4, arrList);

        System.out.println("Add element to array list");
        arrList.add(1, 12);
        checkStats(5, 8, arrList);

        System.out.println("Check current array state");
        checkArray(getArrayFromArrayList(arrList), new int[]{30, 12, 10, 5, 20});

        System.out.println("Remove elements from array list");
        check(arrList.remove(3), 5, "Check Remvoing element 3");
        checkStats(4, 8, arrList);
        checkArray(getArrayFromArrayList(arrList), new int[]{30, 12, 10, 20});
        check(arrList.remove(), 20, "Check removing last element");
        checkStats(3, 8, arrList);
        checkArray(getArrayFromArrayList(arrList), new int[]{30, 12, 10});
        check(arrList.remove(0), 30, "Check removing element 0");
        checkStats(2, 8, arrList);
        checkArray(getArrayFromArrayList(arrList), new int[]{12, 10});

        System.out.println("Clear Array List");
        arrList.clear();
        checkStats(0, 8, arrList);
        checkArray(getArrayFromArrayList(arrList), new int[]{});
    }

    private static int[] getArrayFromArrayList(MyArrayList arrList) {
        int[] res = new int[arrList.size()];
        for(int i = 0; i < arrList.size(); i++) {
            res[i] = arrList.get(i);
        }
        return res;
    }

    private static void checkStats(int expectedSize, int expectedCapacity, MyArrayList arrList) {
        check(arrList.size(), expectedSize, "Check array list size");
        check(arrList.capacity(), expectedCapacity, "Check array list capacity");
    }

    private static void check(int actual, int expected, String message) {
        System.out.print(message + ": ");
        if (actual == expected) {
            System.out.println("Pass!");
        } else {
            System.out.printf("Failed! Expected %d, Actual %d \n", expected, actual);
        }
        System.out.println();
    }

    private static void checkArray(int[] actual, int[] expected) {
        System.out.print("Check array elements: ");
        if (Arrays.equals(expected, actual)) {
            System.out.println("Pass!");
        } else {
            System.out.printf("Fail! Expected %s, Actual %s \n",
            Arrays.toString(expected), Arrays.toString(actual));
        }
        System.out.println();
    }
}
