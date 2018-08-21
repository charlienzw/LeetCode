class Solution {
    char[][] res;
    public void solveSudoku(char[][] board) {
        res=new char[9][9];
        helper(board,0,0);
        for(int ii=0;ii<9;ii++)
        {
            for(int jj=0;jj<9;jj++)
            {
                board[ii][jj]=res[ii][jj];
            }
        }
    }
    public void helper(char[][] board,int i,int j)
    {
        if(board[i][j]=='.')
        {
            boolean[] flag=new boolean[9];
            for(int k=0;k<9;k++)
            {
                if(board[i][k]!='.')
                    flag[board[i][k]-'1']=true;
                if(board[k][j]!='.')
                    flag[board[k][j]-'1']=true;
            }
            for(int m=3*(i/3);m<3*(i/3)+3;m++)
            {
                for(int n=3*(j/3);n<3*(j/3)+3;n++)
                {
                    if(board[m][n]!='.')
                        flag[board[m][n]-'1']=true;
                }
            }
            int stop=1;
            for(int m=0;m<flag.length;m++)
            {
                if(!flag[m])
                {
                    stop=0;
                    board[i][j]=(char)(m+'1');
                    if(j<8)
                    {
                        helper(board,i,j+1);
                    }
                    else if(i<8)
                    {
                        helper(board,i+1,0);
                    }
                    else
                    {
                        for(int ii=0;ii<9;ii++)
                        {
                            for(int jj=0;jj<9;jj++)
                            {
                                res[ii][jj]=board[ii][jj];
                            }
                        }
                        return;
                    }
                    board[i][j]='.';
                }
            }
            if(stop==1)
            {
                return;
            }
        }
        else
        {
            if(j<8)
            {
                helper(board,i,j+1);
            }
            else if(i<8)
            {
                helper(board,i+1,0);
            }
            else
            {
                for(int ii=0;ii<9;ii++)
                {
                    for(int jj=0;jj<9;jj++)
                    {
                        res[ii][jj]=board[ii][jj];
                    }
                }
                return;
            }
        }
    }
}