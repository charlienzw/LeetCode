/*
    Find the peak
    Find the target in the left part
    Find the target in the right part
*/

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peakIndex, true);
        if (index != -1) return index;
        index = binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length() - 1, false);
        return index;
    }
    
    private int findPeak(MountainArray mountainArr) {
        int low = 0, high = mountainArr.length() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private int binarySearch(MountainArray mountainArr, int target, int low, int high, boolean isIncreasing) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == mountainArr.get(mid)) {
                return mid;
            } else if (target < mountainArr.get(mid)) {
                if (isIncreasing) high = mid - 1;
                else low = mid + 1;
            } else {
                if (isIncreasing) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}