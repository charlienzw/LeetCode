/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }
        int res = 0;
        cur = head;
        int index = 0;
        while (cur != null) {
            if (cur.val == 1) {
                res += (int)Math.pow(2, cnt - 1 - index);
            }
            cur = cur.next;
            index++;
        }
        return res;
    }
}