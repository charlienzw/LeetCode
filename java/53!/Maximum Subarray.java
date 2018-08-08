//Dynamic Programming O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int[] s=new int[nums.length];
        s[0]=nums[0];
        int ms=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(s[i-1]>0)
            {
                s[i]=s[i-1]+nums[i];
            }
            else
            {
                s[i]=nums[i];
            }
            ms=Math.max(ms,s[i]);
        }
        return ms;
    }
}

//Divide and Conquer O(nlogn)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        return helper(nums,0,nums.length-1);
    }
    public int helper(int[] nums,int low,int high)
    {
        if(low>high) return Integer.MIN_VALUE;
        if(low==high) return nums[low];
        int mid=(low+high)/2;
        int midsum,leftsum,rightsum;
        int i=mid;
        int j=mid;
        int maxmidleftsum=Integer.MIN_VALUE,maxmidrightsum=Integer.MIN_VALUE;
        int midleftsum=0,midrightsum=0;
        while(i>=low)
        {
            midleftsum=midleftsum+nums[i];
            maxmidleftsum=Math.max(maxmidleftsum,midleftsum);
            i=i-1;
        }
        while(j<=high)
        {
            midrightsum=midrightsum+nums[j];
            maxmidrightsum=Math.max(maxmidrightsum,midrightsum);
            j=j+1;
        }
        midsum=maxmidleftsum+maxmidrightsum-nums[mid];
        leftsum=helper(nums,low,mid-1);
        rightsum=helper(nums,mid+1,high);
        if(midsum>=leftsum&&midsum>=rightsum) return midsum;
        else if(leftsum>=midsum&&leftsum>=rightsum) return leftsum;
        else return rightsum;
    }
}
