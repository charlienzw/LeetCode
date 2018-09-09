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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0) return null;
        TreeNode root=new TreeNode(preorder[0]);
        TreeNode p=root;
        TreeNode pp=p;
        Stack<TreeNode> s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        s.push(root);
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        for(int i=1;i<preorder.length;i++)
        {
            if(map.get(preorder[i])<map.get(p.val))
            {
                p.left=new TreeNode(preorder[i]);
                p=p.left;
                s.push(p);
            }
            else
            {
                while(s.size()>0&&map.get(preorder[i])>map.get(s.peek().val))
                {
                    pp=p;
                    p=s.pop();
                }
                p.right=new TreeNode(preorder[i]);
                p=p.right;
                s.push(p);
            }
        }
        return root;
    }
}