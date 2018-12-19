//Recursive
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
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res)
    {
        if(root != null)
        {
            res.add(root.val);
            if(root.children != null)
            {
                for(int i = 0; i < root.children.size(); i++)
                {
                    helper(root.children.get(i), res);
                }
            }
        }
    }
}

//Iterative with one stack
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
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> s = new ArrayDeque<>();
        s.push(root);
        while(s.size() > 0)
        {
            root = s.pop();
            res.add(root.val);
            if(root.children != null)
            {
                for(int i = root.children.size() - 1; i >= 0; i--)
                {
                    s.push(root.children.get(i));
                }
            }
        }
        return res;
    }
}