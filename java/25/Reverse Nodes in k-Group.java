/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode cur = head;
        ListNode pre = null;
        while (true) {
            pre = cur;
            for (int i = 0; i < k; i++) {
                if (cur == null) return dummy.next;
                cur = cur.next;
            }
            tail.next = reverseBetween(pre, 1, k);
            tail = pre;
        }
    }
    
    private ListNode reverseBetween(ListNode head, int m, int n) {
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