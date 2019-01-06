/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        int sum, carry = 0;
        ListNode cur1 = l1, cur2 = l2;
        while(cur1 != null || cur2 != null)
        {
            if(cur1 == null)
            {
                if(carry == 0)
                {
                    pre.next = cur2;
                    break;
                }
                pre.next = new ListNode((cur2.val + carry) % 10);
                carry = (cur2.val + carry) / 10;
                pre = pre.next;
                cur2 = cur2.next;
            }
            else if(cur2 == null)
            {
                if(carry == 0)
                {
                    pre.next = cur1;
                    break;
                }
                pre.next = new ListNode((cur1.val + carry) % 10);
                carry = (cur1.val + carry) / 10;
                pre = pre.next;
                cur1 = cur1.next;                
            }
            else
            {
                pre.next = new ListNode((cur1.val + cur2.val + carry) % 10);
                carry = (cur1.val + cur2.val + carry) / 10;
                pre = pre.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        if(carry != 0)
        {
            pre.next = new ListNode(carry);
        }
        return dummy.next;
    }
}