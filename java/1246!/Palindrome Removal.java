class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        }
        
        for (int size = 2; size <= n; size++) {
            for (int left = 0; left < n - size; left++) {
                int right = left + size;
                if (arr[left] == arr[right]) {
                    dp[left][right] = dp[left + 1][right - 1];
                } else {
                    dp[left][right] = n;
                    for (int mid = left; mid < right; mid++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][mid] + dp[mid + 1][right]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}