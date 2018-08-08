/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la=0,lb=0;
        ListNode p=headA,q=headB;
        while(p!=null)
        {
            la++;
            p=p.next;
        }
        while(q!=null)
        {
            lb++;
            q=q.next;
        }
        p=headA;
        q=headB;
        if(la<lb)
        {
            int dis=lb-la;
            while(dis--!=0)
                q=q.next;
        }
        else
        {
            int dis=la-lb;
            while(dis--!=0)
                p=p.next;
        }
        while(p!=null&&q!=null)
        {
            if(p==q) return p;
            else
            {
                p=p.next;
                q=q.next;
            }
        }
        return null;
    }
}