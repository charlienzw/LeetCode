class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        if(board.length==0||board[0].length==0) return false;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(exist(board,word,i,j,0)) return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board,String word,int i,int j,int cur)
    {
        if(cur==word.length()) return true;
        if(i<0||i>=board.length||j<0||j>=board[0].length) return false;
        if(board[i][j]==word.charAt(cur))
        {
            char c=board[i][j];
            board[i][j]='#';
            boolean res=exist(board,word,i-1,j,cur+1)||exist(board,word,i,j-1,cur+1)||exist(board,word,i+1,j,cur+1)||exist(board,word,i,j+1,cur+1);
            board[i][j]=c;
            return res;
        }
        else return false;
    }
}