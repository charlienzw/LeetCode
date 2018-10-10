class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()==t.length())
        {
            int r=0;
            for(int i=0;i<s.length();i++)
            {
                 if(s.charAt(i)!=t.charAt(i)) r++;
            }
            if(r==1) return true;
            else return false;
        }
        else if(s.length()+1==t.length())
        {
            int i=0,j=0;
            while(i<s.length())
            {
                boolean flag=false;
                if(!flag&&s.charAt(i)!=t.charAt(j))
                {
                    if(j<t.length()-1&&s.charAt(i)==t.charAt(j+1))
                    {
                        flag=true;
                        j++;
                    }
                    else return false;
                }
                else if(flag&&s.charAt(i)!=t.charAt(j)) return false;
                i++;
                j++;
            }
            return true;
        }
        else if(t.length()+1==s.length())
        {
            return isOneEditDistance(t,s);
        }
        else
        {
            return false;
        }
    }
}