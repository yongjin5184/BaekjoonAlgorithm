package Leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public static String removeDuplicates(String S) {
        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.empty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }

            stack.pop();

        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("removeDuplicates = " + removeDuplicates("abbaca"));
    }
}
