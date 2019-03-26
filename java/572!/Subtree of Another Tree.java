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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t);
    }
    
    public boolean helper(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || helper(s.left, t) || helper(s.right, t));
    }
    
    public boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }
}

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Set<String> serializedSubS = new HashSet<>();
        serializeSubtree(s, serializedSubS);
        return serializedSubS.contains(serializeTree(t));
    }
    
    public void serializeSubtree(TreeNode s, Set<String> serializedSubS) {
        if(s != null) {
            serializedSubS.add(serializeTree(s));
            serializeSubtree(s.left, serializedSubS);
            serializeSubtree(s.right, serializedSubS);
        }
    }
    
    public String serializeTree(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(t, sb);
        return sb.toString();
    }
    
    public void serializeHelper(TreeNode t, StringBuilder sb) {
        if(t == null) {
            sb.append("#");
        } else {
            sb.append(t.val);
            serializeHelper(t.left, sb);
            serializeHelper(t.right, sb);
        }
    }
}