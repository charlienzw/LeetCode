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

//Level order
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
    class NodeWrap{
        TreeNode node;
        Integer min;
        Integer max;
        public NodeWrap(TreeNode node, Integer min, Integer max)
        {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode temp;
        while(q.size() > 0)
        {
            temp = q.poll();
            sb.append(temp.val + ",");
            if(temp.left != null)
                q.offer(temp.left);
            if(temp.right != null)
                q.offer(temp.right);
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] dataArray = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < dataArray.length; i++)
        {
            q.offer(Integer.valueOf(dataArray[i]));
        }
        return buildTree(q);
    }
    
    public TreeNode buildTree(Queue<Integer> q)
    {
        TreeNode root = new TreeNode(q.poll());
        Queue<NodeWrap> limit = new LinkedList<>();
        limit.offer(new NodeWrap(root, null, null));
        while(q.size() > 0)
        {
            NodeWrap nw = limit.poll();
            TreeNode n = nw.node;
            if((nw.min == null || q.peek() > nw.min) && q.peek() < nw.node.val)
            {
                n.left = new TreeNode(q.poll());
                limit.offer(new NodeWrap(n.left, nw.min, n.val));
            }
            if(q.size() == 0) break;
            if((nw.max == null || q.peek() < nw.max) && q.peek() > nw.node.val)
            {
                n.right = new TreeNode(q.poll());
                limit.offer(new NodeWrap(n.right, n.val, nw.max));
            }            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));