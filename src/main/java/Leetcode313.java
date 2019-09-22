class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] idx = new int[primes.length];
        int[] ugly = new int[n];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);
        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (val[j] == ugly[i]) val[j] = primes[j] * ugly[idx[j]++];
                next = Math.min(next, val[j]);
            }
        }

        return ugly[n - 1];
    }
}
