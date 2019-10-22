class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        
        int j = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                while (end.charAt(j) != 'L') {
                    j++;
                }
                if (j > i) return false;
                j++;
            }
        }
        
        j = 0;
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'R') {
                while (start.charAt(j) != 'R') {
                    j++;
                }
                if (j > i) return false;
                j++;
            }
        }
        
        return true;
    }
}