class Solution {
    public int minimumSwap(String s1, String s2) {
        int s1XCount = 0, s1YCount = 0, s2XCount = 0, s2YCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            if (s1.charAt(i) == 'x') {
                s1XCount++;
            } else {
                s1YCount++;
            }
            if (s2.charAt(i) == 'x') {
                s2XCount++;
            } else {
                s2YCount++;
            }
        }
        
        if ((s1XCount + s2XCount) % 2 != 0 || (s1YCount + s2YCount) % 2 != 0) return -1;
        return s1XCount / 2 + s1YCount / 2 + s1XCount % 2 * 2;
    }
}