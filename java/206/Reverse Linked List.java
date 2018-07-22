/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode p,q,t;
        p=head;
        if(head==null) return head;
        q=head.next;
        while(q!=null)
        {
            t=q.next;
            q.next=p;
            p=q;
            q=t;
        }
        head.next=null;
        head=p;
        return head;
    }
}