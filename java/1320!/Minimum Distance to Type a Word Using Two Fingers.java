/*
dp[i]: the last left is current character to save
    
*/
class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        int[] dp = new int[26];
        int res = 0, saved = 0;
        for (int i = 0; i < n - 1; i++) {
            int b = word.charAt(i) - 'A', c = word.charAt(i + 1) - 'A';
            for (int a = 0; a < 26; a++) {
                dp[b] = Math.max(dp[b], dp[a] + getDist(b, c) - getDist(a, c));
            }
            saved = Math.max(saved, dp[b]);
            res += getDist(b, c);
        }
        return res - saved;
    }
    
    
    private int getDist(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
    
}