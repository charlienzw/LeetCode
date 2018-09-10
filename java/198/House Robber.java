class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int dp1=nums[0],dp2=Math.max(nums[0],nums[1]);
        int temp=0;
        for(int i=2;i<nums.length;i++)
        {
            temp=Math.max(nums[i]+dp1,dp2);
            dp1=dp2;
            dp2=temp;
        }
        return temp;
    }
}