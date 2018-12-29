// Build buckets with width equals to t
// Time: O(n)
// Space: O(min(n, k))
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            long h = get_hash((long)nums[i], (long)t);
            if(d.containsKey(h))
            {
                return true;
            }
            if(d.containsKey(h - 1) && Math.abs(nums[i] - d.get(h - 1)) <= t)
            {
                return true;
            }
            if(d.containsKey(h + 1) && Math.abs(nums[i] - d.get(h + 1)) <= t)
            {
                return true;
            }
            d.put(h, (long)nums[i]);
            if(i >= k) d.remove(get_hash((long)nums[i - k], (long)t));
        }
        return false;   
    }
    
    private long get_hash(long x, long t)
    {
        /*
        ...[-(t + 1), -1], [0, t], [t + 1, 2t + 1]...
        */
        return x < 0 ? (x + 1) / (t + 1) - 1 : x / (t + 1);
    }
}