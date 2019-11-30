class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int indexStart = binarySearch(intervals, toBeRemoved[0]);
        int indexEnd = binarySearch(intervals, toBeRemoved[1]);
        for (int i = 0; i < intervals.length; i++) {
            if (i > indexStart && i < indexEnd) continue;
            if (i == indexStart && toBeRemoved[0] != intervals[i][0]) {
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(Math.min(intervals[i][1], toBeRemoved[0]));
                res.add(list);
            }
            if (i == indexEnd && toBeRemoved[1] <= intervals[i][1]) {
                List<Integer> list = new ArrayList<>();
                list.add(toBeRemoved[1]);
                list.add(intervals[i][1]);
                res.add(list);
            }
            if (i < indexStart || i > indexEnd) {
                List<Integer> list = new ArrayList<>();
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
                res.add(list);
            }
        }
        return res;
    }
    
    private int binarySearch(int[][] intervals, int value) {
        int low = 0, high = intervals.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid != intervals.length - 1) {
                if (value >= intervals[mid][0] && value < intervals[mid + 1][0]) {
                    return mid;
                } else if (value < intervals[mid][0]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (value >= intervals[mid][0]) {
                    return intervals.length - 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}