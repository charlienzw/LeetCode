/*
    Remove the n-th node from the end of list and return its head
        Remove one node from List
            Get the previous node of current node
                Get the n - 1 node
                    Set fast pointer to n + 1 node and set slow pointer to head then move them at the same time until fast is null
            Modify the next pointer of previous node to next node
            If we need to remove the first node, add a dummy head node before that to make it same with other nodes
        
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
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}