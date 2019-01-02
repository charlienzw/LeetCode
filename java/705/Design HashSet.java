class MyHashSet {
    List<LinkedList<Integer>> set; 
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new ArrayList<>();
        for(int i = 0; i < 1000; i++)
        {
            set.add(new LinkedList<>());
            set.get(i).add(-1);
        }
    }
    
    public void add(int key) {
        LinkedList<Integer> list = set.get(key % 1000);
        if(!list.contains(key)) list.add(key);
    }
    
    public void remove(int key) {
        LinkedList<Integer> list = set.get(key % 1000);
        int index = list.indexOf(key);
        if(index != -1) list.remove(index);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        LinkedList<Integer> list = set.get(key % 1000);
        return list.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */