class Solution {
    class Trie{
        class TrieNode{
            Map<Character, TrieNode> children = new HashMap<>();
            String word;
        }
        
        TrieNode root = new TrieNode();
        
        public void insert(String s)
        {
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++)
            {
                if(!cur.children.containsKey(s.charAt(i)))
                {
                    cur.children.put(s.charAt(i), new TrieNode());
                }
                cur = cur.children.get(s.charAt(i));
            }
            cur.word = s;
        }
        
        public List<String> startwithall(String s)
        {
            List<String> res = new ArrayList<>();
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++)
            {
                if(!cur.children.containsKey(s.charAt(i)))
                {
                    return res;
                }
                cur = cur.children.get(s.charAt(i));
            }   
            if(cur.word != null) res.add(cur.word);
            helper(res, cur);
            return res;
        }
        
        public void helper(List<String> res, TrieNode cur)
        {
            Iterator<Character> iter = cur.children.keySet().iterator();
            while(iter.hasNext())
            {
                TrieNode next = cur.children.get(iter.next());
                if(next.word != null) res.add(next.word);
                helper(res, next);
            }
        }
        
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words == null || words.length == 0) return res;
        int len = words[0].length();
        Trie t = new Trie();
        for(int i = 0; i < words.length; i++)
        {
            t.insert(words[i]);
        }
        dfs(len, t, new ArrayList<>(), res);
        return res;
    }
    
    public void dfs(int len, Trie t, List<String> temp, List<List<String>> res)
    {
        if(temp.size() == len)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        //The next word's prefix must satisfy this.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.size(); i++)
        {
            sb.append(temp.get(i).charAt(temp.size()) + "");
        }
        
        List<String> list = t.startwithall(sb.toString());
        for(int i = 0; i < list.size(); i++)
        {
            temp.add(list.get(i));
            dfs(len, t, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}