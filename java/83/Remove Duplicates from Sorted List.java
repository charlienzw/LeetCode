/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        int tmp;
        ListNode p=head;
        tmp=head.val;
        while(p.next!=null)
        {
            if(p.next.val==tmp)
            {
                p.next=p.next.next;
            }
            else
            {
                tmp=p.next.val;
                p=p.next;
            }
        }
        return head;
    }
}