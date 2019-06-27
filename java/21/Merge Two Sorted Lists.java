// Recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l1 != null && l2 == null) return l1;
        ListNode l1Next = l1.next, l2Next = l2.next;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// Iterative
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode q;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                q = new ListNode(l1.val);
                p.next = q;
                p = p.next;
                l1 = l1.next;
            }
            else if(l2.val < l1.val)
            {
                q = new ListNode(l2.val);
                p.next = q;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 == null)
        {
            p.next = l2;
        }
        else
        {
            p.next = l1;
        }
        return res.next;
    }
}