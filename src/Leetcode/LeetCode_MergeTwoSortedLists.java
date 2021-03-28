package Leetcode;

public class LeetCode_MergeTwoSortedLists {
    public static void main(String[] args) {
        /**
         * description  : LeetCode MergeTwoSortedLists
         *                두 개의 정렬된 리스트를 더하는 문제 (listNode Class)
         * solution     : 1. head 를 선언한다.
         *                2. 두 개의 리스트 중 하나가 null 일 때까지 result 에 해당 list 를 연결해 준다.
         *                3. 하나의 list 가 null 이면 나머지 list 를 result 에 전부 연결한다.
         *                4. head 의 next 를 출력한다.
         * result       : O(n)
         */
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(3);
        ListNode listNode1_3 = new ListNode(4);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;

        printListNode(mergeTwoLists(listNode1, listNode1_1));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val){
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            } else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }

        return head.next;
    }

    private static void printListNode(ListNode head1) {
        StringBuilder st = new StringBuilder();
        while(head1 != null) {
            st.append(head1.val);
            head1 = head1.next;
            if(head1 != null) {
                st.append("->");
            }
        }

        System.out.println(st.toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
