class Solution {
    public int lastRemaining(int n) {
        int head = 1, step = 1, remained = n;
        boolean left = true;
        while (remained > 1) {
            if (left || remained % 2 == 1) head += step;
            remained /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
}