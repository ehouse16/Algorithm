/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }*/

class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode result = node;
        int add = 0;

        while(list1 != null || list2 != null){
            int sum = add;

            if(list1 != null){
                sum += list1.val;
                list1 = list1.next;
            }
            
            if(list2 != null){
                sum += list2.val;
                list2 = list2.next;
            }

            add = sum/10;
            sum %= 10;

            node.next = new ListNode(sum);
            node = node.next;
        }
        if(add > 0){
            node.next = new ListNode(add);
        }
        return result.next;
    }
}