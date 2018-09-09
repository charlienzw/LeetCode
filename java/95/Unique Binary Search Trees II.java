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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<>();
        List<TreeNode> tmp;
        for(int i=1;i<=n;i++)
        {
            tmp=helper(new TreeNode(i),1,n);
            for(int j=0;j<tmp.size();j++)
            {
                res.add(tmp.get(j));
            }
        }
        return res;
    }
    public List<TreeNode> helper(TreeNode root,int start,int end)
    {
        if(start==end) 
        {
            List<TreeNode> res=new ArrayList<>();
            res.add(new TreeNode(root.val));
            return res;
        }
        TreeNode tmp;
        List<TreeNode> mergelist=new ArrayList<>();
        if(root.val==start)
        {
            for(int i=start+1;i<=end;i++)
            {
                root.right=new TreeNode(i);
                List<TreeNode> rightlist=helper(root.right,start+1,end);
                for(int j=0;j<rightlist.size();j++)
                {
                    mergelist.add(new TreeNode(root.val));
                    tmp=mergelist.get(mergelist.size()-1);
                    tmp.right=rightlist.get(j);
                }
            }
        }
        else if(root.val==end)
        {
            for(int i=start;i<=end-1;i++)
            {
                root.left=new TreeNode(i);
                List<TreeNode> leftlist=helper(root.left,start,end-1);
                for(int j=0;j<leftlist.size();j++)
                {
                    mergelist.add(new TreeNode(root.val));
                    tmp=mergelist.get(mergelist.size()-1);
                    tmp.left=leftlist.get(j);
                }                
            }            
        }
        else
        {
            for(int m=start;m<=root.val-1;m++)
            {
                for(int n=root.val+1;n<=end;n++)
                {
                    root.left=new TreeNode(m);
                    root.right=new TreeNode(n);
                    List<TreeNode> leftlist=helper(root.left,start,root.val-1);
                    List<TreeNode> rightlist=helper(root.right,root.val+1,end);
                    for(int i=0;i<leftlist.size();i++)
                    {
                        for(int j=0;j<rightlist.size();j++)
                        {
                            mergelist.add(new TreeNode(root.val));
                            tmp=mergelist.get(mergelist.size()-1);
                            tmp.left=leftlist.get(i);
                            tmp.right=rightlist.get(j);
                        }
                    }
                }
            }
        }
        return mergelist;
    }
}