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
				{ 1, 2, 3, 4, 5 },
				{ 9, 8, 7, 6, 4, 2, 1, 3 },
				{ 1, 3 },
				{ 1 },
				{}
		};
		int[][] expected = {
				{ 5, 1, 2, 3, 4 },
				{ 3, 9, 8, 7, 6, 4, 2, 1 },
				{ 3, 1 },
				{ 1 },
				{}
		};
		for (int i = 0; i < inputs.length; i++) {
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

	private static int[] rotate(int a[]) {
		// Write your code here
		int[] new_array = new int[a.length];
		if (a.length == 0) {
			return new_array;
		}
		new_array[0] = a[a.length - 1];
		for (int i = 1; i <= a.length - 1; i++) {
			new_array[i] = a[i - 1];
		}
		return new_array;
	}
}
