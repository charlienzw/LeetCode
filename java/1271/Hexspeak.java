class Solution {
    public String toHexspeak(String num) {
        StringBuilder sb = new StringBuilder();
        long n = Long.valueOf(num);
        while (n != 0) {
            int cur = (int)(n % 16);
            if (cur == 1) {
                sb.append('I');
            } else if (cur == 0) {
                sb.append('O');
            } else if (cur >= 10) {
                sb.append((char)(cur - 10 + 'A'));
            } else {
                return "ERROR";
            }
            n = n / 16;
        }
        return sb.reverse().toString();
    }
}