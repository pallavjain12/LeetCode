class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> {
           return a[1] - b[1]; 
        });
        int n = events.length;
        int[][] dp = new int[k+1][n+1];
        for (int[] i : dp) {
            Arrays.fill(i, 0);
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                int p = j - 1;
                while (p >= 1 && events[p - 1][1] >= events[j - 1][0])
                    p -= 1;
                dp[i][j] = Math.max(dp[i-1][p] + events[j-1][2], dp[i][j-1]);
                
            }
        }
        return dp[k][n];
    }
}