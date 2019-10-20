class Solution {
    List<String> resList;
    public String[] expand(String S) {
        resList = new ArrayList<>();
        // Start from 0 to backtracking
        helper(S, 0, new StringBuilder());
        String[] res = new String[resList.size()];
        int i = 0;
        for (String s : resList) res[i++] = s;
        return res;
    }
    
    private void helper(String S, int cur, StringBuilder curSb) {
        
        for (int i = cur; i < S.length(); i++) {
            if (S.charAt(i) == '{') {
                int start = i;
                while (S.charAt(i) != '}') {
                    i++;
                }
                String[] options = S.substring(start + 1, i).split(",");
                Arrays.sort(options);
                for (String option : options) {
                    int sbLen = curSb.length();
                    curSb.append(option);
                    helper(S, i + 1, curSb);
                    curSb = curSb.delete(sbLen, curSb.length());
                }
                return;
            } else {
                curSb.append(S.charAt(i));           
            }
        }
        resList.add(curSb.toString());  
    }
}