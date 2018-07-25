class Solution {
    public int removeDuplicates(int[] nums) {
        int i=-1;
        int j,tmp,key=Integer.MIN_VALUE;
        int cnt=0;
        for(j=0;j<nums.length;j++)
        {
            if(cnt==0||nums[j]>key)
            {
                if(nums[j]==key)
                {
                    cnt=1;
                }
                else
                {
                    key=nums[j];
                    cnt=0;
                }
                i=i+1;
                tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }

        }
        return i+1;        
    }
}