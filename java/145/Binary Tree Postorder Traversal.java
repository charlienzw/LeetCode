//Recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res)
    {
        if(root != null)
        {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }
}

//Iterative with two stacks
//Reverse the result of preorder traversal beginning from right
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<Integer>();
        Stack<TreeNode> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(s1.size()>0||root!=null)
        {
            if(root==null)
            {
                root=s1.pop();
                root=root.left;
            }
            else
            {
                s2.push(root.val);
                s1.push(root);
                root=root.right;
            }
        }
        while(s2.size()>0)
        {
            res.add(s2.pop());
        }
        return res;
    }
}

//Iterative with one stack
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class NodeContainer{
        TreeNode node;
        boolean visited;
        NodeContainer(TreeNode n, boolean flag)
        {
            node = n;
            visited = flag;
        }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<NodeContainer> s = new ArrayDeque<>();
        while(s.size() > 0 || root != null)
        {
            if(root != null)
            {
                s.push(new NodeContainer(root, false));
                root = root.left;   
            }
            else
            {
                NodeContainer nc = s.pop();
                root = nc.node;
                if(!nc.visited)
                {
                    nc.visited = true;
                    s.push(nc);
                    root = root.right;
                }
                else
                {
                    res.add(root.val);
                    root = null;
                }
            }
        }
        return res;
    }
}

//Iterative with O(1) space
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode dump = new TreeNode(0);
        dump.left = root;
        List<Integer> res = new ArrayList<>();
        TreeNode cur = dump, prev = null;
        while(cur != null)
        {
            if(cur.left == null)
            {
                cur = cur.right;
            }
            else
            {
                prev = cur.left;
                while(prev.right != null && prev.right != cur)
                {
                    prev = prev.right;
                }
                if(prev.right == null)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else
                {
                    printReverse(cur.left, prev, res);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
    
    private void printReverse(TreeNode start, TreeNode end, List<Integer> res)
    {
        List<Integer> temp = new ArrayList<>();
        while(start != end.right)
        {
            temp.add(start.val);
            start = start.right;
        }
        Collections.reverse(temp);
        for(int i : temp) res.add(i);
    }
}