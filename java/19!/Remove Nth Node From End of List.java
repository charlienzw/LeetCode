/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        ListNode p=head;
        ListNode q=null,r=null;
        int i=0;
        while(p!=null)
        {
            if(i%n==0) 
            {
                r=q;
                q=p;
            }
            p=p.next;
            i++;
        }
        if(n==i) return head.next;
        i--;
        for(int j=0;j<i%n;j++)
        {
            r=r.next;
        }
        r.next=r.next.next;
        return head;
    }
}