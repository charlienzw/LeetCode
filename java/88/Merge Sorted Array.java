class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] p=new int[m+1];
        int[] q=new int[n+1];
        for(int i=0;i<m;i++)
        {
            p[i]=nums1[i];
        }
        for(int i=0;i<n;i++)
        {
            q[i]=nums2[i];
        }
        p[m]=Integer.MAX_VALUE;
        q[n]=Integer.MAX_VALUE;
        int i=0,j=0;
        for(int k=0;k<m+n;k++)
        {
            if(p[i]<q[j])
            {
                nums1[k]=p[i];
                i=i+1;
            }
            else
            {
                nums1[k]=q[j];
                j=j+1;
            }
        }
    }
}