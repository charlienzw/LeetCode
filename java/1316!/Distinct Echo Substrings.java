class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> set = new HashSet<>();
        int n = text.length();
        int[][] dp = new int[n][n];
        for (int j = n - 1; j >= 1; j--) {
            for (int i = j - 1; i >= 0; i--) {
                if (text.charAt(i) == text.charAt(j)) {
                    dp[i][j] = (j == n - 1 ? 0 : dp[i + 1][j + 1]) + 1;
                }
                if (dp[i][j] >= j - i) set.add(text.substring(i, 2 * j - i));
            }
        }
        return set.size();
    }
}