class Solution {
    public int rob(int[] cost) {
        if (cost.length == 1)   return cost[0];
        if (cost.length == 2)   return Math.max(cost[0], cost[1]);
        int[] arr = new int[cost.length];
        arr[0] = cost[0];
        arr[1] = Math.max(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            arr[i] = Math.max(cost[i] + arr[i - 2], arr[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) max = Math.max(max, i);
        return max;
    }
}