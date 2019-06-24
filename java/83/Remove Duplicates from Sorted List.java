/*
    Remove Duplicates from Sorted List
        Remove one node from List
            Get the previous node of current node
            Modify the next pointer of previous node to next node
            If we need to remove the first node, add a dummy head node before that to make it same with other nodes
        Check if one node is duplicate when sorted
            Record the value and check if same
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            if (pre != null && pre.val == cur.val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}