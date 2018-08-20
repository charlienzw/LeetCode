/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        if(k==1) return head;
        ListNode c=head;
        int l=0;
        while(c!=null)
        {
            c=c.next;
            l++;
        }
        if(l/k==0) return head;
        int cnt=0;
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode p=hp;
        ListNode q=head;
        ListNode r=head.next;
        ListNode s1=hp;
        ListNode s2=q;
        int i=0;
        while(q!=null)
        {
            i++;
            q.next=p;
            p=q;
            q=r;
            r=r==null?null:r.next;
            if(i%k==0)
            {
                cnt++;
                s1.next=p;
                s1=s2;
                s2.next=q;
                if(cnt==l/k) return hp.next;
                p=q;
                q=r;
                r=r==null?null:r.next;
                s2=p;
                i++;
            }
        }
        return hp.next;
    }
}