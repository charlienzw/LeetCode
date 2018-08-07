class Solution {
    public boolean isPalindrome(String s) {
        List<Character> C=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(alnu(s.charAt(i))) C.add(s.charAt(i));
        }
        if(C.size()==0) return true;
        for(int i=0;i<=(C.size()-1)/2;i++)
        {
            if(!eq(C.get(i),C.get(C.size()-1-i))) return false;
        }
        return true;
        
    }
    public boolean alnu(char c)
    {
        if(c>='a'&&c<='z'||c>='A'&&c<='Z'||c>='0'&&c<='9') return true;
        else return false;
    }
    public boolean eq(char c1,char c2)
    {
        if(c1==c2) return true;
        if(c1>='A'&&c1<='Z'&&c2>='a'&&c2<='z')
        {
            if(c1+32==c2) return true;
        }
        if(c1>='a'&&c1<='z'&&c2>='A'&&c2<='Z')
        {
            if(c1-32==c2) return true;
        }
        return false;
    }
}