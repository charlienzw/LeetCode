class Solution {
    public boolean isMatch(String s, String p) {
        while(s==null||p==null) return false;
        boolean[][] d=new boolean[s.length()+1][p.length()+1];
        d[0][0]=true;
        for(int i=0;i<p.length();i++)
        {
            if(p.charAt(i)=='*'&&d[0][i-1])
            {
                d[0][i+1]=true;
            }
        }
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<p.length();j++)
            {
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')
                {
                    d[i+1][j+1]=d[i][j];
                }
                else if(p.charAt(j)=='*')
                {
                    if(s.charAt(i)!=p.charAt(j-1)&&p.charAt(j-1)!='.')
                    {
                        d[i+1][j+1]=d[i+1][j-1];
                    }
                    else
                    {
                        d[i+1][j+1]=d[i+1][j]||d[i][j+1]||d[i+1][j-1];
                    }
                }
            }
        }
        return d[s.length()][p.length()];
    }
}