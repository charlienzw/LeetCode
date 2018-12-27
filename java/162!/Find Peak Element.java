// Assume it is a increasing array. Find the first nums[i] > nums[i - 1]
// Time: O(n), Space:O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[mid + 1])
            {
                high = mid;
            }
            else low = mid + 1;
        }
        return low;
    }
}