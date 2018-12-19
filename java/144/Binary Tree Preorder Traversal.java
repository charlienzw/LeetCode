//Recursive
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
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) return res;
        helper(root);
        return res;
    }
    public void helper(TreeNode root)
    {
        if(root != null)
        {
            res.add(root.val);
            helper(root.left);
            helper(root.right);
        }
    }
}

//Iterative with one stack
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();
        List<Integer> res=new ArrayList<>();
        while(s.size()>0||root!=null)
        {
            if(root==null)
            {
                root=s.pop();
                root=root.right;
            }
            else
            {
                res.add(root.val);
                s.push(root);
                root=root.left;
            }
        }
        return res;
    }
}

//Iterative with O(1) space
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root, prev = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                res.add(cur.val);
                cur = cur.right;
            }
            else
            {
                prev = cur.left;
                while(prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = cur;
                    res.add(cur.val);
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
