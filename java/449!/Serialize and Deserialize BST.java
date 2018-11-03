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
        if(root == null)
            return "#";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return helper(arr, new int[]{0});
    }
    public TreeNode helper(String[] arr, int[] index)
    {
        if(arr[index[0]].equals("#"))
        {
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[index[0]]));
        index[0]++;
        root.left = helper(arr, index);
        root.right = helper(arr, index);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));