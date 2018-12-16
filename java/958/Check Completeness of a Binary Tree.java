/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
[1,2,3,4,5,null,7]
maxlevel = 2

*/
class Solution {
    int maxlevel = 0;
    boolean iscomplete = true;
    boolean shouldstop = false;
    public boolean isCompleteTree(TreeNode root) {
        getmaxlevel(root, 0);
        checkcomplete(root, 0);
        return iscomplete;
    }
    void getmaxlevel(TreeNode root, int level)
    {
        if(root != null)
        {
            if(level > maxlevel) maxlevel = level;
            getmaxlevel(root.left, level + 1);
            getmaxlevel(root.right, level + 1);
        }
    }
    void checkcomplete(TreeNode root, int level)
    {
        if(root != null)
        {
            if(level == maxlevel && shouldstop) iscomplete = false;
            checkcomplete(root.left, level + 1);
            checkcomplete(root.right, level + 1);
        }
        else
        {
            if(level == maxlevel) shouldstop = true;
            else if(level < maxlevel)
            {
                iscomplete = false;
            }
        }
    }    
}