class Solution {
    public int findDuplicate(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++)
        {
            
            while(i != nums[i] - 1)
            {
                if(nums[nums[i] - 1] == nums[i]) return nums[i];
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;                
            }

        }
        return -1;
    }
}