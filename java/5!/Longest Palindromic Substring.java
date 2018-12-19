//Expand Around Center 
//Time: O(n^2) Space: O(1)
class Solution {
    String res="";
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) return "";
        for(int i=0;i<s.length();i++)
        {
            helper(s,i,i);
            helper(s,i,i+1);
        }
        return res;
    }
    public void helper(String s,int left,int right)
    {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
        {
            if(right-left+1>res.length()) res=s.substring(left,right+1);
            left--;
            right++;
        }
        
    }
}

//dp
//Time: O(n^2) Space: O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) return "";
        String res="";
        boolean[][] d=new boolean[s.length()][s.length()];
        for(int j=0;j<s.length();j++)
        {
            for(int i=0;i<=j;i++)
            {
                d[i][j]=(s.charAt(i)==s.charAt(j))&&(j-i<=2||d[i+1][j-1]);
                if(d[i][j]==true&&j-i+1>res.length())
                {
                    res=s.substring(i,j+1);
                }
            }
        }
        return res;
    }
}

// Brute Force
class Solution {
    public String longestPalindrome(String s) {
        int maxlength=0;
        String maxpa="";
        int pa;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                pa=1;
                for(int k=i;k<=(i+j)/2;k++)
                {
                    if(s.charAt(k)!=s.charAt(j-k+i))
                    {
                        pa=0;
                        break;
                    }
                }
                if(pa==1)
                {
                    if(j-i+1>maxlength)
                    {
                        maxlength=j-i+1;
                        maxpa=s.substring(i,j+1);
                    }
                }
            }
        }
        return maxpa;
    }
}