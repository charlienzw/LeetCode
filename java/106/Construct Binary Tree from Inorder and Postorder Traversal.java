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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0) return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        TreeNode p=root;
        TreeNode pp=p;
        Stack<TreeNode> s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        s.push(root);
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],inorder.length-1-i);
        }
        for(int i=postorder.length-2;i>=0;i--)
        {
            if(map.get(postorder[i])<map.get(p.val))
            {
                p.right=new TreeNode(postorder[i]);
                p=p.right;
                s.push(p);
            }
            else
            {
                while(s.size()>0&&map.get(postorder[i])>map.get(s.peek().val))
                {
                    pp=p;
                    p=s.pop();
                }
                p.left=new TreeNode(postorder[i]);
                p=p.left;
                s.push(p);
            }
        }
        return root;
    }
}