import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program performs a series of operations on a number given by
 * the user.
 * 
 * Your goal is to calculate the time complexity of each of these operations
 * Time complexity as Big-O
 */
class Main {
    public static void main(String[] args) {
        int[] luckyNumbers = {5, 2, 10, 20, 3, 18, 7, 15, 9, 17, 30, 25};

        Scanner consoleInput = new Scanner( System.in );
        System.out.println("Welcome to Numbers Game");
        while (true) {
            System.out.println("Enter a number between 0 & 30");
            int num = consoleInput.nextInt();
            
            System.out.println();

            if (num < 0 || num > 30) {
                System.out.println("Number is out of valid range");
                consoleInput.close();
                System.out.println("Exit Game");
                return;
            }

            // First operation (calculate all prime numbers up to num):
            Integer[] primes =  getAllPrimeNumbers(num);
            System.out.printf("Prime numbers up to %d are %s: \n",
                num, Arrays.toString(primes));
            System.out.println();

            // Second operation (calculate Fibonacci number of num):
            int efficientFibonacciNum = getFibonacciNumberInefficient(num);
            System.out.printf("The fibonacci number (inefficient) at position %d is: %d \n",
                num, efficientFibonacciNum);
            System.out.println();

            int inefficientFibonacciNum = getFibonacciNumberEfficient(num);
            System.out.printf("The fibonacci number (efficient) at position %d is: %d \n",
                num, inefficientFibonacciNum);
            System.out.println();


            // Third operation (find number in luckyNumbers):
            int indexInLuckyNumbers = search(num, luckyNumbers);
            if (indexInLuckyNumbers == -1) {
                System.out.println("Couldn't find number in lucky numbers array");
            } else {
                System.out.printf("You're lucky! the number you entered is lucky number %d\n", indexInLuckyNumbers + 1);
            }
            System.out.println();

            // Forth operation (calculate int Sqrt):
            int sqrt = getSquareRootValue(num);
            System.out.printf("The Square Root of %d is: %d \n",
                num, sqrt);
            System.out.println();
            System.out.println();
        }
    }

