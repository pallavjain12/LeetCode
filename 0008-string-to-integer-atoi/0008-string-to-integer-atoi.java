class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0)    return 0;
        String ans = "0";
        int mul = 1;
        int start = 0;
        if (s.charAt(0) == '-') {
            mul = -1;
            start = 1;
        }
        if (s.charAt(0) == '+') start = 1; 
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                ans += String.valueOf(s.charAt(i));
            }
            else {
                break;
            }
        }
        try {
            return Integer.parseInt(ans) * mul;
        }
        catch(Exception e) {
            if (mul == -1) {
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
    }
}