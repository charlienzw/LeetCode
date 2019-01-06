/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        return helper(head, null);

    }
    
    public Node helper(Node head, Node nextnode)
    {
        Node cur = head, pre = null, next;
        while(cur != null)
        {
            if(cur.child != null)
            {
                Node child = helper(cur.child, cur.next);
                cur.child = null;
                next = cur.next;
                cur.next = child;
                child.prev = cur;
                cur = next;
            }
            else
            {
                pre = cur;
                cur = cur.next;                
            }
        }
        if(pre != null) 
        {
            pre.next = nextnode;
            if(nextnode != null) nextnode.prev = pre;
        }
        return head;
    }
}