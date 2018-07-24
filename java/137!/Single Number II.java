class Solution {
    public int singleNumber(int[] nums) {
        int []x=new int[2];
        for (int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            x[1]^=(x[0]&num);
            x[0]^=num;
            int mask=~(x[1]&x[0]);
            x[1]&=mask;
            x[0]&=mask;
        }
        return x[0];
    }
}