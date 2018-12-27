/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    Deque<TreeNode> s;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        s = new ArrayDeque<>();
        cur = root;
        while(cur != null)
        {
            s.push(cur);
            cur = cur.left;
        }

    }
    
    /** @return the next smallest number */
    public int next() {
        int res = 0;
        if(cur == null)
        {
            cur = s.pop();
            res = cur.val;
            cur = cur.right;
            while(cur != null)
            {
                s.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return s.size() > 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */