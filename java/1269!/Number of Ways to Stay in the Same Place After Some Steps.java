class Solution {
    public int numWays(int steps, int arrLen) {
        int M = 1000000007;
        if (arrLen == 1) return 1;
        int[] dp = new int[arrLen];
        
        // One step can only stay or go right one time
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 1; i < steps; i++) {
            int[] temp = new int[arrLen];
            for (int j = 0; j <= Math.min(arrLen - 1, steps - i); j++) {
                long tempRes = dp[j];
                if (j > 0) tempRes = (tempRes + dp[j - 1]) % M;
                if (j < arrLen - 1) tempRes = (tempRes + dp[j + 1]) % M;
                temp[j] = (int)tempRes;
            }
            dp = temp;
        }
        return dp[0];
    }
}