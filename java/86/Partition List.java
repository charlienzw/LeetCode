/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode p=hp;
        ListNode q=head;
        ListNode r=hp;
        while(q!=null)
        {
            if(q.val<x)
            {
                if(p.next==q)
                {
                    p=p.next;
                    r=r.next;
                    q=r.next;
                }
                else
                {
                    r.next=q.next;
                    q.next=p.next;
                    p.next=q;
                    p=p.next;
                    q=r.next;
                }
            }
            else
            {
                q=q.next;
                r=r.next;
            }
        }
        return hp.next; 
    }
}