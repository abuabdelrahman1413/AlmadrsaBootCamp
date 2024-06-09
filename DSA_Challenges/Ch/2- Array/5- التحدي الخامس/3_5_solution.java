import java.util.*;

/*
 * Cyclically rotate an array by 1
 * 
 * Given an array, rotate the array by one position in clock-wise direction.
 * 
 * Example 1:
 * Input:
 * A[] = {1, 2, 3, 4, 5}
 * Output: 
 * {5, 1, 2, 3, 4}
 * 
 * Example 2:
 * Input:
 * A[] = {9, 8, 7, 6, 4, 2, 1, 3}
 * Output:
 * {3, 9, 8, 7, 6, 4, 2, 1}
 * 
 * Original problem
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
            int[] actual = rotate(inputs[i]);
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

    // Take last element in a temp variable
    // Move all elements from 0 to len - 2 by 1 place to the right
    // a[0] ==> res[1]
    // a[1] ==> res[2]
    // a[len - 2] ==> res[len - 1]
    // a[len - 1] ==> res[0]
    private static int[] rotate(int a[]) {
        int len = a.length;
        int[] res = new int[len];
        for(int i = 0; i < len-1; i++) {
            res[i + 1] = a[i];
        }

        if (len > 0) {
            res[0] = a[len - 1];   
        }
        return res;
    }
}
