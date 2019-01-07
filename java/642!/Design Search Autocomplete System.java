
public class AutocompleteSystem {
    class TrieNode{
            Map<Character, TrieNode> children = new HashMap<>();
            String str = "";
            int times = 0;
    }
    class Trie {    
        TrieNode root = new TrieNode();        
        public void insert(String s, int times)
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
            cur.times += times;
            cur.str = s;
        }
        
        public List<TrieNode> find(String s)
        {
            List<TrieNode> list = new ArrayList<>();
            TrieNode cur = root;
            for(int i = 0; i < s.length(); i++)
            {
                if(!cur.children.containsKey(s.charAt(i)))
                {
                    return new ArrayList<>();
                }
                cur = cur.children.get(s.charAt(i));
            }
            traverse(s, cur, list);
            return list;
        }
        
        public void traverse(String s, TrieNode cur, List<TrieNode> list)
        {
            if(cur.times > 0) list.add(cur);
            Iterator<Character> iter = cur.children.keySet().iterator();
            while(iter.hasNext())
            {
                char temp = iter.next();
                traverse(s + temp, cur.children.get(temp), list);
            }
        }
    }
    
    Trie tree;
    String curstr = "";
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        tree = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            tree.insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') { 
            tree.insert(curstr, 1);
            curstr = "";
        } 
        else 
        {
            curstr = curstr + c;
            List<TrieNode> list = tree.find(curstr);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.str.compareTo(b.str) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++)
                res.add(list.get(i).str);
        }
        return res;
    }
}       