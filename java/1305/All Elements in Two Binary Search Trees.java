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
        while(cur != null) {
            s.push(cur);
            cur = cur.left;
        }

    }
    
    /** @return the next smallest number */
    public Integer next() {
        if (s.size() == 0) return null;
        int res = 0;
        if(cur == null) {
            cur = s.pop();
            res = cur.val;
            cur = cur.right;
            while(cur != null) {
                s.push(cur);
                cur = cur.left;
            }
        }
        return res;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        BSTIterator iter1 = new BSTIterator(root1);
        BSTIterator iter2 = new BSTIterator(root2);
        Integer next1 = iter1.next(), next2 = iter2.next();
        
        while (next1 != null && next2 != null) {
            if (next1 < next2) {
                res.add(next1);
                next1 = iter1.next();
            } else {
                res.add(next2);
                next2 = iter2.next();
            }
        }
        
        while (next1 != null) {
            res.add(next1);
            next1 = iter1.next();
        }
        
        while (next2 != null) {
            res.add(next2);
            next2 = iter2.next();
        }
        
        return res;  
    }
}