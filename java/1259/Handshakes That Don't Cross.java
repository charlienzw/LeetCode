class Solution {
    public int numberOfWays(int num_people) {
        if (num_people == 2) return 1;
        int M = 1000000007;
        long[] dp = new long[num_people / 2 + 1];
        dp[0] = 1;
        for (int i = 1; i <= num_people / 2; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = (dp[i] + (dp[j] * dp[i - j - 1]) % M) % M;
            }
        }
        
        return (int)dp[num_people / 2];
    }
}