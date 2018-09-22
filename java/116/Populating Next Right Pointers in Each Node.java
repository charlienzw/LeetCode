/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode p=root.left,q=root.right;
        while(p!=null&&q!=null)
        {
            p.next=q;
            connect(p);
            connect(q);
            p=p.right;
            q=q.left;
        }
    }
}