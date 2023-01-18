class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] i : dp)  Arrays.fill(i, -1);
        return lcs(dp, text1, text1.length() - 1, text2, text2.length() - 1);
    }
    private static int lcs(int[][] dp, String s, int sIndex, String t, int tIndex) {
        if (sIndex < 0 || tIndex < 0)   return 0;
        if (dp[sIndex][tIndex] != -1)   return dp[sIndex][tIndex];
        if (s.charAt(sIndex) == t.charAt(tIndex))
            return dp[sIndex][tIndex] = 1 + lcs(dp, s, sIndex - 1, t, tIndex - 1);
        else {
            return dp[sIndex][tIndex] = Math.max(lcs(dp, s, sIndex, t, tIndex - 1),
                                                lcs(dp, s, sIndex - 1, t, tIndex));
        }
    }
}