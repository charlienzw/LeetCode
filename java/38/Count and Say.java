class Solution {
    public String countAndSay(int n) {
        String result="";
        if (n==1)
            result="1";
        else if (n==2)
            result="11";
        else
        {
            String s=countAndSay(n-1);
            int cnt=1;
            char c=s.charAt(0);
            for (int i=1;i<s.length();i++)
            {
                if (i==s.length()-1)
                {
                    if(s.charAt(i)==c)
                    {
                        cnt=cnt+1;
                        result=result+String.valueOf(cnt)+c;
                    }
                    else
                    {
                        result=result+String.valueOf(cnt)+c+"1"+s.charAt(i);
                    }  
                }
                else if(s.charAt(i)==c)
                {
                    cnt++;
                }
                else 
                {
                    result=result+String.valueOf(cnt)+c;
                    cnt=1;
                    c=s.charAt(i);
                }
            }
        }
        return result;
    }
}