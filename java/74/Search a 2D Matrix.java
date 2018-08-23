class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int row=-1;
        int low=0,high=matrix.length-1;
        int mid;
        while(low<=high)
        {
            mid=(high-low)/2+low;
            if(mid!=matrix.length-1)
            {
                if(target>=matrix[mid][0]&&target<matrix[mid+1][0])
                {
                    row=mid;
                    break;
                }
                else if(target<matrix[mid][0])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            {
                if(target>=matrix[mid][0])
                {
                    row=mid;
                    break;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        if(row==-1) return false;
        low=0;
        high=matrix[row].length-1;
        while(low<=high)
        {
            mid=(high-low)/2+low;
            if(target==matrix[row][mid]) return true;
            else if(target<matrix[row][mid]) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}