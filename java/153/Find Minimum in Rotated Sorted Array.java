//Time:O(logn)
//Space:O(1)
class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1, mid;
        while(low + 1 < high)
        {
            mid = low + (high - low) / 2;
            if(nums[low] > nums[mid])
            {
                high = mid;
                continue;
            }
            else if(nums[mid] > nums[high])
            {
                low = mid;
                continue;
            }
            else
            {
                return nums[low];
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}