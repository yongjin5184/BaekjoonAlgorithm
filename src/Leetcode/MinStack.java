package Leetcode;

import java.util.Stack;

public class MinStack {
    /**
     * @description Stack 안에 있는 최소값을 반환하는 getMin method 를 구현하는 문제
     * 1. 2개의 stack 을 만든다. 값을 저장하는 stack, 최소값을 저장하는 stack
     * 2. push 는 stack 이 비어 있거나 push 된 값이 Stack 의 peek 값 보다 작을 경우 minStack 에 push 한다.
     * 3. pop 은 pop 하는 값이 minStack 의 peek 값과 같은 경우만 minStack 에서 pop 한다.
     * 4. getMin 의 경우는 minStack 의 peek 을 호출한다.
     */
    static class MinimumStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinimumStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinimumStack minStack = new MinimumStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin = " + minStack.getMin()); // return -3
        minStack.pop();
        System.out.println("top = " + minStack.top()); // return 0
        System.out.println("getMin = " + minStack.getMin()); // return -2
    }
}
