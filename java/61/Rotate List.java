/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        int cnt=1;
        ListNode v=new ListNode(0);
        v.next=head;
        ListNode p=head;
        int l=0;
        while(p.next!=null)
        {
            p=p.next;
            l++;
        }
        l++;
        k=k%l;
        if(k==0) return head;
        ListNode end=p;
        p=head;
        while(cnt<l-k)
        {
            p=p.next;
            cnt++;
        }
        v.next=p.next;
        end.next=head;
        p.next=null;  
        return v.next;
    }
}