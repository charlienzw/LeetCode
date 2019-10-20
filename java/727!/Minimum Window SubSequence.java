class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        
        // Largest start index of subsequence
        int[][] dp = new int[m][n];
        // When T is empty, the start index of S is i + 1
        for (int i = 0; i < m; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i == 0 ? -1 : dp[i - 1][0];
            }
        }
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = i == 0 ? -1 : dp[i - 1][j - 1];
                } else {
                    dp[i][j] = i == 0 ? -1 : dp[i - 1][j]; // If they are not equal, borrow the index without current character in S
                }
            }
        }
        
        int start = 0, len = m + 1;
        for (int i = 0; i < m; i++) {
            if (dp[i][n - 1] != -1) { // If dp != -1, it has subsequence
                if (i - dp[i][n - 1] + 1 < len) {
                    start = dp[i][n - 1];
                    len = i - dp[i][n - 1] + 1;
                }
            }
        }
        return len == m + 1 ? "" : S.substring(start, start + len);
    }
}