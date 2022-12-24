class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        int[] ans = new int[queries.length];
        int[] beautyMax = new int[items.length];
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(items[i][1], max);
            beautyMax[i] = max;
        }
        for (int i = 0; i < queries.length; i++) {
            int cap = queries[i];
            int mid = 0;
            int l = 0;
            int r = items.length - 1;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (items[mid][0] == cap)
                    break;
                else if (items[mid][0] < cap) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
            if (items[mid][0] == cap) {
                while (mid + 1 < items.length && items[mid + 1][0] == cap) {
                    mid += 1;
                }
            }
            else if (items[mid][0] < cap){
                while(mid + 1 < items.length && items[mid + 1][0] <= cap) {
                    mid += 1;
                }
            }
            else if (items[mid][0] > cap) {
                while (mid - 1 >= 0 && items[mid][0] > cap) {
                    mid -= 1;
                }
            }
            if (items[mid][0] <= cap)
                ans [i] = beautyMax[mid];
            else
                ans[i] = 0;
        }
        return ans;
    }
}