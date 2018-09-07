/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode p=hp,q=head;
        int i=1;
        ListNode left=null,right=null;
        ListNode tmp=null;;
        while(true)
        {
            if(i==m) left=p;
            if(i==n+1) 
            {
                right=p;
                tmp=q;
                break;
            }
            if(i>m&&i<=n) 
            {
                tmp=q.next;
                q.next=p;
                p=q;
                q=tmp;
            }
            else
            {
                p=p.next;
                q=q.next;
            }
            i++;
        }
        if(left!=null&&right!=null)
        {
            ListNode l=left.next;
            left.next=right;
            l.next=tmp;
        }
        return hp.next;
    }
}