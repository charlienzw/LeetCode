// Sliding Window
// Time: O(n) Space: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0;
        while (slow < s.length() && fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                set.remove(s.charAt(slow++));
            } else {
                set.add(s.charAt(fast++));
                maxLen = Math.max(maxLen, fast - slow);
            }
        }
        return maxLen;
    }
}