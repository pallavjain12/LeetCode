class Solution {
    public int findLongestChain(int[][] pairs) {
        int[] count = new int[pairs.length];
        Arrays.fill(count, 1);
        Arrays.sort(pairs, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        for (int[] i : pairs) {
            System.out.println(i[0] + " " + i[1]);
        }
        for (int i = 0; i < pairs.length; i++) {
            for(int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && count[i] < count[j] + 1) {
                    count[i] = count[j] + 1;
                }
            }
        }
        int max = 1;
        for (int i : count)
            max = Math.max(max, i);
        return max;
    }
}