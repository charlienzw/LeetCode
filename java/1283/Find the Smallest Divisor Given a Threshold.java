class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 1000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!check(nums, mid, threshold)) low = mid + 1;
            else high = mid;
        }
        return high;
    }
    
    private boolean check(int[] nums, int x, int threshold) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += div(nums[i], x);
        }
        return sum <= threshold;
    }
    
    private int div(int a, int b) {
        if (a % b == 0) return a / b;
        else return a / b + 1;
    }
}