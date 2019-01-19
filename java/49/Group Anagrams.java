class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, Integer> H = new HashMap<>();
        HashMap<Character, Integer> hm;
        List<List<String>> res = new ArrayList<>();
        List<String> temp;
        int cur = 0;
        for(int i = 0; i < strs.length; i++)
        {
            hm = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++)
            {
                if(!hm.containsKey(strs[i].charAt(j)))
                {
                    hm.put(strs[i].charAt(j), 1);
                }
                else
                {
                    hm.put(strs[i].charAt(j), hm.get(strs[i].charAt(j)) + 1);
                }
            }
            if(!H.containsKey(hm))
            {
                H.put(hm,cur);
                cur++;
                temp = new ArrayList<>();
                temp.add(strs[i]);
                res.add(temp);
            }
            else
            {
                temp = res.get(H.get(hm));
                temp.add(strs[i]);
                res.set(H.get(hm),temp);
            }
        }
        return res;
    }
}