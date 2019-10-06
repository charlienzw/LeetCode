// Hashing
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

// Two Pointer
class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<List<Integer>> numsWithIndex = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> numWithIndex = new ArrayList<>();
            numWithIndex.add(nums[i]);
            numWithIndex.add(i);
            numsWithIndex.add(numWithIndex);
        }
        Collections.sort(numsWithIndex, (a, b) -> (a.get(0) - b.get(0)));
        int left = 0, right = numsWithIndex.size() - 1;
        while (left < right) {
            int curSum = numsWithIndex.get(left).get(0) + numsWithIndex.get(right).get(0);
            if (curSum == target) {
                return new int[] {numsWithIndex.get(left).get(1), numsWithIndex.get(right).get(1)};
            } else if (curSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}