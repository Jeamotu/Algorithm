package leetcode;

public class LeetCode_00019_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;
        if (right.next == null) {
            return null;
        }

        while (right.next != null) {
            right = right.next;
            n--;
            if (n < 0) {
                left = left.next;
            }
        }

        if (n > 0) {
            return head.next;
        } else {
            left.next = left.next.next;
            return head;
        }
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
