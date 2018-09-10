class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        if(nums.length==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int dp11=nums[0];
        int dp12=Math.max(nums[0],nums[1]);
        int temp1=dp12;
        for(int i=2;i<nums.length-1;i++)
        {
            temp1=Math.max(nums[i]+dp11,dp12);   
            dp11=dp12;
            dp12=temp1;
        }
        int dp21=nums[1];
        int dp22=Math.max(nums[1],nums[2]);
        int temp2=dp21;
        for(int i=3;i<nums.length-2;i++)
        {
            temp2=Math.max(nums[i]+dp21,dp22);   
            dp21=dp22;
            dp22=temp2;
        }        
        return Math.max(temp1,nums[nums.length-1]+temp2);
    }
}