class Solution {
    public int maxPoints(int[][] points) {
        if(points.length <= 2) return points.length;
        int ans = 2;        
        for(int[] a : points){
            Map<Double, Integer> map = new HashMap<>();
            for(int[] b : points){
                double slope = 0;
                if (a == b) continue;
                if(b[0] - a[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] -a[1]) / (double)(b[0] - a[0]);
                map.put(slope, map.getOrDefault(slope, 1)+1);
                ans = Math.max(ans, map.get(slope));             
            }
        } 
        return ans;
    }
}