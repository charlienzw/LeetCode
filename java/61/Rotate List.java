/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        int cnt = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        //Length of linked list
        ListNode cur = head;
        int l = 0;
        while(cur.next != null)
        {
            cur = cur.next;
            l++;
        }
        l++;
        
        
        k = k % l;
        if(k == 0) return head;
        ListNode end = cur;
        cur = head;
        while(cnt < l-k)
        {
            cur=cur.next;
            cnt++;
        }
        dummy.next = cur.next;
        end.next = head;
        cur.next = null;  
        return dummy.next;
    }
}