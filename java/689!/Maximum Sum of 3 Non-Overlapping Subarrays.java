class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] W=new int[nums.length-k+1];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(i>=k) sum-=nums[i-k];
            if(i>=k-1) W[i-k+1]=sum;
        }
        int[] left=new int[W.length];
        int dp=0;
        for(int i=0;i<W.length;i++)
        {
            if(W[i]>W[dp])
            {
                dp=i;
            }
            left[i]=dp;
        }
        int[] right=new int[W.length];
        dp=W.length-1;        
        for(int i=W.length-1;i>=0;i--)
        {
            if(W[i]>=W[dp])
            {
                dp=i;
            }
            right[i]=dp;
        }
        int[] res=new int[]{-1,-1,-1};
        for(int j=k;j<W.length-k;j++)
        {
            if(res[0]==-1||W[left[j-k]]+W[j]+W[right[j+k]]>W[res[0]]+W[res[1]]+W[res[2]])
            {
                res[0]=left[j-k];
                res[1]=j;
                res[2]=right[j+k];
            }
        }
        return res;
    }
}