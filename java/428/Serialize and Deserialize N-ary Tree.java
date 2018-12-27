//Preorder
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    
    public void helper(Node root, StringBuilder sb)
    {
        if(root != null)
        {
            sb.append(root.val + ",");
            for(int i = 0; i < root.children.size(); i++)
            {
                helper(root.children.get(i), sb);
            }
            sb.append("#,");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        String[] dataArray = data.split(",");
        return dehelper(dataArray, new int[]{0});
    }
    
    public Node dehelper(String[] dataArray, int[] cur)
    {
        if(dataArray[cur[0]].equals("#"))
        {
            
            cur[0]++;
            return null;
        }
        else
        {
            List<Node> children = new ArrayList<>();
            int rootval = Integer.valueOf(dataArray[cur[0]]);
            cur[0]++;
            while(cur[0] < dataArray.length)
            {
                Node temp = dehelper(dataArray, cur);
                if(temp != null) children.add(temp);
                else break;
            }
            return new Node(rootval, children);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

//Postorder
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(root, sb);
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    
    public void helper(Node root, StringBuilder sb)
    {
        if(root != null)
        {
            sb.append("#,");
            for(int i = 0; i < root.children.size(); i++)
            {
                helper(root.children.get(i), sb);
            }
            sb.append(root.val + ",");
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) return null;
        String[] dataArray = data.split(",");
        return dehelper(dataArray, new int[]{dataArray.length - 1});
    }
    
    public Node dehelper(String[] dataArray, int[] cur)
    {
        if(dataArray[cur[0]].equals("#"))
        {
            
            cur[0]--;
            return null;
        }
        else
        {
            LinkedList<Node> children = new LinkedList<>();
            int rootval = Integer.valueOf(dataArray[cur[0]]);
            cur[0]--;
            while(cur[0] >= 0)
            {
                Node temp = dehelper(dataArray, cur);
                if(temp != null) children.addFirst(temp);
                else break;
            }
            return new Node(rootval, children);
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));