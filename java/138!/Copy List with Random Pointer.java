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
        if(head == null) return null;
        
        //Copy each node to its next
        RandomListNode cur = head;
        RandomListNode temp; 
        while(cur != null)
        {
            temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        
        //Modify random
        cur = head;
        while(cur != null)
        {
            if(cur.random!=null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        
        //Recover the linked list and get the result
        cur = head;
        RandomListNode res = head.next;
        while(cur.next!=null)
        {
            temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return res;
    }
}
