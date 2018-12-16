//Time: O(n)
//Space: O(1)
//Sliding Window
//Only consider the subarray that includes the right-most element each time
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int res = 0;
        int left = 0, right = 0;
        int sum = 1;
        while(right < nums.length)
        {
            sum *= nums[right];
            while(sum >= k)
            {
                sum = sum / nums[left];
                left ++;
            }
            res += right - left + 1;
            right ++;
        }
        return res;
    }
}