/*
Input: 1->2->3->4->5->NULL
oddlist: 1 -> 3 -> 5 -> null
evenlist: 2 -> 4 -> null
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddList = head;
        ListNode evenList = head.next;
        ListNode oddcur = oddList;
        ListNode evencur = evenList;
        
        ListNode cur = head.next.next;
        boolean isodd = true;
        while(cur != null)
        {
            if(isodd)
            {
                oddcur.next = cur;
                oddcur = oddcur.next;
                isodd = false;
            }
            else
            {
                evencur.next = cur;
                evencur = evencur.next;
                isodd = true;
            }
            cur = cur.next;
        }
        
        evencur.next = null;
        oddcur.next = evenList;
        
        return oddList;
    }
}