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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res)
    {
        if(root != null)
        {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode p=root;
        while(s.size() > 0 || p != null)
        {
            if(p != null)
            {
                s.push(p);
                p = p.left;
            }
            else
            {
                p = s.pop();
                res.add(p.val);
                p = p.right;
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
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    cur = cur.left;
                }
                else
                {
                    prev.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}