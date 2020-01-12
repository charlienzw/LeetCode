class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] leftTopSum = new int[m][n];
        leftTopSum[0][0] = mat[0][0];
        for (int i = 1; i < m; i++) {
            leftTopSum[i][0] = mat[i][0] + leftTopSum[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            leftTopSum[0][j] = mat[0][j] + leftTopSum[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                leftTopSum[i][j] = mat[i][j] + leftTopSum[i - 1][j] + leftTopSum[i][j - 1] - leftTopSum[i - 1][j - 1];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = leftTopSum[i + K < m ? i + K : m - 1][j + K < n ? j + K : n - 1] - (j - K - 1 < 0 ? 0 : leftTopSum[i + K < m ? i + K : m - 1][j - K - 1]) - (i - K - 1 < 0 ? 0 : leftTopSum[i - K - 1][j + K < n ? j + K : n - 1]) + ((i - K - 1 < 0 || j - K - 1 < 0) ? 0 : leftTopSum[i - K - 1][j - K - 1]);
            }
        }
        return res;
    }
}