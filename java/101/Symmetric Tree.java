// recursively
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
    boolean b;
    public boolean isSymmetric(TreeNode root) {
        TreeNode root1=root,root2=root;
        b=true;
        helper(root1,root2);
        return b;
    }
    public void helper(TreeNode root1,TreeNode root2)
    {
        if(root1==null&&root2!=null) b=false;
        if(root1!=null&&root2==null) b=false;
        if(root1!=null&&root2!=null)
        {
            if(root1.val!=root2.val) b=false;
            helper(root1.left,root2.right);
            helper(root1.right,root2.left);
        }    
    }
}


// iteratively
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
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        TreeNode root1=root,root2=root;
        while(s1.size()>0&&s2.size()>0||root1!=null&&root2!=null)
        {
            if(root1==null&&root2==null)
            {
                root1=s1.pop();
                root2=s2.pop();
                root1=root1.right;
                root2=root2.left;
            }
            else
            {
                if(root1==null&&root2!=null) return false;
                if(root1!=null&&root2==null) return false;
                if(root1!=null&&root2!=null)
                {
                    if(root1.val!=root2.val)
                        return false;
                }
                s1.push(root1);
                s2.push(root2);
                root1=root1.left;
                root2=root2.right;
            }
        }
        return true;
    }
}