class Solution {
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