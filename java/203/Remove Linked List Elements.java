/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode hp=new ListNode(0);
        hp.next=head;
        ListNode p=hp,q=head;
        while(q!=null)
        {
            if(q.val==val)
            {
                q=q.next;
                p.next=p.next.next;
            }
            else
            {
                p=p.next;
                q=q.next;
            }
        }
        return hp.next;
    }
}