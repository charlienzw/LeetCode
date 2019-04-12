class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int dp1 = 1;
        int dp2 = 2;
        for(int i = 2; i <= n - 1; i++)
        {
            dp2 = dp1 + dp2;
            dp1 = dp2 - dp1;
        }
        return dp2;
    }
}