/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
        // Get the length of linked list
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        
        // Split and Merge
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left, right, tail;
        for (int n = 1; n < len; n *= 2) {
            cur = dummy.next;
            tail = dummy;
            while (cur != null) {
                left = cur;
                right = split(left, n);
                cur = split(right, n);
                ListNode[] merged = merge(left, right);
                tail.next = merged[0];
                tail = merged[1];
            }
        }
        return dummy.next;
    }
    
    // Split the first n nodes, set its tail's next pointer to null and return the real next pointer
    private ListNode split(ListNode head, int n) {
        ListNode cur = head;
        for (int i = 0; i < n - 1; i++) {
            if (cur == null) {
                break;
            }
            cur = cur.next;
        }
        ListNode rest = cur == null ? null : cur.next;
        if (cur != null) cur.next = null;
        return rest;
    }
    
    // Merge two sorted lists and return the head and the tail of the merged list
    private ListNode[] merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        while (cur.next != null) {
            cur = cur.next;
        }
        return new ListNode[] { dummy.next, cur };
    }
}