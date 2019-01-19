class TicTacToe {
    int[] h1, v1, h2, v2;
    int d11, d21, d12, d22;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        h1 = new int[n];
        v1 = new int[n];
        h2 = new int[n];
        v2 = new int[n];
        d11 = 0;
        d21 = 0;
        d12 = 0;
        d22 = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player == 1)
        {
            h1[row]++;
            if(h1[row] == h1.length) return 1;
            v1[col]++;
            if(v1[col] == v1.length) return 1;
            if(row == col) 
            {
                d11++;
                if(d11 == h1.length) return 1;
            }
            if(row + col == h1.length - 1)
            {
                d12++;
                if(d12 == h1.length) return 1;
            }
        }
        else
        {
            h2[row]++;
            if(h2[row] == h2.length) return 2;
            v2[col]++;
            if(v2[col] == v2.length) return 2;
            if(row == col)
            {
                d21++;
                if(d21 == h2.length) return 2;
            }      
            if(row + col == h2.length - 1)
            {
                d22++;
                if(d22 == h2.length) return 2;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */