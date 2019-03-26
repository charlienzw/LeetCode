/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class TreeNode {
    Interval interval;
    TreeNode left;
    TreeNode right;
    TreeNode(Interval interval) {
        this.interval = interval;
    }
}

class BST {
    TreeNode root;
    
    BST(List<Interval> sortedIntervals) {
        root = createBSTHelper(sortedIntervals, 0, sortedIntervals.size() - 1);
    }
    
    TreeNode createBSTHelper(List<Interval> sortedIntervals, int low, int high) {
        if(low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(sortedIntervals.get(mid));
        node.left = createBSTHelper(sortedIntervals, low, mid - 1);
        node.right = createBSTHelper(sortedIntervals, mid + 1, high);
        return node;
    }
    
    void insert(Interval interval) {
        if(root == null) root = new TreeNode(interval);
        TreeNode cur = root;
        while(true) {
            if(interval.start <= cur.interval.start) {
                if(cur.left == null) {
                    cur.left = new TreeNode(interval);
                    return;
                } else {
                    cur = cur.left;
                }
            } else {
                if(cur.right == null) {
                    cur.right = new TreeNode(interval);
                    return;
                } else {
                    cur = cur.right;
                }
            }
        }
    }
    
    List<Interval> inOrderTraversal() {
        List<Interval> list = new ArrayList<>();
        inOrderTraversalHelper(root, list);
        return list;
    }
    
    void inOrderTraversalHelper(TreeNode cur, List<Interval> list) {
        if(cur != null) {
            inOrderTraversalHelper(cur.left, list);
            list.add(cur.interval);
            inOrderTraversalHelper(cur.right, list);
        }
    }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        BST bst = new BST(intervals); // O(n)
        bst.insert(newInterval); // O(logn)
        List<Interval> sortedIntervals = bst.inOrderTraversal(); // O(n)
        return mergeIntervals(sortedIntervals); // O(n)
    }
    
    public List<Interval> mergeIntervals(List<Interval> sortedIntervals) {
        List<Interval> res = new ArrayList<>();
        if(sortedIntervals.size() == 0) return res;
        int start = sortedIntervals.get(0).start;
        int end = sortedIntervals.get(0).end;
        int i = 0;
        while(i < sortedIntervals.size() - 1) {
            if(end < sortedIntervals.get(i + 1).start) {
                res.add(new Interval(start, end));
                start = sortedIntervals.get(i + 1).start;
                end = sortedIntervals.get(i + 1).end;
            } else {
                end = Math.max(end, sortedIntervals.get(i + 1).end);
            }
            i++;
        }
        res.add(new Interval(start, Math.max(end, sortedIntervals.get(sortedIntervals.size() - 1).end)));
        return res;
    }
}