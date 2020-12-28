package Leetcode;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString2 {
    /**
     *
     * @description
     * 1. 문자와 문자의 카운트를 세는 2개의 스택을 선언한다.
     * 2. 스택이 비어있을 때는 문자 스택에 문자, 문자 카운트 스택에 1를 Push 한다.
     * 3. 스택의 맨 위의 문자가 k 번째로 들어올 때, 문자 스택에서 k - 1 만큼 Pop 한다.
     * 4. 스택의 맨 위의 문자가 k 번째가 아닌 경우는 같은 문자인 경우, pop() + 1, 같은 문자가 아닌 경우 1 을 add 한다.
     * 5. 스택을 모두 pop 하여 reverse 한 문자열을 반환한다.
     */
    public static String removeDuplicates(String s, int k) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (countStack.empty()) {
                countStack.add(1);
                characterStack.add(c);
            } else if (characterStack.peek() == c && countStack.peek() == k - 1) {
                for (int i = 0; i < k - 1; i++) {
                    characterStack.pop();
                }
                countStack.pop();
            } else {
                if (characterStack.peek() == c) {
                    int peek = countStack.pop() + 1;
                    countStack.add(peek);
                } else {
                    countStack.add(1);
                }
                characterStack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (characterStack.size() > 0) {
            sb.append(characterStack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("removeDuplicates = " + removeDuplicates("abcd", 2));
        System.out.println("removeDuplicates = " + removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println("removeDuplicates = " + removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