    // Time Complexity: O(n^2)
    // Explanation:
    // Nested loops:
    //   Outer loop over all numbers up to (maxNumber)
    //   Inner loop over numbers from 2 - i
    // Examples:
    // 2 ==> (1 * 1)
    // 10 ==> (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10)
    // For n numbers ==> total number of operations = n * (last + first) / 2
    // Last = n, first = 2 ==> total = n * (n - 2) / 2 = n^2/2 - n ==> O(n^2)
    private static Integer[] getAllPrimeNumbers(int maxNumber) {
        // Prime numbers start from 2.
        // Loop over all numbers from 2 and up to maxNumber
        // Foreach number check if the number is prime.
        // if prime, add to list
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for(int i = 2; i <= maxNumber; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        Integer[] result = new Integer[primes.size()];
        result = primes.toArray(result);
        return result;
    }

    // Time Complexity: O(n)
    // Explanation: Worst case scenario is loop over all numbers
    private static boolean isPrime(int number) {
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Time Complexity: Big-O(2 ^ N)
    // Explanation (for N = 5):
    // Recursion creates a tree of calls:
    //                              fib(5) ---------------------------------------- Level 0           
    //                             /      \
    //                          /            \
    //                       /                  \
    //                 fib(3)                    fib(4) --------------------------- Level 1
    //                /      \                  /      \
    //             /            \            /            \
    //       fib(2)             *fib(1)   fib(2)           fib(3) ----------------- Level 2
    //      /      \                     /      \         /      \
    //  *fib(1)    *fib(0)         *fib(1)      *fib(0) /          \
    //                                                /              \
    //                                           fib(2)               *fib(1) ----- Level 3
    //                                          /      \
    //                                   *fib(1)        *fib(0) ------------------- Level 4
    //
    //
    // Number of levels = N
    // Each level (on avergae) has 2 calls * (# of calls of previous level)
    // Number of calls at level 0 = 2^0 = 1
    // Number of calls at level 1 = 2^1 = 2
    // Number of calls at level 2 = 2^2 = 4
    // ....
    // Number of calls at level N-1 = 2^(N-1)
    // Total number of operations = operations at leaf nodes (marked with *)
    // We make the same number of calculations for the same input
    // Leaf nodes on worst case & on average happen at last level (level N - 1)
    // Total number of operations = 2^N-1 = 2^N * (2^-1) = 0.5 * 2^N
    // Total number of operations = O(2^N)
    private static int getFibonacciNumberInefficient(int num) {
        // The technique used here is Recursion (Function calls itself)
        // with smaller values.

        // For base cases (Fib(0) && Fib(1)) return the number
        // This is the termination condition to prevent having
        // endless recursive calls
        if (num < 2) {
            return num;
        }

        // For any
        return getFibonacciNumberInefficient(num - 1) + getFibonacciNumberInefficient(num - 2);
    }

    // Time Complexity: O(N)
    // Explanation:
    // Single loop up from 2 (constant) to N
    // Iterations grow linearly with num value
    private static int getFibonacciNumberEfficient(int num) {
        int prev = 0;
        int cur = 1;
        for(int i = 2; i <= num; i++) {
            int newPrev = cur;
            cur += prev;
            prev = newPrev;
        }
        return cur;
    }

    // Time Complexity O(N) = > N = size of numArr
    // Explanation
    // Loop over all elements. Worst case, element is at the end or not found
    // Best case element is found at first index Omega(1)
    // Avergae case element is found in the middle Theta(N)
    private static int search(int num, int[] numArr) {
        for(int i = 0; i < numArr.length; i++) {
            if (num == numArr[i]) {
                return i;
            }
        }
        return -1;
    }

    // Time Complexity O(logN)
    // Explanation:
    // number of operations = number of iterations in while loop
    // How many iterations do we make?
    // In each iteration we split remaining search space by half
    // we terminate when search space has 1 or 2 elements only
    // For N = 20, this is the search space in e
    // start                                mid                                     end       
    // 1    2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20
    //
    // mid * mid = 10 * 10 = 100 (much larger than 20) ==> set end to mid
    //
    // start            mid                 end                                            
    // 1    2   3   4   5   6   7   8   9   10
    //
    // mid * mid = 5 * 5 = 25 (larger than 20) ==> set end to mid
    //
    // start    mid     end                                           
    // 1    2   3   4   5
    //
    // mid * mid = 3 * 3 = 9 (smaller than 20) ==> set start to mid
    //
    // start   mid   end                                           
    // 3       4     5
    //
    // mid * mid = 4 * 4 = 16 (smaller than 20) ==> set start to mid
    // start/mid       end
    // 4               5
    // 
    // Since start == mid, terminate ==> result = 4
    // Actual Sqrt(20) = 4.47213...
    //
    // In each iteration search space is shrinked by half
    // Target = number of iterations
    // 
    // I start search space length = 20
    // 20 --> 10 --> 5 --> 2 --> 1
    // 1 --> 2 --> 4 --> 8 --> 16 --> 32 > 20
    // K levels ==> leaf nodes = 2^K at the last level
    //
    // In this scenario, I have the leaf nodes  = 20 and I'm looking for K
    // leaf nodes(N) = 2^K
    // N = 2 ^ K
    // LogN (base 2) = K ==> # of levels
    //
    // # of operations = LogN (base 2)
    // Time complexity O(logN)
    private static int getSquareRootValue(int num) {
        // for 0 & 1, the number is the square root of itself
        if (num < 2) {
            return num;
        }

        // We search for result between start & end (including both start & end);
        long start = 1;
        long end = num;

        // The technique is as follows
        // Get the middle value of the search space (from start to end)
        // Test if middle value is the square root
        // If it is not the square root, check how middle compares to the actual square root we look for
        // Middle can either be smaller or larger than square root
        // If middle is larger, then square root is at the first half of the search space (from start to middle)
        // If middle is smaller, then square root is at the second half of the search space (from middle to end)
        // Adjust search space range (start & end) on each iteration until you reach result.
        while (start < end) {
            // This is an integer division (no remainder)
            // 3 / 2 = 1 instead of 1.5
            // We use long here to protect from overflow when we
            // multiply mid * mid
            long mid = (start + end) / 2;

            // Since we don't know the actual Sqrt of num,
            // we know that num is the square of the result we look for.
            // Get the square of mid (mid * mid) & compare it to num to know
            // how mid compares to the Square root Sqrt(num)
            long midSquare = mid * mid;

            if (midSquare == num) {
                // num is a perfect square and we found the square root
                return (int)mid;
            }

            if (mid == start) {
                // mid == start means end follows start immediately
                // This can be the case for example when
                // start = 1 & end = 2
                // start = 3 & end = 4
                // In this case, the result is mid (which is also start)
                // The actual square root is somewhere in between (start & end), but we return
                // the truncated result (the smaller integer)
                return (int)mid;
            }
            
            if (midSquare > num) {
                // mid is larger than the sqrt value we are looking for
                // cut down search scope by half
                // Any number larger than mid can never be the sqrt we look for
                // But we need end to always point at the larger number.
                end = mid;
            } else {
                // mid is smaller than the actual square root.
                // cut down search scope by half
                // any number smaller than mid can never be the result
                start = mid;
            }
        }

        // The cycle breaks here if start == end from the beginning
        // This happens if num == 1
        // Sqrt(1) = 1;
        return (int)start;
    }
}