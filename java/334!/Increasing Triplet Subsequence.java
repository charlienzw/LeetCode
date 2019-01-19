class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int minPre = Integer.MAX_VALUE;
        int secondminPre = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] <= minPre)
            {
                minPre = nums[i];
            }
            else if(nums[i] <= secondminPre)
            {
                secondminPre = nums[i];
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}