/*
 * Find minimum and maximum element in an array
 * 
 * Given an array A of size N of integers. Your task is to find the minimum
 * and maximum elements in the array.
 * 
 * 
 * Example 1:
 * 
 * Input:
 * N = 6
 * A[] = {3, 2, 1, 56, 10000, 167}
 * Output:
 * min = 1, max =  10000
 * 
 * 
 * Example 2:
 * Input:
 * N = 5
 * A[]  = {1, 345, 234, 21, 56789}
 * Output:
 * min = 1, max = 56789
 * 
 * 1 <= N <= 10^5
 * 
 * Original problem
 * https://practice.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1
 */

class pair {
    long min, max;  
    public pair(long min, long max)  
    {  
        this.min = min;  
        this.max = max;  
    }
    public boolean equals(pair otherPair) {
        if (otherPair == null) {
            return false;
        }
        return this.min == otherPair.min && this.max == otherPair.max;
    }
    public String toString() {
        return "[Min=" + this.min + ", Max=" + this.max + "]";
    }
}

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        long[][] inputs = {
            {3, 2, 1, 56, 10000, 167},
            {1},
            {1,10},
            {-50, -200, -1000, -10000},
            {-50, 100, -1000, 5000},
            {0, 1}
        };
        pair[] expected = {
            new pair(1, 10000),
            new pair(1,1),
            new pair(1, 10),
            new pair(-10000, -50),
            new pair(-1000, 5000),
            new pair(0, 1)
        };
        for(int i = 0; i < inputs.length; i++) {
            pair actual = getMinMax(inputs[i], inputs[i].length);
            if (expected[i].equals(actual)) {
                System.out.printf("Test case %d passed! \n", i + 1);
            } else {
                System.out.printf("Test case %d failed! ", i + 1);
                System.out.printf("Expected result %s, Actual result %s \n",
                    expected[i].toString(), actual == null ? "NULL" : actual.toString());
            }
            System.out.println();
        }
    }

    private static pair getMinMax(long a[], long n) {
        pair result = new pair(a[0], a[0]);
        for(int i = 1; i < n; i++) {
            if (a[i] < result.min) {
                result.min = a[i];
            } else if (a[i] > result.max) {
                result.max = a[i];
            }
        }
        return result;
    }
}
