class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;
        ListNode subTail = curr;  
        ListNode rev = null;

        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = rev;
            rev = curr;
            curr = next;
        }

        prev.next = rev;
        subTail.next = curr;

        return dummy.next;
    }
}