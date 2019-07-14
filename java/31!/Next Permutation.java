class Solution {
    public void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            reverse(nums, 0);
        } else {
            int j;
            for (j = nums.length - 1; j >= i; j--) {
                if (nums[j] > nums[i - 1]) break;
            }
            swap(nums, i - 1,j);
            reverse(nums, i);
        }
    }
    public void reverse(int[] nums, int start)
    {
        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;        
    }
}