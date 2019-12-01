class Solution {
    public int palindromePartition(String s, int k) {
        int[][] stepsToPalindrome = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            stepsToPalindrome[i][i] = 0;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            stepsToPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
        }
        for (int c = 2; c < s.length(); c++) {
            for (int i = 0; i < s.length() - c; i++) {
                stepsToPalindrome[i][i + c] = s.charAt(i) == s.charAt(i + c) ? stepsToPalindrome[i + 1][i + c - 1] : stepsToPalindrome[i + 1][i + c - 1] + 1;
            }
        }
        
        int[][] dp = new int[s.length()][k];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = s.length() + 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            dp[i][0] = stepsToPalindrome[0][i];
        }
        
        
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < k; j++) {
                if (j > i) continue;
                for (int c = 0; c < i; c++) {
                    dp[i][j] = Math.min(dp[i][j], dp[c][j - 1] + stepsToPalindrome[c + 1][i]);
                }
            }
        }
        return dp[s.length() - 1][k - 1];
    }
    
}