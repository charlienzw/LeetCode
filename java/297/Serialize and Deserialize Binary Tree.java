//preorder with null
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
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    public void helper(TreeNode root, StringBuilder sb)
    {
        if(root == null)
        {
            sb.append("null,");
        }
        else
        {
            sb.append(root.val + ",");
            helper(root.left, sb);
            helper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] dataArray=data.split(",");
        return dehelper(dataArray, new int[]{0});
    }
    public TreeNode dehelper(String[] dataArray, int[] cur)
    {
        if(dataArray[cur[0]].equals("null"))
        {
            cur[0]++;
            return null;
        }
        else
        {
            TreeNode root = new TreeNode(Integer.valueOf(dataArray[cur[0]]));
            cur[0]++;
            root.left = dehelper(dataArray, cur);
            root.right = dehelper(dataArray, cur);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//postorder with null
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
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }
    public void helper(TreeNode root, StringBuilder sb)
    {
        if(root==null)
        {
            sb.append("null,");
        }
        else
        {
            helper(root.left, sb);
            helper(root.right, sb);
            sb.append(root.val + ",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] dataArray=data.split(",");
        return dehelper(dataArray, new int[]{dataArray.length - 1});
    }
    public TreeNode dehelper(String[] dataArray, int[] cur)
    {
        if(dataArray[cur[0]].equals("null"))
        {
            cur[0]--;
            return null;
        }
        else
        {
            TreeNode root = new TreeNode(Integer.valueOf(dataArray[cur[0]]));
            cur[0]--;
            root.right = dehelper(dataArray, cur);
            root.left = dehelper(dataArray, cur);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//
