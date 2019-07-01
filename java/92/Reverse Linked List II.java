/*
    Input: 1->2->3->4->5->NULL, m = 2, n = 4
    Output: 1->4->3->2->5->NULL
    leftTail: 1
    reversedTail: 2
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        int index = 1;
        ListNode leftTail = prev;
        ListNode reversedTail = cur;
        while (cur != null) {
            ListNode next = cur.next;
            if (index == m) {
                leftTail = prev;
                reversedTail = cur;
            } else if (index > m && index < n) {
                cur.next = prev;
            } else if (index == n) {
                cur.next = prev;
                leftTail.next = cur;
                reversedTail.next = next;
                return dummy.next;
            }
            prev = cur;
            cur = next;
            index++;
        }
        return dummy.next;
    }
}