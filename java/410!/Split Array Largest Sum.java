class Solution {
    public int splitArray(int[] nums, int m) {
        long low = Integer.MAX_VALUE;
        long high = 0;
        for(int i = 0; i < nums.length; i++)
        {
            low = Math.min(low, (long)nums[i]);
            high += (long)nums[i];
        }
        
        while(low < high)
        {
            long mid = low + (high - low) / 2;
            if(helper(nums, m, mid))
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return (int)low;
    }
    
    public boolean helper(int[] nums, int m, long maxsum)
    {
        long s = 0;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if((long)nums[i] > maxsum) return false;
            if(s + (long)nums[i] > maxsum)
            {
                s = 0;
                cnt++;
            }
            s += (long)nums[i];
        }
        return cnt + 1 <= m;
    }
}