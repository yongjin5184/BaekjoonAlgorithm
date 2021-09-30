package Leetcode;

import java.util.Stack;

public class PalindromeLinkedList {



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(isPalindrome(listNode1));;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode runner = head;
        Stack<ListNode> stack = new Stack<>();
        while (runner != null) {
            stack.push(runner);
            runner = runner.next;
        }
        runner = head;
        while (runner != null && !stack.isEmpty()) {
            if (runner.val != stack.pop().val) {
                return false;
            }
            runner = runner.next;
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
