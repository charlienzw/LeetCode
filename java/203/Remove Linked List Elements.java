/*
    Remove all elements from a linked list of integers that have value val
        Remove one node from List
            Get the previous node of current node
            Modify the next pointer of previous node to next node
            If we need to remove the first node, add a dummy head node before that to make it same with other nodes
        Check if the node's value is val
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}