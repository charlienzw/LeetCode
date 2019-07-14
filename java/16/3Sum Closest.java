class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDis = Integer.MAX_VALUE, res = target;
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(sum - target) < minDis) {
                    minDis = Math.abs(sum - target);
                    res = sum;
                }
                if (sum < target) low++;
                else high--;
            }
        }
        return res;
    }
}