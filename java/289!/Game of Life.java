class Solution {
    public void gameOfLife(int[][] board) {
        int[][] dir = {{0, 1}, {1, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 0}, {1, -1}, {-1, 1}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int live = 0;
                for(int[] d : dir){
                    if(i + d[0] < 0 || i + d[0] >= board.length || j + d[1] < 0 || j + d[1] >= board[0].length){
                        continue;
                    }
                    if(board[i + d[0]][j + d[1]] == 1 || board[i + d[0]][j + d[1]] == 2){
                        live++;
                    }
                }
                if(board[i][j] == 0 && live == 3) board[i][j] = 3;
                if(board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] %= 2;
            }
        }
    }
}