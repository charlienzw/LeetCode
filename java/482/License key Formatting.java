class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S.length() == 0) return "";

        String[] strArr = S.split("-");
        int charLen = 0;
        StringBuilder noDashSb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            charLen += strArr[i].length();
            noDashSb.append(strArr[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (K == 1) {
            while (i < noDashSb.length()) {
                sb.append(noDashSb.charAt(i));
                sb.append("-");
                i++;
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            int firstLen = charLen % K;
            while (i < noDashSb.length()) {
                if (i % K == firstLen && i != 0) sb.append("-");
                sb.append(noDashSb.charAt(i));
                i++;
            }            
        }
        
        return sb.toString().toUpperCase();
    }
}