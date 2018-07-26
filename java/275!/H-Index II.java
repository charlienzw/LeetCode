class Solution {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int low=0;
        int high=citations.length-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(citations[mid]==citations.length-mid) return citations[mid];
            else if(citations[mid]>citations.length-mid)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return citations.length-low;
    }
}