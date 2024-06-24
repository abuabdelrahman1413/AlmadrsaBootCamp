/*
 * Find the frequency of a given element in an array
 * How many times x exists in the given array
 * 
 * Example:
 * Input:
 * arr = {1, 1, 1, 1, 1}
 * x = 1
 * Output: 
 * 5
 * Explanation: Frequency of 1 is 5.
 * 
 * Original problem
 * https://practice.geeksforgeeks.org/problems/find-the-frequency/1
 */

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        int[][] inputs = {
            {1,1,1,1,1},
            {1,2,2,3,3},
            {1,2,3,4,5},
            {1,3,4,5,6},
            {10},
            {10},
            {},
            {}
        };
        int[] targets = {1, 3, 1, 2, 10, 5, 1, 0};
        int[] expected = {5, 2, 1, 0, 1, 0, 0, 0};
        for(int i = 0; i < inputs.length; i++) {
            int actual = findFrequency(inputs[i], targets[i]);
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

    private static int findFrequency(int a[], int x) {
        int count = 0;
        for(int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                count++;
            }
        }
        return count;
    }
}
