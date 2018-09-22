/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p=head;
        int cnt=0;
        while(p!=null)
        {
            p=p.next;
            cnt++;
        }
        h=head;
        return helper(cnt);
    }
    public TreeNode helper(int n)
    {
        if(n<=0) return null;
        TreeNode left=helper(n/2);
        TreeNode root=new TreeNode(h.val);
        root.left=left;
        h=h.next;
        root.right=helper(n-1-n/2);
        return root;
    }
}