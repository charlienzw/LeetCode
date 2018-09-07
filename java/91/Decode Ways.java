class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        int[] dp=new int[s.length()+1];
        dp[0]=0;
        if(s.charAt(0)!='0') dp[1]=1;
        else dp[1]=0;
        if(s.length()==1) return dp[1];
        if(s.charAt(1)!='0'&&(s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)<='6'))
            dp[2]=2;
        else if(s.charAt(1)!='0') dp[2]=dp[1];
        else if(s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)<='6') dp[2]=1;
        else dp[2]=0;
        for(int i=3;i<=s.length();i++)
        {
            if(s.charAt(i-1)!='0'&&(s.charAt(i-2)=='1'||s.charAt(i-2)=='2'&&s.charAt(i-1)<='6'))
            {
                dp[i]=dp[i-1]+dp[i-2];
            }
            else if(s.charAt(i-1)!='0')
            {
                dp[i]=dp[i-1];
            }
            else if(s.charAt(i-2)=='1'||s.charAt(i-2)=='2'&&s.charAt(i-1)<='6')
            {
                dp[i]=dp[i-2];
            }
            else
            {
                dp[i]=0;
            }
        }
        return dp[s.length()];
    }
}