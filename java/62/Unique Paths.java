//DP

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] r=new int[m][n];
        for(int i=0;i<m;i++)
        {
            r[i][0]=1;
        }
        for(int j=0;j<n;j++)
        {
            r[0][j]=1;
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                r[i][j]=r[i-1][j]+r[i][j-1];
            }
        }
        return r[m-1][n-1];
    }
}

//Formula

class Solution {
    public int uniquePaths(int m, int n) {
        double res=1;
        int N=m+n-2;
        int k=m-1;
        for(int i=1;i<=k;i++)
        {
            res=res*(N-k+i)/i; //(N-k+1)/1, ((N-k+1)(N-k+2))/(1*2), etc are still combinations: combination(N-k+i, i), which are integers
        }
        return (int)res;
    }
}