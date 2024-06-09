/*
 * Missing number in array
 * 
 * Given an array of size N-1 such that it only contains
 * distinct integers in the range of 1 to N.
 * Find the missing element.
 * 
 * 
 * Example 1:
 * Input:
 * N = 5
 * A[] = {1, 2, 3, 5}
 * Output:
 * 4
 * 
 * Example 2:
 * Input:
 * N = 10
 * A[] = {6,1,2,8,3,4,7,10,5}
 * Output:
 * 9
 * 
 * 1 <= A[i] <= 10^6
 * 
 * Original problem
 * https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1
 */

class Main{
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        int[][] inputs = {
            {1, 2, 3, 5},
            {6,1,2,8,3,4,7,10,5},
            {1},
            {2,3},
            {}
        };
        int[] N = {5, 10, 2, 3, 1};
        int[] expected = {4, 9, 2, 1, 1};
        for(int i = 0; i < inputs.length; i++) {
            int actual = missingNumber(inputs[i], N[i]);
            if (actual == expected[i]) {
                System.out.printf("Test case %d passed! \n", i + 1);
            } else {
                System.out.printf("Test case %d failed! ", i + 1);
                System.out.printf("Expected result %s, actual result %s \n",
                    expected[i], actual);
            }
            System.out.println();
        }
    }

    // Loop over every expected element, try to find it in the array
    // Time complexity O(n^2)
    private static int missingNumber(int a[], int n) {
        for(int i = 1; i <= n; i++) {
            int nextNumber = i;
            boolean found = false;
            for(int j = 0; j < a.length; j++) {
                if (a[j] == nextNumber) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return nextNumber;
            }
        }
        return -1;
    }
}
