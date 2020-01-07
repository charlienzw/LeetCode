class Solution {
    public String freqAlphabets(String s) {
        int cur = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (cur >= 0) {
            if (s.charAt(cur) == '#') {
                sb.append((char)('a' + Integer.valueOf(s.substring(cur - 2, cur)) - 1));
                cur = cur - 3;
            } else {
                sb.append((char)('a' + ((s.charAt(cur) - '0') - 1)));
                cur--;
            }
        }
        return sb.reverse().toString();
    }
}