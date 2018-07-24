class Solution {
    public int[] singleNumber(int[] nums) {
        int xval=0;
        for (int i=0;i<nums.length;i++)
        {
            xval^=nums[i];
        }
        xval&=-xval;
        int[] res=new int[2];
        for (int i=0;i<nums.length;i++)
        {
            if ((nums[i] & xval)==0)
                res[0]^=nums[i];
            else
                res[1]^=nums[i];
        }
        return res;
    }
}