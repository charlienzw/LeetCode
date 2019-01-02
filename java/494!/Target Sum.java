/*
dp
[1, 1, 1, 1, 1], S is 3
dp: [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
meaning:
dp[0]: time of -1-1-1-1-1
dp[sum]: time of 0
dp[2 * sum - 1]: times of +1+1+1+1+1
Initially, dp[sum] = 1.
Then in loop, j + nums[i] and j - nums[i] should be updated
dp[sum + S] is the time of S

*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
        }
        if(S > sum || S < -sum) return 0;
        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;
        for(int i = 0; i < nums.length; i++)
        {
            int[] next = new int[2 * sum + 1];
            for(int j = 0; j < 2 * sum + 1; j++)
            {
                if(dp[j] != 0)
                {
                    next[j + nums[i]] += dp[j];
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        return dp[sum + S];
    }   
}