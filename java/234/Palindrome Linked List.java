/*
    Determine if it is a palindrome
        Find the mid node
            Double pointer to get the mid node
            Corner case: odd or even number of nodes
                Count the nodes
        Reverse the right half list
        Compare each nodes from head and the reversed right half list
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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightPrev = cnt % 2 == 0 ? slow : slow.next;
        
        ListNode reversedRight = reverse(rightPrev);
        rightPrev.next = null;
        
        ListNode leftCur = head, rightCur = reversedRight;
        while (rightCur != null) {
            if (leftCur.val != rightCur.val) {
                return false;
            }
            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, cur = head.next;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        return prev;
    }
}