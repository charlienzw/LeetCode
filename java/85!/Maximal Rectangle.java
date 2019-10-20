// DP
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        
        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n - 1);
        
        int res = 0;
        for (int i = 0; i < m; i++) {
            int curLeft = 0, curRight = n - 1;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], curRight);
                } else {
                    right[j] = n - 1;
                    curRight = j - 1;
                }
            }
            for (int j = 0; j < n; j++) {
                res = Math.max(res, (right[j] - left[j] + 1) * height[j]);
            }
        }
        return res;
    }
}

// From LC84
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