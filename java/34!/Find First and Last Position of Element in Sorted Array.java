class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums.length==0) return res;
        int low=0,high=nums.length-1;
        while(low<=high)
        {
            int mid=(high-low)/2+low;
            if(target<=nums[mid]) 
            {
                high=mid-1;
                if(target==nums[mid])
                    res[0]=res[0]==-1?mid:Math.min(res[0],mid);
            }
            else low=mid+1;
        }
        low=0;
        high=nums.length-1;
        while(low<=high)
        {
            int mid=(high-low)/2+low;
            if(target<nums[mid]) high=mid-1;
            else 
            {
                low=mid+1;
                if(target==nums[mid])
                    res[1]=res[1]==-1?mid:Math.max(res[1],mid);
            }
        }
        return res;
    }
}