public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null) {
            prev.next = prev.next.next;
        } else {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}

// Definition for singly-linked list.
class ListNode {
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
