class Solution {
    public int removeElement(int[] nums, int val) {
        int i=-1;
        int j,tmp;
        for(j=0;j<nums.length;j++)
        {
            if(nums[j]!=val)
            {
                i=i+1;
                tmp=nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }
        return i+1;
    }
}