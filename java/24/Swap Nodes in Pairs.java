/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode headp=new ListNode(0);
        headp.next=head;
        ListNode p=head;
        ListNode q=head.next;
        ListNode r=headp;
        int flag=1;
        while(p!=null&&q!=null)
        {
            if(flag==1)
            {
                p.next=q.next;
                r.next=q;
                q.next=p;
                r=q;
                q=p.next;
                flag=0;
            }
            else
            {
                r=p;
                p=p.next;
                q=q.next;
                flag=1;
            }
        }
        return headp.next;
    }
}