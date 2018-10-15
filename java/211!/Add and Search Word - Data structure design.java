class WordDictionary {
    class TrieNode
    {
        HashMap<Character,TrieNode> map=new HashMap<>();
        boolean isword;
    }
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root=new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p=root;
        for(int i=0;i<word.length();i++)
        {
            if(!p.map.containsKey(word.charAt(i)))
            {
                p.map.put(word.charAt(i),new TrieNode());
            }
            p=p.map.get(word.charAt(i));
        }
        p.isword=true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode q=root;
        return helper(word,q,0);
    }
    public boolean helper(String word,TrieNode q,int cur)
    {
        TrieNode p=q;
        for(int i=cur;i<word.length();i++)
        {
            if(!p.map.containsKey(word.charAt(i))&&word.charAt(i)!='.')
            {
                return false;
            }
            if(word.charAt(i)=='.')
            {
                for(char j='a';j<='z';j++)
                {
                    if(p.map.containsKey(j))
                    {
                        if(helper(word,p.map.get(j),i+1)) return true;
                    }
                }
                return false;
            }
            p=p.map.get(word.charAt(i));
        }
        return p.isword;       
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */