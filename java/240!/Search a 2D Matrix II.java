class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length - 1, column = 0;
        while (row >= 0 && column <= matrix[0].length - 1) {
            if (target == matrix[row][column]) return true;
            else if (target < matrix[row][column]) row--;
            else column++;
        }
        return false;
    }
}