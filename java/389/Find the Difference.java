//Bit manipulation
class Solution {
    public char findTheDifference(String s, String t) {
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            c=c^(int)s.charAt(i);
        }
        for(int i=0;i<t.length();i++)
        {
            c=c^(int)t.charAt(i);
        }
        return (char)c;
    }
}
//Hashing
class Solution {
    public char findTheDifference(String s, String t) {
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<s.length();i++) hs.add(s.charAt(i));
        Iterator<Character> iter=hs.iterator();
        HashMap<Character,Integer> hm=new HashMap<>();
        while(iter.hasNext())
        {
            char tmp=iter.next();
            int cnt=0;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)==tmp) cnt++; 
            }
            hm.put(tmp,cnt);
        }
        for(int i=0;i<t.length();i++)
        {
            if(hm.containsKey(t.charAt(i)))
            {
                if(hm.get(t.charAt(i))>1)
                    hm.put(t.charAt(i),hm.get(t.charAt(i))-1);
                else
                {
                    hm.remove(t.charAt(i));
                }
            }
            else return t.charAt(i);
        }
        return t.charAt(0);
    }
}