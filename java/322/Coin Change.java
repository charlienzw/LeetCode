/*
[1, 2, 5] 11
dp: 1 1 2 2 1 2 2 3 3 2 3

[2] 3
dp: -1 1 
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 0; i < dp.length; i++)
        {
            if(dp[i] == -1) continue;
            for(int j = 0; j < coins.length; j++)
            {
                if((long)i + (long)coins[j] > amount) continue;
                dp[i + coins[j]] = dp[i + coins[j]] == -1 ? dp[i] + 1 : Math.min(dp[i + coins[j]], dp[i] + 1);
            }
        }
        return dp[amount];
    }
}