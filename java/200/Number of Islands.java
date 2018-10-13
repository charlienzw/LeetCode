class Solution {
    char[][] c;
    public int numIslands(char[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        c=new char[grid.length][grid[0].length];
        int res=0;
        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<c[0].length;j++)
            {
                c[i][j]=grid[i][j];
            }
        }
        for(int i=0;i<c.length;i++)
        {
            for(int j=0;j<c[0].length;j++)
            {
                if(c[i][j]=='1')
                {
                    helper(i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void helper(int i,int j)
    {
        if(i>0&&c[i-1][j]=='1')
        {
            c[i-1][j]='0';
            helper(i-1,j);
        }
        if(i<c.length-1&&c[i+1][j]=='1')
        {
            c[i+1][j]='0';
            helper(i+1,j);
        }
        if(j>0&&c[i][j-1]=='1')
        {
            c[i][j-1]='0';
            helper(i,j-1);
        }
        if(j<c[0].length-1&&c[i][j+1]=='1')
        {
            c[i][j+1]='0';
            helper(i,j+1);
        }        
    }
}