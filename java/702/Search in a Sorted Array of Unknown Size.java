// Find an upper limit
class Solution {
    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return 0;
        int upperlim = 1;
        while(reader.get(upperlim) <= target)
        {
            upperlim = upperlim << 1;
        }
        int low = upperlim / 2, high = upperlim;
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(reader.get(mid) == target) return mid;
            else if(reader.get(mid) < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}