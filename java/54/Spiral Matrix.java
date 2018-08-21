class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        if(matrix.length==0) return res;
        int up=0,down=matrix.length-1,left=0,right=matrix[0].length-1;
        int i,j;
        while(up<down&&left<right)
        {
            i=up;
            j=left;
            while(true)
            {
                res.add(matrix[i][j]);
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
                    if(i==up&&j==left)
                    {
                        break;
                    }
                }
            }
            up++;
            down--;
            left++;
            right--;
        }
        if(up==down&&left<right)
        {
            i=left;
            while(i<=right)
            {
                res.add(matrix[up][i]);
                i++;
            }            
        }
        else if(up<down&&left==right)
        {
            i=up;
            while(i<=down)
            {
                res.add(matrix[i][left]);
                i++;
            }
        }
        else if(up==down&&left==right)
        {
            res.add(matrix[up][left]);
        }
        return res;
    }
}