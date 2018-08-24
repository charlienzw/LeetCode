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
        if(head==null) return null;
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode p=hp;
        ListNode q=head;
        ListNode r=head.next;
        boolean deleteq=false;
        while(r!=null)
        {
            if(q.val==r.val)
            {
                p.next=r;
                q=r;
                r=r.next;
                deleteq=true;
            }
            else
            {
                if(deleteq) 
                {
                    p.next=r;
                    q=r;
                    r=r.next;
                    deleteq=false;
                }
                else
                {
                    p=q;
                    q=r;
                    r=r.next;
                }
            }
        }
        if(deleteq) p.next=null;
        return hp.next;
    }
}