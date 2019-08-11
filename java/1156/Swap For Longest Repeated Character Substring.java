class Solution {
    public int maxRepOpt1(String text) {
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            int tempRes = 1;
            boolean isFirst = true;
            int j;
            for (j = i + 1; j < text.length(); j++) {
                if (text.charAt(j) == key) {
                    tempRes++;
                } else {
                    if (isFirst) {
                        tempRes++;
                        isFirst = false;
                    } else {
                        break;
                    }
                }
            }
            if (tempRes > res) {
                if (isFirst || existExcept(text, key, i, j)) {
                    res = tempRes;
                }
            }
        }
        return res;
    }
    
    private boolean existExcept(String text, char key, int left, int right) {
        for (int i = 0; i < left; i++) {
            if (key == text.charAt(i)) return true;
        }
        for (int i = right; i < text.length(); i++) {
            System.out.println(key + " vs " + text.charAt(i));
            if (key == text.charAt(i)) return true;
        }
        return false;
    }
}