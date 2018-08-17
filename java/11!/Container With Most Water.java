class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        int low=0,high=height.length-1;
        int res=Integer.MIN_VALUE;
        while(low<=high)
        {
            res=Math.max(res,Math.min(height[high],height[low])*(high-low));
            if(height[low]<height[high]) low++;
            else high--;
        }
        return res;
    }
}