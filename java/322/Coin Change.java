/*
[1, 2, 5] 11
dp: 1 1 2 2 1 2 2 3 3 2 3

[2] 3
dp: -1 1 
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < coins.length; i++)
        {
            set.add(coins[i]);
        }
        
        int[] dp = new int[amount];
        int temp;
        for(int i = 1; i <= amount; i++)
        {
            if(set.contains(i))
            {
                dp[i - 1] = 1;
            }
            else
            {
                temp = -1;
                for(int j = 0; j < i / 2; j++)
                {
                    if(dp[j] != -1 && dp[i - 2 - j] != -1 && (temp == -1 || dp[j] + dp[i - 2 - j] < temp))
                    {
                        temp = dp[j] + dp[i - 2 - j];
                    }
                }
                dp[i - 1] = temp;
            }
        }
        return dp[amount - 1];
    }
}