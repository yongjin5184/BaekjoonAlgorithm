import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_MergeTwoSortedLists {
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

        System.out.println(mergeTwoLists(listNode1, listNode1_1));
    }



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }

        if(l1 != null){
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }

        if(l2 != null){
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
