//Single
class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val)
        {
            this.val = val;
        }
    }
    ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode cur = head;
        for(int i = 0; i <= index; i++)
        {
            cur = cur.next;
            if (cur == null) return -1;
        }
        return cur.val;

    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head.next;
        head.next = temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        for(int i = 0; i < index; i++)
        {
            cur = cur.next;
            if (cur == null) return;
        }
        ListNode temp = new ListNode(val);
        temp.next = cur.next;
        cur.next = temp;            
    }

    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode cur = head;
        for(int i = 0; i < index; i++)
        {
            cur = cur.next;
        }
        if(cur.next != null) cur.next = cur.next.next;

    }
}


//Doubly
class MyLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int val)
        {
            this.val = val;
        }
    }
    ListNode head;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new ListNode(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode cur = head.next;
        for(int i = 0; i < index; i++)
        {
            if(cur != null)
                cur = cur.next;
            else return -1;
        }
        if(cur != null) return cur.val;
        else return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head.next;
        temp.prev = head;
        if(head.next != null)head.next.prev = temp;
        head.next = temp;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = head;
        while(cur.next != null)
        {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        cur.next.prev = cur;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        for(int i = 0; i < index; i++)
        {
            if(cur != null)
                cur = cur.next;
            else
                return;
        }
        if(cur != null)
        {
            ListNode temp = new ListNode(val);
            temp.next = cur.next;
            temp.prev = cur;
            if(cur.next != null) cur.next.prev = temp;
            cur.next = temp;            
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode cur = head;
        for(int i = 0; i < index; i++)
        {
            if(cur != null)
                cur = cur.next;
            else
                return;
        }
        if(cur.next != null)
        {
            if(cur.next.next != null) cur.next.next.prev = cur;
            cur.next = cur.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */