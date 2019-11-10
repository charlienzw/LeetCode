class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int leftCnt = 0;
        Set<Integer> willRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCnt++;
            } else if (s.charAt(i) == ')') {
                if (leftCnt == 0) {
                    willRemove.add(i);
                } else {
                    leftCnt--;
                }
            }
        }
        
        int rightCnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                rightCnt++;
            } else if (s.charAt(i) == '(') {
                if (rightCnt == 0) {
                    willRemove.add(i);
                } else {
                    rightCnt--;
                }
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (!willRemove.contains(i)) sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}