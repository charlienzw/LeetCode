class Trie {
    class TrieNode{
        public boolean isword;
        public HashMap<Character, TrieNode> childrenmap = new HashMap<>();
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!p.childrenmap.containsKey(word.charAt(i)))
            {
                p.childrenmap.put(word.charAt(i), new TrieNode());
            }
            p = p.childrenmap.get(word.charAt(i));
        }
        p.isword = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(!p.childrenmap.containsKey(word.charAt(i)))
            {
                return false;
            }
            p = p.childrenmap.get(word.charAt(i));
        }  
        return p.isword;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            if(!p.childrenmap.containsKey(prefix.charAt(i)))
            {
                return false;
            }
            p = p.childrenmap.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */