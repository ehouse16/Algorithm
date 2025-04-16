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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode returnValue = dummy;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                returnValue.next = list1;
                list1 = list1.next;
            }
            else{
                returnValue.next = list2;
                list2 = list2.next;
            }
            returnValue = returnValue.next;
        } 

        if(list1 != null){
            returnValue.next = list1;
        } else {
            returnValue.next = list2;
        }

        return dummy.next;
    }
}