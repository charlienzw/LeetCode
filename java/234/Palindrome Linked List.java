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
        if(head == null || head.next == null) return true;
        int cnt = 0;
        ListNode cur = head;
        while(cur != null)
        {
            cur = cur.next;
            cnt++;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightpre = cnt % 2 == 0 ? slow : slow.next;
        ListNode rightreverse = reverse(rightpre);
        rightpre.next = null;
        
        ListNode leftcur = head, rightcur = rightreverse;
        while(rightcur != null)
        {
            if(leftcur.val != rightcur.val)
            {
                return false;
            }
            leftcur = leftcur.next;
            rightcur = rightcur.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head)
    {
        if(head == null || head.next == null) return head;
        ListNode pre = head, cur = head.next;
        ListNode next;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}