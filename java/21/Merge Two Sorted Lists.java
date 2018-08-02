/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode p=res;
        ListNode q;
        while(l1!=null||l2!=null)
        {
            if(l2==null)
            {
                q=new ListNode(l1.val);
                p.next=q;
                p=p.next;
                l1=l1.next;   
            }
            else if(l1==null)
            {;
                q=new ListNode(l2.val);
                p.next=q;
                p=p.next;
                l2=l2.next;                
            }
            else if(l1.val<=l2.val)
            {
                q=new ListNode(l1.val);
                p.next=q;
                p=p.next;
                l1=l1.next;
            }
            else if(l2.val<l1.val)
            {
                q=new ListNode(l2.val);
                p.next=q;
                p=p.next;
                l2=l2.next;
            }
        }
        return res.next;
    }
}