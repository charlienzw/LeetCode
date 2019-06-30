/*
    For adding, each digit's carry are not more than 1. 
    If current digit's value now is 9 then when the next digit's carry is 1, current digit's carry will become 1 and value will become 0.
    So use a mayCarryStart pointer to record one node to that ensures:
        The values of all the nodes from mayCarryStart(included) to current node(excluded) are 9. (The carries must be 0.)
    Define all the nodes from mayCarryStart(included) to current node(excluded) as mayCarry nodes.
    That means:
            
        if the current node's value is 9 (The carry must be 0.)
            if mayCarryStart == null
                mayCarryStart = cur
        else
            if the current node's carry is 1
                if mayCarryStart != null
                    set all the mayCarry nodes values to 0
                add 1 to mayCarryStartPrev node's value.
            set the mayCarryStart pointer to null to show there is no mayCarry node now.
            set mayCarryStartPrev to current node.
                
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Get the length of l1 and l2
        int len1 = 0, len2 = 0;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null) {
            cur1 = cur1.next;
            len1++;
        }
        while (cur2 != null) {
            cur2 = cur2.next;
            len2++;
        }
        
        // Ensure length of l1 is not less than l2
        ListNode tempList;
        int tempLen;
        if (len1 < len2) {
            tempList = l1;
            l1 = l2;
            l2 = tempList;
            tempLen = len1;
            len1 = len2;
            len2 = tempLen;
        }
        
        // Prepare adding
        cur1 = l1;
        cur2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode mayCarryStart = null;
        ListNode mayCarryStartPrev = dummy;
        int curPos = 0;
        
        // Set up the part l1 only has
        while (len1 - curPos != len2) {
            cur.next = new ListNode(cur1.val);
            cur = cur.next;
            cur1 = cur1.next;
            curPos++;
            if (cur.val == 9) {
                if (mayCarryStart == null)  mayCarryStart = cur;
            } else {
                mayCarryStart = null;
                mayCarryStartPrev = cur;
            }
        }
        
        // Set up the rest part
        while (cur1 != null) {
            int sum = (cur1.val + cur2.val) % 10;
            int carry = (cur1.val + cur2.val) / 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (sum == 9) {
                if (mayCarryStart == null) mayCarryStart = cur;
            } else {
                if (carry == 1) {
                    if (mayCarryStart != null) {
                        while (mayCarryStart != cur) {
                            mayCarryStart.val = 0;
                            mayCarryStart = mayCarryStart.next;
                        }
                    }
                    mayCarryStartPrev.val++;
                }
                mayCarryStart = null;
                mayCarryStartPrev = cur;
            }
        }
        return dummy.val != 0 ? dummy : dummy.next;      
    }
}