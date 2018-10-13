/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    TreeNode p;
    Stack<TreeNode> s=new Stack<>();
    boolean end=false;
    public BSTIterator(TreeNode root) {
        if(root==null)
        {
            p=null;
            return;
        }
        p=root;
        while(p.left!=null)
        {
            s.add(p);
            p=p.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(p==null) return false;
        return !end;
    }

    /** @return the next smallest number */
    public int next() {
        int res=p.val;
        if(p.right!=null)
        {
            p=p.right;
            while(p.left!=null)
            {
                s.add(p);
                p=p.left;
            }
        }
        else
        {
            if(s.size()==0) 
            {
                end=true;
                return res;
            }
            p=s.pop();
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */