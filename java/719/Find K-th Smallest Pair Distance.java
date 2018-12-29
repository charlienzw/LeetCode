class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int low = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 1; i++)
        {
            low = Math.min(low, nums[i + 1] - nums[i]);
        }
        
        int high = nums[nums.length - 1] - nums[0];
        
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            int cnt = helper(nums, mid);
            if(cnt > k - 1)
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public int helper(int[] nums, int mid)
    {
        int cnt = 0;
        for(int slow = 0, fast = 0; slow < nums.length; slow++)
        {
            while(fast < nums.length && Math.abs(nums[fast] - nums[slow]) <= mid)
            {
                fast++;
            }
            cnt += fast - slow - 1;
        }
        return cnt;
    }
    
}