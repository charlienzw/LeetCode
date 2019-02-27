class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublyLinkedList {
    ListNode head;
    ListNode tail;
    DoublyLinkedList() {
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    void addFirst(ListNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }
    
    void moveToFirst(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addFirst(node);
    }
    
    ListNode removeLast() {
        ListNode last = tail.prev;
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        return last;
    }
}

/*
get:
    contain?
        move to first, return
    else
        -1
put:
    contain?
        update, move to first
    else
        add first, add to map, remove last, remove last from map
*/
class LRUCache {
    Map<Integer, ListNode> map;
    DoublyLinkedList list;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoublyLinkedList();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        list.moveToFirst(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            list.moveToFirst(map.get(key));
        }
        else {
            ListNode newNode = new ListNode(key, value);
            list.addFirst(newNode);
            map.put(key, newNode);
            if(map.keySet().size() > capacity) {
                ListNode last = list.removeLast();
                map.remove(last.key);
            }            
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */