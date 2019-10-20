class Solution {
    public List<String> braceExpansionII(String expression) {
        List<String> res = new ArrayList<>();
        helper(expression, 0, new StringBuilder(), res);
        Collections.sort(res);
        return res;
    }
    
    private void helper(String expression, int cur, StringBuilder curSb, List<String> res) {
        for (int i = cur; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') {
                
                // Find the start and end of brace
                int end = findEnd(expression, i);
                // Split the brace
                String insideBrace = expression.substring(i + 1, end);
                List<String> options = new ArrayList<>();
                int pre = 0, cnt = 0;
                for (int j = 0; j < insideBrace.length(); j++) {
                    if (cnt == 0 && insideBrace.charAt(j) == ',') {
                        options.add(insideBrace.substring(pre, j));
                        pre = j + 1;
                    } else if (insideBrace.charAt(j) == '{') {
                        cnt++;
                    } else if (insideBrace.charAt(j) == '}') {
                        cnt--;
                    }
                }
                options.add(insideBrace.substring(pre, insideBrace.length()));
                
                // Each string in the split brace should be a new expression, get all the results
                List<String> optionRes = new ArrayList<>();
                for (String option : options) {
                    helper(option, 0, new StringBuilder(), optionRes);
                }
                
                // Remove duplicates in the results
                Set<String> optionSet = new HashSet<>();
                for (String option : optionRes) {
                    optionSet.add(option);
                }
                optionRes = new ArrayList<>();
                for (String option : optionSet) {
                    optionRes.add(option);
                }
                
                // Use backtracking to add each result to the stringbuilder
                for (int j = 0; j < optionRes.size(); j++) {
                    int sbLen = curSb.length();
                    curSb.append(optionRes.get(j));
                    helper(expression, end + 1, curSb, res);
                    curSb = curSb.delete(sbLen, curSb.length());
                }
                return;
            } else {
                curSb.append(expression.charAt(i));
            }
        }
        res.add(curSb.toString());
    }
    
    private int findEnd(String expression, int start) {
        int cnt = 1;
        for (int i = start + 1; i < expression.length(); i++) {
            if (expression.charAt(i) == '{') {
                cnt++;
            } else if (expression.charAt(i) == '}') {
                cnt--;
                if (cnt == 0) return i;
            }
        }
        return -1;
    }
}