class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int ml=height[0],mr=height[height.length-1],l=0,r=height.length-1;
        int sum1=0,sum2=0;
        while(l<r)
        {
            ml=Math.max(ml,height[l]);
            mr=Math.max(mr,height[r]);
            if(ml<mr)
            {
                sum1+=ml;
                sum2+=height[l];
                l++;
            }
            else
            {
                sum1+=mr;
                sum2+=height[r];
                r--;
            }
        }
        return sum1-sum2>0?sum1-sum2:0;
    }
}