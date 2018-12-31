class Solution {
    class TrieNode{
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isword;
    }
    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root=new TrieNode();
        for(int i = 0; i < dict.size(); i++)
        {
            insert(root, dict.get(i));
        }
        TrieNode p = root;
        String[] stringset = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stringset.length; i++)
        {
            stringset[i] = replace(root,stringset[i]);
            sb.append(stringset[i]);
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0, res.length() - 1);
    }
    public void insert(TrieNode root, String s)
    {
        TrieNode p = root;
        for(int i = 0; i < s.length(); i++)
        {
            if(!p.map.containsKey(s.charAt(i)))
            {
                p.map.put(s.charAt(i), new TrieNode());
            }
            p = p.map.get(s.charAt(i));
        }
        p.isword = true;
    }
    public String replace(TrieNode root, String s)
    {
        TrieNode p = root;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            if(!p.map.containsKey(s.charAt(i)))
            {
                return s;
            }
            p = p.map.get(s.charAt(i));
            sb.append(s.charAt(i));
            if(p.isword) return sb.toString();
        }
        return s;      
    }
}