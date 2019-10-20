class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        
        
        int[][] dp = new int[matrix.length][matrix[0].length];
        if (matrix[0][0] == '1') {
            dp[0][0] = 1;
            res = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    res = Math.max(res, dp[i][j] * dp[i][j]);
                }
            }
        }
        return res;
    }
}