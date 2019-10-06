class Solution {
    public int splitArray(int[] nums, int m) {
        long low = 0, high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, (long)nums[i]);
            high += (long)nums[i];
        }
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (check(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int)low;
    }
    
    private boolean check(int[] nums, int m, long res) {
        int cnt = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > res) {
                sum = nums[i];
                cnt++;
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}