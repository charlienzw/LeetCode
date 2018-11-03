//Time:O(n)
//Space:O(1)


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
    TreeNode node1;
    TreeNode node2;
    TreeNode node3;
    TreeNode prenode;
    public void recoverTree(TreeNode root) {
        node1 = null;
        node2 = null;
        node3 = null;
        prenode = null;
        helper(root);
        int temp;
        if(node3 == null)
        {
            temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
        else
        {
            temp = node1.val;
            node1.val = node3.val;
            node3.val = temp;
        }
    }
    public void helper(TreeNode root)
    {
        if(root != null)
        {
            helper(root.left);
            if(prenode != null)
            {
                if(prenode.val >= root.val)
                {
                    if(node1 != null)
                    {
                        node3 = root;
                    }
                    else
                    {
                        node1 = prenode;
                        node2 = root;
                    }
                }
                prenode = root;
            }
            else
            {
                prenode = root;
            }
            helper(root.right);
        }
    }
}