/*
Iterative
Input: 1->2->3->4->5->NULL
pre = 1, cur = 2, next = null

next = 3, 1 <- 2, pre = 2, cur = 3
next = 4, 2 <- 3, pre = 3, cur = 4
next = 5, 3 <- 4, pre = 4, cur = 5
next = null, 4 <- 5, pre = 5, cur = null

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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = head, cur = head.next, next = null;;
        
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        head.next = null;
        return pre;
    }
}

/*
Recursive
Input: 1->2->3->4->5->NULL
pre = 1, cur = 2, next = null

reverse(1)
    reverse(2)
        reverse(3)
            reverse(4)
                reverse(5)
                    5.next = null, return 5
                5.next = 4, return 5
            4.next = 3, return 5
        3.next = 2, return 5
    2.next = 1, return 5
1.next = null
            
            

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}