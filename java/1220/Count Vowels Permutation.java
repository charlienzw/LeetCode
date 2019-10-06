class Solution {
    public int countVowelPermutation(int n) {
        int m = 1000000007;
        int[][] vowelMap = new int[][] {
            {0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0}
        };
        
        long[][] dp = new long[n][5];
        dp[0] = new long[] {1, 1, 1, 1, 1};
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][k] = (dp[i][k] % m + ((dp[i - 1][j] % m) * (vowelMap[j][k] % m)) % m) % m;
                }
            }
        }
        
        return (int)((dp[n - 1][0] % m + dp[n - 1][1] % m + dp[n - 1][2] % m + dp[n - 1][3] % m + dp[n - 1][4] % m) % m);
    }
}