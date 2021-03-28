package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LeetCode_ValidParentheses {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode ValidParentheses
         *                짝이 맞는 brace 를 찾는 문제
         * solution     : 1. 스택을 사용하여 (, {, [ 이 나오면 Push
         *                2. 맞는 짝이 나오면 pop 를 시킨다.
         *                3. 맞는 짝이 나오지 않으면 false 를 반환
         * result       : O(n^2)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(isValid(br.readLine()));
    }

    public static boolean isValid(String s) {
        char[] braces = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (char brace : braces) {
            if (brace == '(' || brace == '{' || brace == '[') {
                stack.push(brace);
            } else {
                if(stack.empty()) return false;
                else if(brace == ')' && stack.peek() == '(') stack.pop();
                else if(brace == '}' && stack.peek() == '{') stack.pop();
                else if(brace == ']' && stack.peek() == '[') stack.pop();
                else return false;
            }
        }

        return stack.empty();
    }
}
