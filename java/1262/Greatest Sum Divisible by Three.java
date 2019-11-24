class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int minOne = 10001, minTwo = 10001;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] % 3 == 1) {
                minTwo = Math.min(minTwo, minOne + nums[i]);
                minOne = Math.min(minOne, nums[i]);
            }
            if (nums[i] % 3 == 2) {
                minOne = Math.min(minOne, minTwo + nums[i]);
                minTwo = Math.min(minTwo, nums[i]);
            }
        }
        if (sum % 3 == 1) {
            return sum - minOne;
        } else if (sum % 3 == 2) {
            return sum - minTwo;
        } else {
            return sum;
        }
    }
}