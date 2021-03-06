//Time:O(logn)
//Space:O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high)
        {
            int mid = low + (high - low) / 2;
            if(nums[low] <= nums[high])
            {
                return nums[low];
            }
            if(nums[high] > nums[mid])
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}