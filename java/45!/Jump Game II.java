class Solution {
    public int jump(int[] nums) {
        if(nums==null|nums.length<=1) return 0;
        int maxstep=0;
        int maxcur=0;
        int i;
        int res=0;
        for(i=0;i<nums.length-1;i++)
        {
            if(i+nums[i]>maxstep)
            {
                maxstep=i+nums[i];
            }
            if(i==maxcur)
            {
                res++;
                maxcur=maxstep;
            }
        }
        return res;
    }
}