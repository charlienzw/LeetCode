/*
    sum = 1
    i = 2 : sqrt(num)
        if num % i == 0
            sum += i + (num / i)
    if sum == num return true
    else return false
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num) {
                    sum += i;
                } else {
                    sum += i + (num / i);
                }
            }
        }
        return sum == num;
    }
}