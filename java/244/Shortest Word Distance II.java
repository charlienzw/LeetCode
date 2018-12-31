class WordDistance {
    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {
            if(!map.containsKey(words[i]))
            {
                map.put(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }
            else
            {
                map.get(words[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> index1 = map.get(word1);
        List<Integer> index2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int i1 = 0, i2 = 0;
        while(i1 < index1.size() && i2 < index2.size())
        {
            if(index1.get(i1) < index2.get(i2))
            {
                res = Math.min(res, index2.get(i2) - index1.get(i1));
                i1++;
            }
            else
            {
                res = Math.min(res, index1.get(i1) - index2.get(i2));
                i2++;                
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */