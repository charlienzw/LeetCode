class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] prime2UglyIndex = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int minProduct = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[prime2UglyIndex[j]] * primes[j] < minProduct) {
                    minProduct = ugly[prime2UglyIndex[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[prime2UglyIndex[j]] * primes[j] == minProduct) {
                    prime2UglyIndex[j]++;
                }
            }
            ugly[i] = minProduct;
            prime2UglyIndex[minIndex]++;
        }
        return ugly[n - 1];
    }
}