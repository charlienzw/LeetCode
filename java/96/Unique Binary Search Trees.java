class Solution {
    public int numTrees(int n) {
        // Different root:
        // root is i: dp[i-1]
        // root is 1: dp[i-1]
        // root is other: dp[leftsize]*dp[rightsize] (leftsize+rightsize=i-1)
        if(n<=2) return n;
        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=2;
        int temp;
        for(int i=2;i<n;i++)
        {
            temp=0;
            for(int j=i-2;j>=0;j--)
                temp=temp+dp[j]*dp[i-2-j];
            dp[i]=2*dp[i-1]+temp;
        }
        return dp[n-1];
    }
}