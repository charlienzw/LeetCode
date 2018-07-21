/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode r=result;
        ListNode p=l1,q=l2;
        ListNode s;
        int x1,x2,tmp=0;
        while(true)
        {
            if(p==null&&q==null&&tmp==0)
                break;
            x1=0;
            x2=0;
            if(p!=null)
            {
                x1=p.val;
                p=p.next;
            }
            if(q!=null)
            {
                x2=q.val;
                q=q.next;
            }
            if(x1+x2+tmp>=10)
            {
                s=new ListNode((x1+x2+tmp)%10);
                r.next=s;
                r=s;
                tmp=(x1+x2+tmp)/10;
            }
            else
            {
                s=new ListNode(x1+x2+tmp);
                r.next=s;
                r=s;
                tmp=0;
            }
        }
        result=result.next;
        return result;
    }
}