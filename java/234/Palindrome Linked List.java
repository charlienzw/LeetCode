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
        if(head==null) return true;
        if(head.next==null) return true;
        if(head.next.next==null)
        {
            return head.val==head.next.val;
        }
        ListNode p=head,q,r;
        int n=0;
        while(p!=null)
        {
            p=p.next;
            n++;
        }
        p=head;
        int i=1;
        q=p.next;
        while(q!=null)
        {
            if(i>n/2)
            {
                r=q.next;
                q.next=p;
                p=q;
                q=r;
            }
            else
            {
                p=p.next;
                q=p.next;
            }
            i++;  
        }
        q=head;
        while(p!=q&&p.next!=q)
        {
            if(p.val!=q.val) return false;
            p=p.next;
            q=q.next;
        }
        return true;
    }
}