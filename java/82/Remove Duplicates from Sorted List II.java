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
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        boolean willDelete = false;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                willDelete = true;
            } else {
                if (willDelete) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }
                willDelete = false;
            }
            cur = cur.next;
        }
        if (willDelete) {
            prev.next = null;
        }
        return dummy.next;
    }
}