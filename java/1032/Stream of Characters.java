class Trie {
    class TrieNode {
        Map<Character, TrieNode> childrenMap = new HashMap<>();
        boolean isWord = false;
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode cur = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!cur.childrenMap.containsKey(s.charAt(i))) {
                cur.childrenMap.put(s.charAt(i), new TrieNode());
            }
            cur = cur.childrenMap.get(s.charAt(i));
        }
        cur.isWord = true;
    }
    
    public boolean search(String s) {
        TrieNode cur = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (cur.childrenMap.get(s.charAt(i)) == null) return false;
            cur = cur.childrenMap.get(s.charAt(i));
            if (cur.isWord) return true;
        }
        return false;
    }
}

class StreamChecker {
    Trie t;    
    StringBuilder sb;
    public StreamChecker(String[] words) {
        t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i]);
        }
        sb = new StringBuilder();        
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return t.search(sb.toString());        
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */