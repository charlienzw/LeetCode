/*
l e e t c o d e
0 1 1 2 3 4 5 5
  0 0 1 2 3 4 4
    0 1 2 3 4 3
      0 1 2 3 4
        0 1 2 3
          0 1 2
            0 1
              0
*/
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int j = 1; j <= n - 1; j++) {
            for (int i = 0; i < n - j; i++) {
                if (s.charAt(i) == s.charAt(i + j)) {
                    dp[i][i + j] = dp[i + 1][i + j - 1];
                } else {
                    dp[i][i + j] = Math.min(dp[i + 1][i + j], dp[i][i + j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }
}