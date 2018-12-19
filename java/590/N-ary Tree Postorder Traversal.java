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
        List<Integer> res = new ArrayList<Integer>();
        Deque<Node> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        if(root == null) return res;
        s1.push(root);
        while(s1.size() > 0)
        {
            root = s1.pop();
            s2.push(root.val);
            if(root.children != null)
            {
                for(int i = 0; i < root.children.size(); i++)
                {
                    s1.push(root.children.get(i));
                }
            }
        }
        while(s2.size() > 0)
        {
            res.add(s2.pop());
        }
        return res;     
    }
}