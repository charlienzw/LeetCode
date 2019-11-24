class Solution {
    public String encode(int num) {
        // Get encode length
        int encodeLen = 0;
        int cur = num + 1;
        while (cur != 1) {
            cur = cur >> 1;
            encodeLen++;
        }
        
        // Get mapping value
        int res = num - ((int)Math.pow(2, encodeLen) - 1);
        
        // Fill in result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encodeLen; i++) {
            sb.append(res & 1);
            res = res >> 1;
        }
        sb = sb.reverse();
        return sb.toString();
    }
}