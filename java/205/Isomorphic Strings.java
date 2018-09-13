class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,List<Integer>> maps=new HashMap<>();
        List<Integer> temp;
        for(int i=0;i<s.length();i++)
        {
            if(!maps.containsKey(s.charAt(i)))
            {
                temp=new ArrayList<>();
                temp.add(i);
                maps.put(s.charAt(i),temp);
            }
            else
            {
                temp=maps.get(s.charAt(i));
                temp.add(i);
                maps.put(s.charAt(i),temp);
            }
        }
        HashSet<List<Integer>> sets=new HashSet<>();
        Iterator<Character> iters=maps.keySet().iterator();
        while(iters.hasNext())
        {
            sets.add(maps.get(iters.next()));
        }
        HashMap<Character,List<Integer>> mapt=new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            if(!mapt.containsKey(t.charAt(i)))
            {
                temp=new ArrayList<>();
                temp.add(i);
                mapt.put(t.charAt(i),temp);
            }
            else
            {
                temp=mapt.get(t.charAt(i));
                temp.add(i);
                mapt.put(t.charAt(i),temp);
            }
        }   
        HashSet<List<Integer>> sett=new HashSet<>();
        Iterator<Character> itert=mapt.keySet().iterator();
        while(itert.hasNext())
        {
            sett.add(mapt.get(itert.next()));
        }
        return sets.equals(sett);
    }
}