class Solution {
    public int missingNumber(int[] nums) {
        int s=(1+nums.length)*nums.length/2;
        int snums=0;
        for(int i=0;i<nums.length;i++)
        {
            snums=snums+nums[i];
        }
        return s-snums;
    }
}