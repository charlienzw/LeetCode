/*
    Delete a node (except the tail) in a singly linked list, given only access to that node
        Set the next node's val to current node
        Delete next node
            Set current node's next pointer to next node's next node
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
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}