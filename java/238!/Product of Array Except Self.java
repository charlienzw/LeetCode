/*
Input:  [1,2,3,4]
Output: [24,12,8,6]
[1, 1, 2, 6]
[24, 12, 8, 6]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prepro = 1;
        
        for(int i = 0; i < res.length; i++){
            res[i] = prepro;
            prepro *= nums[i];
        }
        
        prepro = 1;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] *= prepro;
            prepro *= nums[i];
        }
        
        return res;
    }
}