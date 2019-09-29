class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int slow = 0, fast = 0;
        int curCost = 0;
        int maxLen = 0;
        while (slow < s.length()) {
            while (fast < s.length() && curCost <= maxCost) {
                curCost += computeCost(s, t, fast);
                fast++;
            }
            maxLen = Math.max(maxLen, fast - slow + 1);
            curCost -= computeCost(s, t, slow);
            slow++;
        }
        return maxLen;
    }
    
    private int computeCost(String s, String t, int index) {
        return Math.abs(t.charAt(index) - s.charAt(index));
    }
}