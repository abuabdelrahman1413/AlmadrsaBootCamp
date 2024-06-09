import java.util.*;

class Main {
    public static void main(String[] args) {
        // DO NOT CHANGE THIS CODE
        // TEST CASES
        char[][] inputs = {
            {},
            {'('},
            {'['},
            {'{'},
            {')'},
            {']'},
            {'}'},
            {'(','}'},
            {'(',')'},
            {')','('},
            {'(',')','{'},
            {'(',')','}'},
            {'(',')','{','}'},
            {'(',')',')','}'},
            {')','(','{','}'},
            {'(','{',')','}'},
            {'(','{','}',')'},
            {'(','{','{','}',')'},
            {'(','{','[','}',')'},
            {'(','[','{','}',']',')'},
            {'(',')','{','}','[',']'},
            {'(',')','{','[',']','}'},
            {'(','{','[',']','}',')'},
            {'(','{','[',']','}',')','(',')'},
            {'(','{','[',']','}',')','(','{',')'},
            {'(','{','[',']','}',')','(','{',')','}'},
            {'(','{','[',']','}',')','(','{','}',')'},
            {']','(','{','[',']','}',')','(','{','}',')'},
            {'[','(','{','[',']','}',')','(','{','}',')',']'},
            {'[','(',')',']','{','}','{','[','(',')','(',')',']','(',')','}'},
        };
        boolean[] expected = {
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            true,
            false,
            false,
            true,
            true,
            true,
            true,
            true,
            false,
            false,
            true,
            false,
            true,
            true,
        };
        int passCount = 0;
        for(int i = 0; i < inputs.length; i++) {
            if (assertResult(i + 1, expected[i], areBalanced(inputs[i]))) {
                passCount++;
            }
        }
        System.out.printf("Passed %d / %d Test Cases.\n", passCount, inputs.length);
    }

    public static boolean areBalanced(char[] exp) {
        Stack<Character> stack = new Stack<>();
        for (char ch : exp) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean assertResult(int testNumber, boolean expected, boolean actual) {
        if (actual == expected) {
            System.out.printf("Test case %d: PASS!\n", testNumber);
        } else {
            System.out.printf("Test case %d: FAIL!\n", testNumber);
        }
        return actual == expected;
    }
}
