class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, 0);
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for (int j = 0; j < points.length; j++) {
                int hx = points[j][0];
                int hy = points[j][1];
                int hxp = hx - x;
                int hyp = hy - y;
                if ( (hxp * hxp) + (hyp * hyp) <= r*r) ans[i] += 1;
            }
        }
        return ans;
    }
}