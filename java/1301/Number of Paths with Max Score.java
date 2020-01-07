class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int M = 1000000007;
        int m = board.size(), n = board.get(0).length();
        int[][] dp = new int[m][n];
        long[][] count = new long[m][n];
        dp[m - 1][n - 1] = 0;
        count[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            if (board.get(i).charAt(n - 1) == 'X' || dp[i + 1][n - 1] == -1) {
                dp[i][n - 1] = -1;
                count[i][n - 1] = 0;
            } else {
                dp[i][n - 1] = (board.get(i).charAt(n - 1) - '0') + dp[i + 1][n - 1];
                count[i][n - 1] = 1;
            }
        }
        for (int j = n - 2; j >= 0; j--) {
            if (board.get(m - 1).charAt(j) == 'X' || dp[m - 1][j + 1] == -1) {
                dp[m - 1][j] = -1;
                count[m - 1][j] = 0;
            } else {
                dp[m - 1][j] = ((board.get(m - 1).charAt(j) - '0') + dp[m - 1][j + 1]);
                count[m - 1][j] = 1;
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int maxPre = Math.max(dp[i + 1][j], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
                if (board.get(i).charAt(j) == 'X' || maxPre == -1) {
                    dp[i][j] = -1;
                    count[i][j] = 0;
                } else {
                    dp[i][j] = (board.get(i).charAt(j) == 'E' ? 0 : (board.get(i).charAt(j) - '0')) + maxPre;
                    if (maxPre == dp[i + 1][j]) {
                        count[i][j] += count[i + 1][j];
                    }
                    if (maxPre == dp[i][j + 1]) {
                        count[i][j] += count[i][j + 1];
                    }
                    if (maxPre == dp[i + 1][j + 1]) {
                        count[i][j] += count[i + 1][j + 1];
                    }
                    count[i][j] = count[i][j] % M;
                }
            }
        }
        if (count[0][0] == 0) return new int[] {0, 0};
        else return new int[] {dp[0][0], (int)(count[0][0] % M)};
    }
}