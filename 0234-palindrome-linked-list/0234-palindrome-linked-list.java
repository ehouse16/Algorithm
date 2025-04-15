/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        //중간까지의 값 구하기
        while(second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }

        // 뒤집기
        ListNode reverseList = reverse(first);

        // 비교하기
        while(reverseList != null){
            if(head.val != reverseList.val)
                return false;
            head = head.next;
            reverseList = reverseList.next;
        }
        return true;
    }

    private ListNode reverse(ListNode list){
        ListNode returnValue = null;

         while (list != null) {
            ListNode temp = list.next;
            list.next = returnValue;
            returnValue = list;
            list = temp;
        }
        return returnValue;
    }
}