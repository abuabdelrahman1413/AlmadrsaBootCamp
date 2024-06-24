import java.util.*;

/*
 * Cyclically rotate an array by 1 in-place
 * 
 * Given an array, rotate the array by one position in clock-wise direction.
 * Do the operation in-place (Do not create a new array)
 * 
 * Example 1:
 * Input:
 * A[] = {1, 2, 3, 4, 5}
 * Output: 
 * A[] will be {5, 1, 2, 3, 4}
 * 
 * Example 2:
 * Input:
 * A[] = {9, 8, 7, 6, 4, 2, 1, 3}
 * Output:
 * A[] will be {3, 9, 8, 7, 6, 4, 2, 1}
 * 
 * This is a variation of the original problem
 * https://practice.geeksforgeeks.org/problems/find-the-frequency/1
 */

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        int[][] inputs = {
            {1, 2, 3, 4, 5},
            {9, 8, 7, 6, 4, 2, 1, 3},
            {1,3},
            {1},
            {}
        };
        int[][] expected = {
            {5, 1, 2, 3, 4},
            {3, 9, 8, 7, 6, 4, 2, 1},
            {3, 1},
            {1},
            {}
        };
        for(int i = 0; i < inputs.length; i++) {
            int[] actual = inputs[i];
            rotate(actual);
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

    // Keep a[len - 1] in a variable K
    // a[0] ==> a[1]
    // a[1] ==> a[2]
    // ....
    // a[len - 2] ==> a[len - 1]
    // a[0] = K
    // 
    // To simplify the problem, you need to move the elements from end to beginning
    // a[len - 2] ==> a[len - 1]
    // a[len - 3] ==> a[len - 2]
    // ...
    // a[0] ==> a[1]
    // Then put a[0] = K
    private static void rotate(int a[]) {
        int len = a.length;
        if (len < 2) {
            return;
        }

        int last = a[len - 1];
        for(int i = len - 2; i >= 0; i--) {
            a[i + 1] = a[i];
        }
        a[0] = last;
    }
}
