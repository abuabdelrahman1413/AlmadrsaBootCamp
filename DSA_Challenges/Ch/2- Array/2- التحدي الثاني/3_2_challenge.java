import java.util.*;

/*
 * Reverse an array
 * 
 * Given an array A of size N, return a new reversed array.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 4
 * A[] = {1, 2, 3, 4}
 * Output:
 * {4, 3, 2, 1}
 * 
 * Original problem
 * https://practice.geeksforgeeks.org/problems/reverse-an-array/0
 */

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        int[][] inputs = {
            {1,2,3,4},
            {1},
            {1,10},
            {}
        };
        int[][] expected = {
            {4,3,2,1},
            {1},
            {10,1},
            {}
        };
        for(int i = 0; i < inputs.length; i++) {
            int[] actual = reverseArray(inputs[i]);
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

    private static int[] reverseArray(int a[]) {
        // Write your code here
        int len = a.length;
        int[] res = new int[len];
        for(int i =0; i < len; i++) {
            res[i] = a[len - 1 - i];
        }
        return res;
    }
}
