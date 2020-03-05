class LeetCode_RemoveDuplicatesFromSortedList {
    /**
     * description  : LeetCode Remove Duplicates From SortedList
     *                정렬된 리스트에서 중복된 수를 지우는 문제
     * solution     :
     * result       : O(n)
     */

    public static ListNode2 deleteDuplicates(ListNode2 head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode2 node = head;
        while(node!=null){
            if(node.next!= null && node.next.val == node.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }
}


class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2(int x) { val = x; }
}