/*
Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
leftmax: [1, 3, 3, -3, 5, 5, 6, 7]
rightmax: [1, 3, -1, -3, 6, 6, 6, 7]
res: [3, 3, 5, 5, 6, 7]

dp: [3, 3, 3]
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        
        int[] leftmax = new int[nums.length];
        int[] rightmax = new int[nums.length];
        leftmax[0] = nums[0];
        rightmax[nums.length - 1] = nums[nums.length - 1];
        
        for(int i = 1; i < nums.length; i++){
            leftmax[i] = i % k == 0 ? nums[i] : Math.max(leftmax[i - 1], nums[i]);
        }
        for(int i = nums.length - 2; i >= 0; i--){
            rightmax[i] = i % k == 0 ? nums[i] : Math.max(rightmax[i + 1], nums[i]);
        }
        
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < res.length; i++){
            res[i] = Math.max(rightmax[i], leftmax[i + k - 1]);
        }
        return res;
    }
}