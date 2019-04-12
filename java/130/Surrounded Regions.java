class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i++) {
            helper(board, i, 0);
            helper(board, i, board[0].length - 1);
        }
        for(int j = 0; j < board[0].length; j++) {
            helper(board, 0, j);
            helper(board, board.length - 1, j);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == 'C' ? 'O' : 'X';
            }
        }
    }
    public void helper(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'C';
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int[] dir : dirs) {
            helper(board, i + dir[0], j + dir[1]);
        }
    }
}