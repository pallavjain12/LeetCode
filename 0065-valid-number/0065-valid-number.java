class Solution {
    public boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 57 && s.charAt(i) != 'e' && s.charAt(i) != 'E')
                return false;
        }
        try {
            Double i = Double.parseDouble(s);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}