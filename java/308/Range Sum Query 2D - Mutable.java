//Time: O(n)
//Space: O(n^2)

class NumMatrix {
    int[][] presum;
    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return;
        presum = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < presum.length; i++)
        {
            for(int j = 0; j < presum[0].length; j++)
            {
                presum[i][j] = (j == 0 ? matrix[i][j] : matrix[i][j] + presum[i][j-1]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        if(presum.length==0 || presum[0].length==0) return;
        int increase = val - presum[row][col] + (col == 0 ? 0 : presum[row][col - 1]);
        for(int i = col; i < presum[0].length; i++)
        {
            presum[row][i] += increase;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i = row1; i <= row2; i++)
        {
            res += (presum[i][col2] - (col1 == 0 ? 0 : presum[i][col1-1]));
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */