/*
head = [3,2,0,-4], pos = 1
cyc = -4

F: head : start
a: start : cyc
b: cyc : start

2 * slow = fast
2 * (F + a) = F + a + b + a
2F + 2a = F + 2a + b
F = b
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode cyc = cycNode(head);
        if(cyc == null) return null;
        ListNode cur = head;
        while(cur != cyc)
        {
            cur = cur.next;
            cyc = cyc.next;
        }
        return cur;
    }
    
    public ListNode cycNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return slow;
        }
        return null;
    }
}