/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res=helper(root,"");
        return res.substring(0,res.length()-1);
    }
    public String helper(TreeNode root,String str)
    {
        if(root==null)
        {
            str=str+"null,";
        }
        else
        {
            str=str+root.val+",";
            str=helper(root.left,str);
            str=helper(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    int cur=0;
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] dataset=data.split(",");
        return dehelper(dataset);
    }
    public TreeNode dehelper(String[] dataset)
    {
        if(dataset[cur].equals("null"))
        {
            cur++;
            return null;
        }
        else
        {
            TreeNode root=new TreeNode(Integer.valueOf(dataset[cur]));
            cur++;
            root.left=dehelper(dataset);
            root.right=dehelper(dataset);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));