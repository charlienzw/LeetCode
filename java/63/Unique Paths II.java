class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] r=new int[m][n];
        if(obstacleGrid[0][0]==1)
            return 0;
        else r[0][0]=1;
        for(int i=1;i<m;i++)
        {
            if(obstacleGrid[i][0]==1)
                r[i][0]=0;
            else r[i][0]=r[i-1][0];
        }
        for(int j=1;j<n;j++)
        {
            if(obstacleGrid[0][j]==1)
                r[0][j]=0;
            else r[0][j]=r[0][j-1];
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==1)
                    r[i][j]=0;
                else r[i][j]=r[i-1][j]+r[i][j-1];
            }
        }
        return r[m-1][n-1];    
    }
}