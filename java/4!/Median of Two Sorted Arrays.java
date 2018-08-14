class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2,nums1);
        double median=0;
        if(nums1==null||nums1.length==0)
        {
            median=nums2[(nums2.length-1)/2];
            if(nums2.length%2==1) return median;
            else return (median+nums2[(nums2.length-1)/2+1])/2;
        }
        if(nums2==null||nums2.length==0)
        {
            return 0;
        }
        int low=0,high=nums1.length,i=0,j=0;
        while(low<=high)
        {
            i=(low+high)/2;
            j=(nums1.length+nums2.length+1)/2-i;
            if(i<nums1.length&&j>0&&nums2[j-1]>nums1[i]) low=i+1;
            else if(j<nums2.length&&i>0&&nums1[i-1]>nums2[j]) high=i-1;
            else
            {
                if(i==0) median=nums2[j-1];
                else if(j==0) median=nums1[i-1];
                else median=Math.max(nums1[i-1],nums2[j-1]);
                break;
            }
        }
        if((nums1.length+nums2.length)%2==1) return median;
        if(i==nums1.length) return (median+nums2[j])/2;
        if(j==nums2.length) return (median+nums1[i])/2;
        return (median+Math.min(nums1[i],nums2[j]))/2;  
    }
}