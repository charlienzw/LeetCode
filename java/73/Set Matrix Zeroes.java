class Solution {
    public void setZeroes(int[][] matrix) {
        //Find the first zero as the base point. The row and column of this point will be zero finally. So it can be set as the sign.
        int basei = -1, basej = -1;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    basei = i;
                    basej = j;
                    break;
                }
            }
        }
        
        if(basei == -1 && basej == -1) return;
        
        //Set the zero sign on the base row and column
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(!(i == basei && j == basej) && matrix[i][j] == 0)
                {
                    matrix[i][basej] = 0;
                    matrix[basei][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < matrix.length;i++)
        {
            if(i != basei && matrix[i][basej] == 0)
            {
                for(int j = 0; j < matrix[0].length; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int j = 0; j < matrix[0].length; j++)
        {
            if(j != basej && matrix[basei][j] == 0)
            {
                for(int i = 0; i < matrix.length; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++) matrix[i][basej] = 0;
        for(int j = 0; j < matrix[0].length; j++) matrix[basei][j] = 0;
    }
}