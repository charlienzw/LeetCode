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
    TreeNode x;
    boolean xenable;
    TreeNode node1,node2,node3;
    public void recoverTree(TreeNode root) {
        x=null;
        node1=null;
        node2=null;
        node3=null;
        xenable=false;
        helper(root);
        if(node3==null)
        {
            int tmp=node1.val;
            node1.val=node2.val;
            node2.val=tmp;
        }
        else
        {
            int tmp=node1.val;
            node1.val=node3.val;
            node3.val=tmp;
        }
    }
    public void helper(TreeNode root)
    {
        if(root!=null)
        {
            helper(root.left);
            if(xenable&&x.val>=root.val)
            {
                if(node1==null) 
                {
                    node1=x;
                    node2=root;
                }
                else node3=root;
            }
            else
            {
                xenable=true;
            }
            x=root;
            helper(root.right);
        }
    }
}