//Preorder
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
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    public void helper(TreeNode root, StringBuilder sb)
    {
        if(root != null)
        {
            sb.append(root.val + ",");
            helper(root.left, sb);
            helper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        data = data + "," + "#";
        String[] dataArray = data.split(",");
        return dehelper(dataArray, new int[]{0}, "#");
    }
    
    public TreeNode dehelper(String[] dataArray, int[] cur, String stop)
    {
        if(dataArray[cur[0]].equals("#") || !stop.equals("#") && Integer.valueOf(dataArray[cur[0]]) >= Integer.valueOf(stop))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[cur[0]]));
        cur[0]++;
        root.left = dehelper(dataArray, cur, root.val + "");
        root.right = dehelper(dataArray, cur, stop);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//Postorder
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
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    public void helper(TreeNode root, StringBuilder sb)
    {
        if(root != null)
        {
            helper(root.left, sb);
            helper(root.right, sb);
            sb.append(root.val + ",");
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        data = "#," + data;
        String[] dataArray = data.split(",");
        return dehelper(dataArray, new int[]{dataArray.length - 1}, "#");
    }
    
    public TreeNode dehelper(String[] dataArray, int[] cur, String stop)
    {
        if(dataArray[cur[0]].equals("#") || !stop.equals("#") && Integer.valueOf(dataArray[cur[0]]) <= Integer.valueOf(stop))
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataArray[cur[0]]));
        cur[0]--;
        root.right = dehelper(dataArray, cur, root.val + "");
        root.left = dehelper(dataArray, cur, stop);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));