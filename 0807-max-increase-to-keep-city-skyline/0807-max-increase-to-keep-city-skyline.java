class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] vertical = new int[grid.length];
        int[] horizontal = new int[grid.length];
        for (int i = 0; i < vertical.length; i++) {
            vertical[i] = 0;
            horizontal[i] = 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                horizontal[i] = Math.max(horizontal[i], grid[i][j]);
                vertical[j] = Math.max(vertical[j], grid[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                ans += (Math.min(vertical[j], horizontal[i]) - grid[i][j]);
            }
        }
        return ans;
    }
}