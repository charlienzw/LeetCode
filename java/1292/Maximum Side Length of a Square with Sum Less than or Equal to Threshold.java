class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] preSum = new int[m][n];
        preSum[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) {
            preSum[i][0] = preSum[i - 1][0] + mat[i][0];
        }
        for (int j = 1; j < n; j++) {
            preSum[0][j] = preSum[0][j - 1] + mat[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + mat[i][j];
            }
        }        
        
        int low = 1, high = Math.max(mat.length, mat[0].length);
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (check(preSum, mid, threshold)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (check(preSum, low, threshold)) return low;
        return low - 1;
    }
    
    private boolean check(int[][] preSum, int size, int threshold) {
        for (int i = 0; i <= preSum.length - size; i++) {
            for (int j = 0; j <= preSum[0].length - size; j++) {
                int ii = i + size - 1, jj = j + size - 1;
                if (getSquare(preSum, i, j, ii, jj) <= threshold) return true;
            }
        }
        return false;
    }
    
    private int getSquare(int[][] preSum, int i, int j, int ii, int jj) {
        return preSum[ii][jj] - (j == 0 ? 0 : preSum[ii][j - 1]) - (i == 0 ? 0 : preSum[i - 1][jj]) + (i == 0 || j == 0 ? 0 : preSum[i - 1][j - 1]);
    }
}