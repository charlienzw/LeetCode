class Solution {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + 1];
        for (int i = K; i <= N; i++) {
            dp[i] = 1;
        }
        
        double s = Math.min(N - K + 1, W);
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = s / W;
            s = s + dp[i] - (i + W > N ? 0 : dp[i + W]);
        }
        
        return dp[0];
    }
}