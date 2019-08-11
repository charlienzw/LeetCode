class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        List<Integer> t = new ArrayList<>();
        t.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int index = bs(t, nums[i]);
            if (index == t.size() - 1) t.add(nums[i]);
            else t.set(index + 1, nums[i]);            
        }
        return t.size();
    }
    public int bs(List<Integer> t,int x) {
        int low = 0, high = t.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(mid == t.size() - 1) {
                if (t.get(mid) < x) return mid;
                else {
                    high = mid - 1;
                }
            }
            if(t.get(mid) < x && x <= t.get(mid + 1)) return mid;
            else if(x <= t.get(mid)) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}