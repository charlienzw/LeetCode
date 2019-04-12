class NumArray {
    int[] pre;
    public NumArray(int[] nums) {
        pre = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return pre[j + 1] - pre[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */