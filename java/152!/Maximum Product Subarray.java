/*
[2, 3, -2, 4]
res = 2, minp = 2, maxp = 2
i = 1
    nums[i] = 3
    minp = 3
    maxp = 6
    res = 6
i = 2
    nums[i] = -2
    minp = -12
    maxp = -2
    res = 6
i = 3
    nums[i] = 4
    minp = -48
    maxp = -6
    res = 6
*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int res = nums[0];
        int minp = res, maxp = res;
        int temp;
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < 0)
            {
                temp = minp;
                minp = maxp;
                maxp = temp;
            }
            minp = Math.min(minp * nums[i], nums[i]);
            maxp = Math.max(maxp * nums[i], nums[i]);
            res = Math.max(res, maxp);
        }
        return res;
    }
}