import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This program performs a series of operations on a number given by
 * the user.
 * 
 * Your goal is to calculate the time complexity of each of these operations
 * Time complexity as Big-O (Worst case), Omega (Best case) & Theta (Avergae case)
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

    /**
     * Returns all the prime numbers from 1 up to maxNumber
     * Prime numbers are numbers divisible only by 1 and the number itself
     * You can read more about prime numbers here:
     * https://en.wikipedia.org/wiki/Prime_number
     * 
     * @param maxNumber
     * @return Array of all prime numbers in range 1 to maxNumber
     */
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

        // Time complexity O(n^2)
    }

    /**
     * Checks whether a number is prime number or not
     * 
     * @param number
     * @return true if the number is prime, false otherwise.
     */
    private static boolean isPrime(int number) {
        for(int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;

        // Time complexity O(n)
    }

    /**
     * Calculates the fibonacci value of the number at num's position
     * 
     * Fibonacci value at position N is calculated by the sum of the
     * Fibonacci values at position N-1 & N-2
     * Fib(N) = Fib(N - 1) + Fib(N-2)
     * 
     * These numbers form what is called a Fibonacci series
     * starting with Fib(0) = 0 & Fib(1) = 1 as the start of the series
     * 
     * The series up to position 6 (0 based) looks like this
     * 0, 1, 1, 2, 3, 5, 8
     * Fib(0) = 0
     * Fib(1) = 1
     * Fib(2) = Fib(0) + Fib(1) = 1
     * Fib(3) = Fib(2) + Fib(1) = 2
     * Fib(4) = Fib(3) + Fib(2) = 3
     * Fib(5) = Fib(4) + Fib(3) = 5
     * Fib(6) = Fib(5) + Fib(4) = 8
     * 
     * You can read more about Fibonacci numbers here
     * https://en.wikipedia.org/wiki/Fibonacci_number
     * 
     * @param num
     * @return
     */
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
        // Time complexity O(2^n) every call takes O(n) time.
    }

    /**
     * Instead of using recursion, keep two variables for fib[n- 1] & fib[n-2]
     * loop over all following numbers up to num and calculate each value using
     * the 2 previous values
     * @param num
     * @return
     */
    private static int getFibonacciNumberEfficient(int num) {
        int prev = 0;
        int cur = 1;
        for(int i = 2; i <= num; i++) {
            int newPrev = cur;
            cur += prev;
            prev = newPrev;
        }
        return cur;

        // Time complexity O(n)
    }

    private static int search(int num, int[] numArr) {
        for(int i = 0; i < numArr.length; i++) {
            if (num == numArr[i]) {
                return i;
            }
        }
        return -1;
        // Time complexity O(n)
    }

    /**
     * Calculates the integer Square Root of a given number
     * 
     * Square root of a number (N) is the value (X) at which
     * X * X = N
     * 
     * Perfect Square numbers are numbers where Sqrt(N) is an integer value
     * for example:
     * 4 is a perfect square number => Sqrt(4) = 2
     * 9 is a perfect square number => Sqrt(9) = 3
     * 5 is NOT a perfect square number => Sqrt(5) = 2.23606...
     * 
     * This function returns the closest integer value to the square root of a given number
     * It truncates down to the closest Integer BELOW the actual square root for
     * non-perfect square numbers
     * 
     * Examples
     * getSquareRootValue(4) = 2
     * getSquareRootValue(9) = 3
     * getSquareRootValue(5) = 2 (truncate 2.23606...)
     * 
     * The technique used here is called Binary Search
     * You can read more about Binary Search here:
     * https://en.wikipedia.org/wiki/Binary_search_algorithm
     * 
     * @param num
     * @return the integer square root of value num
     */
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

	// Time complexity O(log(n))
}
