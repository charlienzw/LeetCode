class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int degree = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, count.get(nums[i]));
        }
        int res = nums.length;
        for(Integer key : count.keySet()) {
            if(count.get(key) == degree) {
                res = Math.min(res, right.get(key) - left.get(key) + 1);
            }
        }
        return res;
    }
}