import java.util.*;

/*
 * Reverse an array in place
 * 
 * Given an array A of size N, reverse the array in place.
 * You must change the original array. Do not create a new array
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 4
 * A[] = {1, 2, 3, 4}
 * Output:
 * A[] will be changed to{4, 3, 2, 1}
 * 
 * This is a variation of the problem
 * https://practice.geeksforgeeks.org/problems/reverse-an-array/0
 */

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        int[][] inputs = {
            {3,4,5,6,7},
            {1,2,3,4},
            {1},
            {1,10},
            {}
        };
        int[][] expected = {
            {7,6,5,4,3},
            {4,3,2,1},
            {1},
            {10,1},
            {}
        };
        for(int i = 0; i < inputs.length; i++) {
            int[] actual = inputs[i];
            reverseArray(actual);
            if (Arrays.equals(actual, expected[i])) {
                System.out.printf("Test case %d passed! \n", i + 1);
            } else {
                System.out.printf("Test case %d failed! ", i + 1);
                System.out.printf("Expected result %s, actual result %s \n",
                    Arrays.toString(expected[i]), Arrays.toString(actual));
            }
            System.out.println();
        }
    }

    // Array length = len
    // Swap == change two elements with one another
    // Swap a[0] with a[len - 1]
    // Swap a[1] with a[len - 1 - 1] ==> a[len - 2]
    // Swap a[2] with a[len - 1 - 2] ==> a[len - 3]
    //
    // Loop only till half the array length, because we change
    // the value of two elements in one iteration
    // (one from first half & one from second half)
    private static void reverseArray(int a[]) {
        int len = a.length;
        // If len is odd (e.g. 5) i loops from 0 - 1
        // We don't need to add 2 as the element in the middle
        // swaps with itself and becomes the same element
        // Example
        // Input =    1, 2, 3, 4, 5
        // Output =   5, 4, 3, 2, 1
        // Middle =>        ^
        for(int i = 0; i < (len / 2); i++) {
            int temp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;
        }
    }
}
