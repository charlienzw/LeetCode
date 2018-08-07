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