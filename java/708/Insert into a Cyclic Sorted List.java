class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null)
        {
            Node res = new Node(insertVal, null);
            res.next = res;
            return res;
        }
        Node cur = head;
        Node maxnode = head;
        int maxval = head.val;
        Node next;
        while(true)
        {
            if(insertVal >= cur.val && insertVal <= cur.next.val)
            {
                next = cur.next;
                cur.next = new Node(insertVal, next);
                return head;
            }
            cur = cur.next;
            if(cur.val >= maxval)
            {
                maxval = cur.val;
                maxnode = cur;
            }
            if(cur == head) break;
        }
        next = maxnode.next;
        maxnode.next = new Node(insertVal, next);
        return head;
    }
}
