/*
    leftNum: the number of nodes in the left tree
    nodeNum: the number of nodes in the current tree
    preIndex: current tree should starts from preIndex in preorder
    postIndex: current tree should starts from postIndex in postorder
    preorder: root, [leftTree], [rightTree]
    postorder: [leftTree], [rightTree], root
    So left tree's root should be,
        preorder[1]
    Or,
        postorder[leftNum - 1]
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(0, 0, pre.length, pre, post);
    }
    
    private TreeNode helper(int preIndex, int postIndex, int nodeNum, int[] pre, int[] post) {
        if (nodeNum == 0) return null;
        TreeNode root = new TreeNode(pre[preIndex]);
        if (nodeNum == 1) return root;
        
        int leftNum = 1;
        while (leftNum < nodeNum) {
            if (post[postIndex + leftNum - 1] == pre[preIndex + 1]) {
                break;
            }
            leftNum++;
        }
        root.left = helper(preIndex + 1, postIndex, leftNum, pre, post);
        root.right = helper(preIndex + leftNum + 1, postIndex + leftNum, nodeNum - 1 - leftNum, pre, post);
        return root;
    }
}