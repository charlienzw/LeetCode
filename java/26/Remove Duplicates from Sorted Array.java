class Solution {
    public int removeDuplicates(int[] nums) {
        int i=-1;
        int j,tmp,key=Integer.MIN_VALUE;
        for(j=0;j<nums.length;j++)
        {
            if(nums[j]>key)
            {
                key=nums[j];
                i=i+1;
                tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
        }
        return i+1;
    }
}