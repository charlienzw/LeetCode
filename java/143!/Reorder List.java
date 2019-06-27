/*
    Reorder List
        Find mid node
        Reverse right list
        Merge left list and reversed right list
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
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        // Find mid node. For even number list, return the right mid node.
        ListNode midNode = getMidNode(head);
        
        // Reverse the right list except the mid node.
        ListNode reversedRightHead = reverse(midNode);
        
        // Merge the left list and reversed right list.
        // Case: 1->2->3->4     Left: 1->2->3   ReversedRight: 4    Merged: 1->4->2->3
        // Case: 1->2->3->4->5  left: 1->2->3   ReversedRight: 5->4 Merged: 1->5->2->4->3
        ListNode curLeft = head;
        ListNode curRight = reversedRightHead;
        ListNode curLeftNext;
        while (curLeft != midNode && curRight != null) {
            curLeftNext = curLeft.next;
            curLeft.next = curRight;
            curRight = curRight.next;
            curLeft.next.next = curLeftNext;
            curLeft = curLeftNext;
        }
    }
    
    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null; // Prevent MLE error. Don't let two pointers point to one node
        return prev;
    }
}