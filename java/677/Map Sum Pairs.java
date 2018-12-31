class MapSum {
    class TrieNode{
        HashMap<Character, TrieNode> map = new HashMap<>();
        int val = 0;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        root=new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode p = root;
        for(int i = 0; i < key.length(); i++)
        {
            if(!p.map.containsKey(key.charAt(i)))
            {
                p.map.put(key.charAt(i), new TrieNode());
            }
            p = p.map.get(key.charAt(i));
        }
        p.val = val;
    }
    
    public int sum(String prefix) {
        TrieNode p=root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!p.map.containsKey(prefix.charAt(i)))
            {
                return 0;
            }
            p=p.map.get(prefix.charAt(i));
        }
        return sumhelper(p);
    }
    public int sumhelper(TrieNode p)
    {
        Set<Character> set = p.map.keySet();
        Iterator<Character> iter = set.iterator();
        int s = p.val;
        while(iter.hasNext())
        {
            s = s + sumhelper(p.map.get(iter.next()));
        }
        return s;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */