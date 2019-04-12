/*
123456789 10111213141516
n = 3
    digitLen = 1, count = 9
    3 - 9 = -6 < 0
    num = 2 + 1 = 3
    return 3
n = 11
    digitLen = 1, count = 9
    11 - 9 = 2 > 0
        n = 2
        digitLen = 2
        count = 90
    2 - 2 * 90 < 0
    num = 0 + 10 = 10
    return 0
*/
class Solution {
    public int findNthDigit(int n) {
        int digitLen = 1;
        long count = 9;
        while(n - digitLen * count > 0) {
            n -= digitLen * count;
            System.out.println(n);
            digitLen++;
            count *= 10;
        }
        int num = (n - 1) / digitLen + (int)Math.pow(10, digitLen - 1);
        return String.valueOf(num).charAt((n - 1) % digitLen) - '0';
    }
}