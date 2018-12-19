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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        if(root == null) return res;
        q.add(root);
        int qsize;
        Node tempnode;
        List<Integer> templist;
        while(q.size() > 0)
        {
            qsize = q.size();
            templist = new ArrayList<>();
            for(int i = 0; i < qsize; i++)
            {
                tempnode = q.poll();
                templist.add(tempnode.val);
                if(tempnode.children != null)
                {
                    for(int j = 0; j < tempnode.children.size(); j++)
                    {
                        q.add(tempnode.children.get(j));
                    }
                }
            }
            res.add(templist);
        }
        return res;
    }
}