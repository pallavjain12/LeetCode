class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, 0);
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int h = points[j][0];
                int k = points[j][1];
                int hp = h - x;
                int kp = k - y;
                if ( (hp * hp) + (kp * kp) <= r*r) ans[i] += 1;
            }
        }
        return ans;
    }
}