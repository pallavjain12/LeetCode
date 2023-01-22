class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<>();
        check(s, 0, lists, new ArrayList<String>());
        return lists;
    }
    
    private static void check(String s, int index, List<List<String>> lists, ArrayList<String> list) {
        if (index == s.length()) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(list);
            lists.add(temp);
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(index) && validPalindrome(s, index , i)) {
                list.add(s.substring(index, i + 1));
                check(s, i + 1, lists, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private static boolean validPalindrome(String s, int start, int end) {
        while(start <= end) {
            if (!(s.charAt(start) == s.charAt(end))) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }
}