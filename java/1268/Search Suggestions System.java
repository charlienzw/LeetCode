class Trie {
    class TrieNode {
        Map<Character, TrieNode> children;
        int wordNum;
        public TrieNode() {
            children = new TreeMap<>();
            wordNum = 0;
        }
    }
    
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (!cur.children.containsKey(s.charAt(i))) {
                cur.children.put(s.charAt(i), new TrieNode());
            }
            cur = cur.children.get(s.charAt(i));
        }
        cur.wordNum++;
    }
    
    public List<String> getFirstThreeWithPrefix(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.children.containsKey(prefix.charAt(i))) {
                return new ArrayList<>();
            } else {
                cur = cur.children.get(prefix.charAt(i));
            }
        }
        List<String> res = new ArrayList<>();
        int[] k = new int[1];
        k[0] = 3;
        getFirstK(cur, k, new StringBuilder(prefix), res);
        return res;
    }
    
    private void getFirstK(TrieNode node, int[] k, StringBuilder sb, List<String> res) {
        if (k[0] == 0) return;
        for (int i = 0; i < node.wordNum; i++) {
            res.add(sb.toString());
            k[0]--;
            if (k[0] == 0) return;
        }
        for (Character key : node.children.keySet()) {
            sb.append(key);
            getFirstK(node.children.get(key), k, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        
        Trie t = new Trie();
        for (int i = 0; i < products.length; i++) {
            t.insert(products[i]);
        }
        
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(t.getFirstThreeWithPrefix(searchWord.substring(0, i + 1)));
        }
        
        return res;
    }
}