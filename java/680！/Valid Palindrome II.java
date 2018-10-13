class Solution {
    public boolean validPalindrome(String s) {
        int j;
        for(int i=0;i<s.length()/2;i++)
        {
            j=s.length()-1-i;
            if(s.charAt(i)!=s.charAt(j))
            {
                return helper(s,i+1,j)||helper(s,i,j-1);
            }
        }
        return true;
    }
    public boolean helper(String s,int i,int j)
    {
        for(int k=0;k<=(j-i)/2;k++)
        {
            if(s.charAt(i+k)!=s.charAt(j-k)) return false;
        }
        return true;
    }
}