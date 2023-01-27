class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();
        char[][] ch = new char[][] {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
        };
        List<String> temp = new ArrayList<String>();
        temp.add("");
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < digits.length(); i++) {
            ans = new ArrayList<String>();
            for (int j = 0; j < ch[digits.charAt(i) - '2'].length; j++) {
                for (String s : temp) {
                    ans.add(s + String.valueOf(ch[digits.charAt(i) - '2'][j]));
                }
            }
            temp = new ArrayList<String>();
            temp.addAll(ans);
        }
        return ans;
    }
}