class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        int res=0;
        int[] dp=new int[matrix[0].length];
        for(int j=0;j<matrix[0].length;j++)
        {
            dp[j]=matrix[0][j]-'0';
        }
        res=Math.max(res,largestRectangleArea(dp));
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='1')
                    dp[j]=dp[j]+1;
                else dp[j]=0;
            }
            res=Math.max(res,largestRectangleArea(dp));
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s=new Stack<>();
        int res=0;
        int temp,tempi,start;
        for(int i=0;i<=heights.length;i++)
        {
            if(i==heights.length)
                temp=0;
            else
                temp=heights[i];
            while(s.size()!=0&&temp<heights[s.peek()])
            {
                tempi=s.pop();
                start=s.size()==0?-1:s.peek();
                res=Math.max(res,heights[tempi]*(i-start-1));
            }
            s.push(i);
        }
        return res;
    }
}