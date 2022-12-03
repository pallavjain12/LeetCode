class Solution {
    public int reverse(int x) {
        if (x < 999999999 && x >= 0) {
            return reversePositive(x);
        }
        else if (x < 0 && x >= -999999999) {
            return reverseNegative(x);
        }
        else {
            return handleBigNumber(x);
        }
    }
    public int reversePositive(int x) {
        int res = 0;
        while(x > 0) {
            int r = x % 10;
            res = res * 10 + r;
            x /= 10;
        }
        return res;
    }
    private int reverseNegative(int x) {
        x = x * -1;
        x = reversePositive(x);
        return -1 * x;
    }
    private int handleBigNumber(int x) {
        if (x == -Integer.MIN_VALUE)    return 0;
        boolean mul = (x < 0) ? true : false;
        x = (x < 0) ? x * -1 : x;
        int max = Integer.MAX_VALUE;
        int duplicate = x;
        int res = 0;
        int divisor = 1000000000;
        while(x > 0) {
            int maxR = max / divisor;
            int currR = x % 10;
            if (currR > maxR) {
                return 0;
            }
            else if (currR < maxR) 
                {res = reversePositive(duplicate);
                break;}
            else { 
                x = x / 10; 
                max %= divisor;
                divisor /= 10;
            }
        }
        if (mul) {
            return res * -1;
        }
        else {
            return res;
        }
    }
}