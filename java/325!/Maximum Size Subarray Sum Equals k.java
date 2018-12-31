/*
[1,-1,5,-2,3]
3
pre: 0, 1, 0, 5, 3, 6
map: {3, 0}, {4, 1}, {3, 2}, {8, 3}, 

[1, 1, 0]
1
pre: 0, 1, 2, 2
map: {1, 0}, {2, 1}, {3, 2}, {3, 3}

*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int[] pre = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
        {
            pre[i + 1] = nums[i] + pre[i];
        }
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < pre.length; i++)
        {
            if(!map.containsKey(pre[i] + k)) map.put(pre[i] + k, i);
            if(map.containsKey(pre[i]))
            {
                res = Math.max(res, i - map.get(pre[i]));
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}