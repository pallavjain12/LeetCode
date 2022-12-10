class Solution {
    public int numTrees(int n) {
        return solve(n);
    }
    private long gcd (long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    private int solve (int n) {
        long up = 1;
        long down = 1;
        for (int i = 1; i <= 2 * n; i++) {
            if (i <= n) down *= i;
            if (i <= n + 1) down *= i;
            up = up * i;
            long gcd = gcd(up, down);
            up /= gcd;
            down /= gcd;
        }
        return (int)(up / down);
    }
}