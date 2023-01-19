class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> {
            return s1.length() - s2.length();
        });
        int[] count = new int[words.length];
        Arrays.fill(count, 1);
        for (int i = words.length - 1; i >= 0; i--) {
            if (i - 1 < 0)  continue;
            int index = i - 1;
            while(index >= 0 && words[index].length() == words[i].length()) {
                index -= 1;
            }
            while(index >= 0 && words[index].length() + 1 == words[i].length()) {
                if (valid(words[index], words[i])) {
                    count[index] = Math.max(count[index], count[i] + 1);
                }
                index -= 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : count) 
            max = Math.max(max, i);
        return max;
    }
    private static boolean valid(String small, String big) {
        int i = 0;
        int j = 0;
        boolean go = true;
        while(i < small.length() && j < big.length()) {
            if (small.charAt(i) == big.charAt(j)) {
                i += 1;
                j += 1;
            }
            else if (go) {
                j += 1;
                go = false;
            }
            else {
                return false;
            }
        }
        return true;
    }
}