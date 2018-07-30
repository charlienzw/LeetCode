/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null) return null;
        ListNode p=head;
        ListNode q=head;
        int length=0;
        while(p!=null)
        {
            p=p.next;
            length++;
        }
        length=length/2+1;
        int s=0;
        while(s<length-1)
        {
            s=s+1;
            q=q.next;
        }
        return q;
    }
}