class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int up=0,down=n-1,left=0,right=n-1;
        int k=1;
        int i,j;
        while(up<=down&&left<=right)
        {
            i=up;
            j=left;
            while(true)
            {
                if(k>n*n) break;
                res[i][j]=k;
                k++;
                if(i==up&&j<right)
                {
                    j++;
                }
                else if(i<down&&j==right)
                {
                    i++;
                }
                else if(i==down&&j>left)
                {
                    j--;
                }
                else if(i>up&&j==left)
                {
                    i--;
                }
                if(i==up&&j==left)  break;
            }
            if(k>n*n) break;
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }
}