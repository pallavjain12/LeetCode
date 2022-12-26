class Solution {
    
    static final int MOD = 1000000007;
    static HashMap<Integer, Integer> factorial = new HashMap<Integer, Integer>();
    static int lastFact = 0;
    
    public int countAnagrams(String s) {
        factorial.put(0, 1);
        String[] arr = s.split(" ");
        int ans = 1;
        for (String str : arr) {
            ans = multiply(ans, count(str));
        }
        return ans;
    }
    
    private static int count(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        int denomi = 1;
        int numi = getFactorial(s.length());
        for (int i : freq) {
            if (i != 0)
                numi = multiply(numi, multiplyInverse(getFactorial(i)));
                //denomi = multiply(denomi, getFactorial(i));
        }
        // return multiply(numi, multiplyInverse(denomi));
        return numi;
    }
    
    private static int getFactorial(int n) {
        if (n <= lastFact) {
           return factorial.get(n); 
        }
        for (int i = lastFact + 1; i <= n; i++) {
            factorial.put(i, multiply(i, factorial.get(i - 1)));
        }
        lastFact = n;
        return factorial.get(n);
    }
    
    private static int multiply(int a, int b) {
        int res = 0; 
        a %= MOD;
 
        while (b > 0) {
             
            if ((b & 1) > 0) {
                res = (res + a) % MOD;
            }
            a = (2 * a) % MOD;
            b >>= 1;
        }
        return res;
    }
        
    private static int multiplyInverse(int n) {
        int k = power(n, MOD - 2);
        return k;
    }
    
    private static int power (int x, int y) {
        int temp;
        if (y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0)
            return multiply(temp, temp);
        else {
            if (y > 0) {
                return multiply(x, multiply(temp, temp));
            }
            else {
                return multiply(temp, temp) / x;
            }
        }
    }
    
}