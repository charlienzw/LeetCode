class Solution {
    class Trie{
        class TrieNode
        {
            HashMap<Character,TrieNode> map=new HashMap<>();
            List<List<Integer>> index_pos=new ArrayList<>();
            int isword=-1;
        }
        private TrieNode root;
        Trie()
        {
            root=new TrieNode();
        }
        public void insert(String s,int i)
        {
            TrieNode p=root;
            List<Integer> temp;
            for(int j=0;j<s.length();j++)
            {
                if(!p.map.containsKey(s.charAt(j)))
                {
                    p.map.put(s.charAt(j),new TrieNode());
                }
                p=p.map.get(s.charAt(j));
                temp=new ArrayList<>();
                temp.add(i);
                temp.add(j);
                p.index_pos.add(temp);
            }
            p.isword=i;
        }
        public List<Integer> helper(String s,String[] words)
        {
            List<Integer> res=new ArrayList<>();
            TrieNode p=root;
            int j;
            for(j=s.length()-1;j>=0;j--)
            {
                if(!p.map.containsKey(s.charAt(j)))
                {
                    return res;
                }
                p=p.map.get(s.charAt(j));
                if(p.isword>=0)
                {
                    if(ispa(s,0,j-1))
                    {
                        res.add(p.isword);
                    }
                }
            }
            String str;
            for(int i=0;i<p.index_pos.size();i++)
            {
                if(ispa(words[(int)p.index_pos.get(i).get(0)],(int)p.index_pos.get(i).get(1)+1,words[(int)p.index_pos.get(i).get(0)].length()-1))
                    res.add((int)p.index_pos.get(i).get(0));
            }
            return res;
        }
        public boolean ispa(String s,int low,int high)
        {
            if(low==high+1) return true;
            if(low>high+1) return false;
            for(int j=low;j<=low+(high-low)/2;j++)
            {
                if(s.charAt(j)!=s.charAt(high-j+low)) return false;
            }
            return true;
        }
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        Set<List<Integer>> resset=new HashSet<>();
        List<List<Integer>> res=new ArrayList<>();
        if(words.length==0) return res;
        int[] pa=new int[words.length];
        Trie t=new Trie();
        int emptyi=-1;
        List<Integer> temp;
        List<Integer> list;
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()==0)
            {
                emptyi=i;
            }
            else
            {
                if(t.ispa(words[i],0,words[i].length()-1)) pa[i]=1;
                else pa[i]=0;
            }
        }
        if(emptyi!=-1)
        {
            for(int i=0;i<words.length;i++)
            {
                if(pa[i]==1)
                {
                    temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(emptyi);
                    resset.add(temp);
                    temp=new ArrayList<>();
                    temp.add(emptyi);
                    temp.add(i);
                    resset.add(temp);                    
                }
            }
        }
        for(int i=0;i<words.length;i++)
        {
            t.insert(words[i],i);
        }
        for(int i=0;i<words.length;i++)
        {
            temp=t.helper(words[i],words);
            for(int j=0;j<temp.size();j++)
            {
                if(temp.get(j)!=i)
                {
                    list=new ArrayList<>();
                    list.add(temp.get(j));
                    list.add(i);
                    resset.add(list);
                }
            }
        }
        Iterator<List<Integer>> iter=resset.iterator();
        while(iter.hasNext())
        {
            res.add(iter.next());
        }
        return res;
    }
}