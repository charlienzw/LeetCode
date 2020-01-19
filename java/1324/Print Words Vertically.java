class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            int spaceLen = 0;
            for (String word : words) {
                if (i < word.length()) {
                    for (int j = 0; j < spaceLen; j++) sb.append(" ");
                    spaceLen = 0;
                    sb.append(word.charAt(i));
                } else {
                    spaceLen++;
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
}