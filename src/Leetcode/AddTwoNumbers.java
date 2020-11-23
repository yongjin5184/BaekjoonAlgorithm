package Leetcode;


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next;}

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}

/**
 * description : LeetCode Add Two Number
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode l3 = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = (l1 != null) ? l1.val : 0;
            int l2Val = (l2 != null) ? l2.val : 0;

            int currentSum = l1Val + l2Val + carry;
            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            ListNode newNode = new ListNode(lastDigit);
            l3.next = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = l3.next;
        }

        return dummyHead.next;
    }

  public static void main (String[] args) {
    AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

    ListNode listNode3 = new ListNode(9);
    ListNode listNode4 = new ListNode(4, listNode3);
    ListNode listNode2 = new ListNode(2, listNode4);

    ListNode listNode4_ = new ListNode(4);
    ListNode listNode6 = new ListNode(6, listNode4_);
    ListNode listNode5 = new ListNode(5, listNode6);

    ListNode resultListNode = addTwoNumbers.addTwoNumbers(listNode2, listNode5);
    System.out.println(resultListNode.toString());

  }
}


