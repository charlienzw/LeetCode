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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        boolean isleft = false;
        while(cur != null)
        {
            if(cur.val == key)
            {
                break;
            }
            else if(key > cur.val)
            {
                pre = cur;
                isleft = false;
                cur = cur.right;
            }
            else
            {
                pre = cur;
                isleft = true;
                cur = cur.left;
            }
        }
        if(cur == null) return root;
        
        
        if(cur.left == null && cur.right == null)
        {
            if(pre == null) return null;
            if(isleft) pre.left = null;
            else pre.right = null;
            return root;
        }
        
        if(cur.left == null && cur.right != null)
        {
            if(pre == null) return cur.right;
            if(isleft) pre.left = cur.right;
            else pre.right = cur.right;
            return root;
        }
        
        if(cur.left != null && cur.right == null)
        {
            if(pre == null) return cur.left;
            if(isleft) pre.left = cur.left;
            else pre.right = cur.left;
            return root;
        }
        
        if(cur.left != null && cur.right != null)
        {
            TreeNode rightcur = cur.right;
            TreeNode rightpre = cur;
            while(rightcur.left != null)
            {
                rightpre = rightcur;
                rightcur = rightcur.left;
            }
            TreeNode temp = rightcur.right;

            rightcur.left = cur.left;            
            rightcur.right = cur.right;

            if(rightpre == cur) rightcur.right = temp;
            else rightpre.left = temp;

            if(pre == null) return rightcur;
            if(isleft) 
            {
                pre.left = rightcur;
            }
            else 
            {
                pre.right = rightcur;
            }
            return root;
        }
        return root;
    }
}