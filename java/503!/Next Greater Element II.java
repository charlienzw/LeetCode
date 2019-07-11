/*
    Input: [1,2,1]
    Output: [2,-1,2]
    i = 5
        res[2] = -1
        s: 2
    i = 4
        res[1] = -1
        s: 1
    i = 3
        res[0] = 2
        s: 1, 0
    i = 2
        res[2] = 2
        s: 1, 2
    i = 1
        res[1] = -1
        s: 1
    i = 0
        res[0] = 2
*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            // Find the first element larger than nums[i % nums.length]
            while (!s.isEmpty() && nums[s.peek()] <= nums[i % nums.length]) {
                s.pop();
            }
            res[i % nums.length] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % nums.length);
        }
        return res;
    }
}