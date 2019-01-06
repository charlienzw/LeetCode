/*
Given linked list: 1->2->3->4->5, and n = 2.

fast = 3

slow = 3
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        for(int i = 0; i < n + 1; i++)
        {
            fast = fast.next;
        }
        
        ListNode slow = dummy;
        while(fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}