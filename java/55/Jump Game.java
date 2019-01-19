class Solution {
    public boolean canJump(int[] nums) {
        int maxdis = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(i <= maxdis)
            {
                if(i + nums[i] > maxdis)
                    maxdis = i + nums[i];
            }
            else break;
        }
        if(maxdis >= nums.length - 1) return true;
        else return false;
    }
}