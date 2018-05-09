class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;
        Set set = new HashSet();
        for (int i=0;i<s.length();i++)
        {
            set.add(s.charAt(i));
            set.add(t.charAt(i));
        }
        int []s_cnt=new int[set.size()];
        int []t_cnt=new int[set.size()];
        int c=0;
        Iterator<Character> iter = set.iterator();  
        while(iter.hasNext())
        {
            char iternext=iter.next();
            s_cnt[c]=0;
            t_cnt[c]=0;
            for (int j=0;j<s.length();j++)
            {
                if (s.charAt(j)==iternext)
                    s_cnt[c]=s_cnt[c]+1;                  
                if (t.charAt(j)==iternext)
                    t_cnt[c]=t_cnt[c]+1;
            }
            c=c+1;
        }
        if(s_cnt.equals(t_cnt))
            return true;
        else 
            return false;
    }
}
