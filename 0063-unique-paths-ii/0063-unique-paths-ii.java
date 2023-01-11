class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int[][] ans = new int[arr.length][arr[0].length];
        if (arr[0][0] == 1) return 0;
        ans[0][0] = 1;
        for (int i = 0 ; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!valid(i, j, arr)) {
                    continue;
                }
                if (valid(i-1, j, arr)) {
                    ans[i][j] += ans[i-1][j];
                }
                if (valid(i, j - 1, arr)) {
                    ans[i][j] += ans[i][j-1];
                }
            }
        }
        return ans[arr.length - 1][arr[0].length - 1];
    }
    public static boolean valid(int i, int j, int[][] arr) {
        if (i < 0 || i >= arr.length) {
            return false;
        }
        if (j < 0 || j >= arr[0].length) {
            return false;
        }
        if (arr[i][j] == 1) {
            return false;
        }
        return true;
    }
}