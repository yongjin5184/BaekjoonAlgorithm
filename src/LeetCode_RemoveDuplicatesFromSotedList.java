class LeetCode_RemoveDuplicatesFromSortedList {


    public static void main(String[] args) {
        /**
         * description  : LeetCode Remove Duplicates From SortedList
         *                정렬된 리스트에서 중복된 수를 지우는 문제
         * solution     : 1. while loop 를 돈다.
         *                2. listNode 의 val 가 다음 node 의 val 가 같다면 다음 node 로 가서 node 를 붙인다. (next.next)
         *                3. 그렇지 않은 경우는 next node 를 붙인다.
         * result       : O(n)
         */
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(1);
        ListNode listNode1_3 = new ListNode(2);
        ListNode listNode1_4 = new ListNode(3);
        ListNode listNode1_5 = new ListNode(3);
        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = listNode1_4;
        listNode1_4.next = listNode1_5;

        printListNode(deleteDuplicates(listNode1));
        printListNode(deleteDuplicates(listNode1_1));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode node = head;
        while(node != null){
            if(node.next != null && node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
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

