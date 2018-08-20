class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] flag;
        for(int i=0;i<9;i++)
        {
            flag=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                    if(flag[(board[i][j]-'1')]==false)
                    {
                        flag[(board[i][j]-'1')]=true;
                    }
                    else
                        return false;
                }
            }
            flag=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                    if(flag[(board[j][i]-'1')]==false)
                    {
                        flag[(board[j][i]-'1')]=true;
                    }
                    else
                        return false;
                }
            }
            flag=new boolean[9];
            for(int j=0;j<9;j++)
            {
                if(board[3*(i/3)+j/3][3*(i%3)+j%3]!='.')
                {
                    if(flag[(board[3*(i/3)+j/3][3*(i%3)+j%3]-'1')]==false)
                    {
                        flag[(board[3*(i/3)+j/3][3*(i%3)+j%3]-'1')]=true;
                    }
                    else
                        return false;
                }
            }
        }
        return true;
    }
}