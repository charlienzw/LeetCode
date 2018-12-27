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
            sb.append("#,");
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
        if(dataArray[cur[0]].equals("#"))
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

//level order with null
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
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode temp;
        while(q.size() > 0)
        {
            temp = q.poll();
            if(temp == null) sb.append("#,");
            else
            {
                sb.append(temp.val + ",");
                q.offer(temp.left);
                q.offer(temp.right);
            }
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] dataArray = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        for(int i = 0; i < dataArray.length; i++)
        {
            if(dataArray[i].equals("#"))
            {
                q.offer(null);
            }
            else
            {
                q.offer(new TreeNode(Integer.valueOf(dataArray[i])));
            }
        }
        return buildTree(q);
    }
    
    private TreeNode buildTree(Queue<TreeNode> q)
    {
        Queue<TreeNode> processed = new LinkedList<>();
        processed.offer(q.poll());
        TreeNode root = processed.peek();
        if(root == null) return null;
        while(!processed.isEmpty())
        {
            TreeNode parent = processed.poll();
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left != null)
            {
                processed.offer(left);
            }
            if(right != null)
            {
                processed.offer(right);
            }
            parent.left = left;
            parent.right = right;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
