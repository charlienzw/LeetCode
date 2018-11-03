/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode[] list = new ListNode[2];
        boolean done = (head == null);
        for(int step = 1; !done; step *= 2)
        {
            done = true;
            ListNode prev = dummy;
            ListNode remaining = prev.next;
            while(true)
            {
                for(int i = 0; i < 2; ++i)
                {
                    list[i] = remaining;
                    ListNode tail = null;
                    for(int j = 0; j < step && remaining != null; j++)
                    {
                        tail = remaining;
                        remaining = remaining.next;
                    }
                    if(tail != null)
                    {
                        tail.next = null;
                    }
                }
                done &= (remaining == null);
                if(list[1] != null)
                {
                    while(list[0] != null || list[1] != null)
                    {
                        int idx = (list[1] == null || list[0] != null && list[0].val < list[1].val) ? 0 : 1;
                        prev.next = list[idx];
                        list[idx] = list[idx].next;
                        prev = prev.next;
                    }
                    prev.next = null;
                }
                else
                {
                    prev.next = list[0];
                }
                if(remaining == null) break;
            }
        }
        return dummy.next;
    }
}