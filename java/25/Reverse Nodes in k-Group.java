//Time:O(n)
//Space:O(1)

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
        ListNode p=head;
        int cnt=0;
        while(p!=null)
        {
            p=p.next;
            cnt++;
        }
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode hpp=hp;
        ListNode end=hp.next;
        int d=cnt/k;
        for(int i=0;i<d;i++)
        {
            hpp.next=reverselist(end,k);
            hpp=end;
            end=hpp.next;
        }
        return hp.next;
    }
    
    public ListNode reverselist(ListNode head,int n)
    {
        ListNode pre=null,cur=head,r;
        int i=0;
        while(i<n)
        {
            r=cur.next;
            cur.next=pre;
            pre=cur;
            cur=r;
            i++;
        }
        head.next=cur;
        return pre;
    }
}