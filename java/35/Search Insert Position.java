class Solution {
    public int searchInsert(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(mid==0)
            {
                if(target<=nums[mid])
                    return mid;
                else low=mid+1;
            }
            else
            {
                if(target>nums[mid-1]&&target<=nums[mid]) return mid;
                else if(target<=nums[mid-1]) high=mid-1;
                else low=mid+1;
            }
        }
        return low;
    }
}