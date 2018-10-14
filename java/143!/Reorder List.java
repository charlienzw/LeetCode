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
        if(head==null||head.next==null) return;
        ListNode p=head,q=head;
        while(q.next!=null&&q.next.next!=null)
        {
            p=p.next;
            q=q.next.next;
        }
        
        ListNode mid=p;
        ListNode cur=p.next;
        while(cur.next!=null)
        {
            p=cur.next;
            cur.next=p.next;
            p.next=mid.next;
            mid.next=p;
        }
        
        p=head;
        q=mid.next;
        while(p!=mid)
        {
            mid.next=q.next;
            q.next=p.next;
            p.next=q;
            p=q.next;
            q=mid.next;
        }
    }
}