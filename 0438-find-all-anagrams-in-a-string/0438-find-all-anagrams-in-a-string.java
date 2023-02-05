class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length())    return new ArrayList<>();
        int[] freq = new int[26];
        int[] pattern = new int[26];
        Arrays.fill(freq, 0);
        Arrays.fill(pattern, 0);
        List<Integer> ans = new ArrayList<Integer>();
        for (char c : p.toCharArray()) {
            pattern[c - 'a'] += 1;
        }
        for (int i = 0; i < p.length(); i++) {
            freq[s.charAt(i) - 'a'] += 1;
        }
        if (checkEqual(freq, pattern))  ans.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            freq[s.charAt(i - p.length()) - 'a'] -= 1;
            freq[s.charAt(i) - 'a'] += 1;
            if (checkEqual(freq, pattern))  ans.add(i - p.length() + 1);
        }
        return ans;
    }
    private static boolean checkEqual(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i])   return false;
        }
        return true;
    }
}