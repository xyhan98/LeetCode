public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddDumy = new ListNode(0, head);
        ListNode evenDumy = new ListNode(0, head.next);
        ListNode odd = oddDumy.next;
        ListNode even = evenDumy.next;
        ListNode curr = head.next.next;
        while (curr != null && curr.next != null) {
            odd.next = curr;
            odd = odd.next;
            curr = curr.next;
            even.next = curr;
            even = even.next;
            curr = curr.next;
        }
        even.next = null;
        if (curr != null) {
            odd.next = curr;
            odd = odd.next;
        }
        odd.next = evenDumy.next;
        return oddDumy.next;
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
