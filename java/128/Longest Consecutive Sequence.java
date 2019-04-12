class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int curLen = 1;
                while(set.contains(num + 1)) {
                    curLen++;
                    num++;
                }
                res = Math.max(res, curLen);
            }
        }
        return res;
    }
}