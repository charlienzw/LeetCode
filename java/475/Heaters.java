/*
    Binary Search each house. Update the radius with the smaller distance of the house with its nearby heater
*/

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        if (houses.length == 0 || heaters.length == 0) return 0;
        Arrays.sort(heaters);
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
            int index = binarySearch(heaters, houses[i]);
            if (index == -1) res = Math.max(res, heaters[0] - houses[i]); // lower than the smaller heater
            else if (index == heaters.length - 1) res = Math.max(res, houses[i] - heaters[heaters.length - 1]); // higher or equal than the largest heater
            else res = Math.max(res, Math.min(houses[i] - heaters[index], heaters[index + 1] - houses[i]));
        }
        return res;
    }
    
    private int binarySearch(int[] heaters, int val) {
        int low = 0, high = heaters.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == heaters.length - 1) {
                if (val >= heaters[mid]) return mid; // higher or equal than the largest heater
                else high = mid - 1;
            } else {
                if (val >= heaters[mid] && val < heaters[mid + 1]) return mid;
                else if (val < heaters[mid]) high = mid - 1;
                else low = mid + 1;
            }
        }
        return -1; // lower than the smaller heater
    }
}