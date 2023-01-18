class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int[] i : dp)   Arrays.fill(i, -1);
        return lcs(dp, nums1, nums1.length - 1, nums2, nums2.length - 1);
    }
    private static int lcs(int[][] dp, int[] s, int sIndex, int[] t, int tIndex) {
        if (sIndex < 0 || tIndex < 0) {
            return 0;
        }
        if (dp[sIndex][tIndex] != -1)   return dp[sIndex][tIndex];   
        if (s[sIndex] == t[tIndex])
            return dp[sIndex][tIndex] = 1 + lcs(dp, s, sIndex - 1, t, tIndex - 1);
        else
            return dp[sIndex][tIndex] = Math.max(lcs(dp, s, sIndex, t, tIndex - 1), lcs(dp, s, sIndex - 1, t, tIndex));
    }
}