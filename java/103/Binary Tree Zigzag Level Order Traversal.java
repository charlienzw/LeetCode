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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> s1=new Stack<>();
        s1.push(root);
        List<Integer> tmp=new ArrayList<>();
        tmp.add(root.val);
        res.add(tmp);
        Stack<TreeNode> s2=new Stack<>();
        boolean dir=false;
        TreeNode tempnode;
        while(true)
        {
            if(!dir)
            {
                tmp=new ArrayList<>();
                while(s1.size()>0)
                {
                    tempnode=s1.pop();
                    if(tempnode.right!=null)
                    {
                        s2.push(tempnode.right);
                        tmp.add(tempnode.right.val);
                    }
                    if(tempnode.left!=null)
                    {
                        s2.push(tempnode.left);
                        tmp.add(tempnode.left.val);
                    }
                }
                if(tmp.size()==0) break;
                res.add(tmp);
                dir=true;
            }
            else
            {
                tmp=new ArrayList<>();
                while(s2.size()>0)
                {
                    tempnode=s2.pop();
                    if(tempnode.left!=null)
                    {
                        s1.push(tempnode.left);
                        tmp.add(tempnode.left.val);
                    }
                    if(tempnode.right!=null)
                    {
                        s1.push(tempnode.right);
                        tmp.add(tempnode.right.val);    
                    }
                }
                if(tmp.size()==0) break;
                res.add(tmp);
                dir=false;                
            }
        }
        return res;
    }
}