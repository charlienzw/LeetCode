class Solution {
    public boolean isNumber(String s) {
        boolean start=false;
        boolean end=false;
        boolean point=false;
        boolean e=false;
        boolean valid=false;
        for(int i=0;i<s.length();i++)
        {
            if(!(s.charAt(i)>='0'&&s.charAt(i)<='9')&&s.charAt(i)!='.'&&s.charAt(i)!='e'&&s.charAt(i)!=' '&&s.charAt(i)!='-'&&s.charAt(i)!='+')
                return false;
            if(!start&&!end)
            {
                if(s.charAt(i)>='0'&&s.charAt(i)<='9'||s.charAt(i)=='.'||s.charAt(i)=='-'||s.charAt(i)=='+')
                {
                    start=true;
                    if(s.charAt(i)>='0'&&s.charAt(i)<='9') valid=true;
                    else if(s.charAt(i)=='.') point=true;
                }
                else if(s.charAt(i)!=' ') return false;
            }
            else if(start&&!end)
            {
                if(s.charAt(i)=='.')
                {
                    if(e) return false;
                    if(!point) point=true;
                    else return false;
                }
                if((s.charAt(i)=='-'||s.charAt(i)=='+')&&s.charAt(i-1)!='e') return false;
                if(s.charAt(i)=='e')
                {
                    if(!valid) return false;
                    if(!e) e=true;
                    else return false;
                    if(i==s.length()-1||s.charAt(i+1)==' '||s.charAt(i+1)=='.') return false;
                }  
                if(s.charAt(i)==' ')
                {
                    if(s.charAt(i-1)!='e'&&s.charAt(i)!='-'&&s.charAt(i)!='-')
                    {
                        end=true;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(s.charAt(i)>='0'&&s.charAt(i)<='9') valid=true;
            }
            else
            {
                if(s.charAt(i)!=' ')
                    return false;
            }
        }
        if(s.charAt(s.length()-1)=='e'||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='-') return false;
        return valid;
    }
}