class Solution {
    public void rotate(int[][] matrix) {
        int tmp1,tmp2;
        int tmpi,tmpj;
        for(int ii=0;ii<matrix.length-1;ii++)
        {
            for(int jj=ii;jj<matrix.length-1-ii;jj++)
            {
                int i=ii,j=jj;
                tmp1=tmp2=matrix[i][j];
                while(j!=ii||matrix.length-i-1!=jj)
                {
                    tmp2=matrix[j][matrix.length-i-1];
                    matrix[j][matrix.length-i-1]=tmp1;
                    tmp1=tmp2;
                    tmpi=i;
                    tmpj=j;
                    i=tmpj;
                    j=matrix.length-tmpi-1;
                }
                matrix[j][matrix.length-i-1]=tmp2;
            }
        }
    }
}