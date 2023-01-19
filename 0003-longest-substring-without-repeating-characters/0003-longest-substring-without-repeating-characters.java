class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) >= start) {
                    start = map.get(ch) + 1;   
                }
                map.put(ch, i);
            }
            else {
                map.put(ch, i);
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}