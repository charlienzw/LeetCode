class Solution {
    public boolean isGoodArray(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x = gcd(x, nums[i]);
        }
        return x == 1;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}