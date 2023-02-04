class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())  return false;
        int[] freq = new int[26];
        int[] givenFreq = new int[26];
        Arrays.fill(freq, 0);
        Arrays.fill(givenFreq, 0);
        for (int i = 0; i < s1.length(); i++) {
            givenFreq[s1.charAt(i) - 'a'] += 1;
            freq[s2.charAt(i) - 'a'] += 1;
        }
        if (arrayIsEqual(freq, givenFreq))    return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            freq[s2.charAt(i) - 'a'] += 1;
            freq[s2.charAt(i - s1.length()) - 'a'] -= 1;
            if (arrayIsEqual(freq, givenFreq)) return true;
        }
        return false;
    }
    
    private static boolean arrayIsEqual(int[] freq, int[] givenFreq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != givenFreq[i])    return false;
        }
        return true;
    } 
}