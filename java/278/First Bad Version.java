/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low=1,high=n;
        while(low<=high)
        {
            int mid=(high-low)/2+low;
            if(isBadVersion(mid))
            {
                if(mid==0) return mid;
                else if(!isBadVersion(mid-1)) return mid;
                else high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return n+1;
    }
}