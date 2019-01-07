class Solution {
    class Trie{
        class TrieNode{
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isword;
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
            cur.isword = true;
        }
        
        public boolean startwith(String s)
        {
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++)
            {
                if(!cur.children.containsKey(s.charAt(i)))
                {
                    return false;
                }
                cur = cur.children.get(s.charAt(i));
            }
            return true;        
        }

        public boolean find(String s)
        {
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++)
            {
                if(!cur.children.containsKey(s.charAt(i)))
                {
                    return false;
                }
                cur = cur.children.get(s.charAt(i));
            }
            return cur.isword;        
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie t = new Trie();
        for(int i = 0; i < words.length; i++)
        {
            t.insert(words[i]);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> resset = new HashSet<>();
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                if(t.startwith("" + board[i][j]))
                {
                    visited[i][j] = true;
                    dfs(board, t, i, j, "" + board[i][j], visited, resset);
                    visited[i][j] = false;
                }
                    
            }
        }
        List<String> res = new ArrayList<>();
        Iterator<String> iter = resset.iterator();
        while(iter.hasNext())
        {
            res.add(iter.next());
        }
        return res;
    }
    
    public void dfs(char[][] board, Trie t, int curi, int curj, String str, boolean[][] visited, Set<String> resset)
    {
        if(t.find(str))
        {
            resset.add(str);
        }
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < 4; i++)
        {
            int newi = curi + dir[i][0];
            int newj = curj + dir[i][1];
            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length && !visited[newi][newj] && t.startwith(str + board[newi][newj]))
            {
                visited[newi][newj] = true;
                dfs(board, t, newi, newj, str + board[newi][newj], visited, resset);
                visited[newi][newj] = false;
            }
        }
    }
    
}