/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode p=head;
        RandomListNode temp; 
        while(p!=null)
        {
            temp=new RandomListNode(p.label);
            temp.next=p.next;
            p.next=temp;
            p=temp.next;
        }
        
        p=head;
        while(p!=null)
        {
            if(p.random==null) p.next.random=null;
            else p.next.random=p.random.next;
            p=p.next.next;
        }
        
        RandomListNode res=head.next;
        p=head;
        while(p!=null)
        {
            if(p.next==null) p=p.next;
            else
            {
                temp=p.next;
                p.next=p.next.next;
                p=temp;
            }
        }
        return res;
    }
}