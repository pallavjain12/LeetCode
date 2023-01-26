class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (checkPalindorme(s.substring(i, j + 1))) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }
    
    private static boolean checkPalindorme(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l += 1;
            r -= 1;
        }
        return true;
    }
}