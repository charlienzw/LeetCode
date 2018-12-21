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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public void helper(Node root, List<Integer> res)
    {
        if(root != null)
        {
            if(root.children != null)
            {
                for(int i = 0; i < root.children.size(); i++)
                {
                    helper(root.children.get(i), res);
                }
            }
            res.add(root.val);
        }      
    }
}

//Iterative with two stacks
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
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<Integer>();
        Deque<Node> s = new ArrayDeque<>();
        if(root == null) return res;
        s.push(root);
        while(s.size() > 0)
        {
            root = s.pop();
            res.addFirst(root.val);
            if(root.children != null)
            {
                for(int i = 0; i < root.children.size(); i++)
                {
                    s.push(root.children.get(i));
                }
            }
        }
        return res;     
    }
}