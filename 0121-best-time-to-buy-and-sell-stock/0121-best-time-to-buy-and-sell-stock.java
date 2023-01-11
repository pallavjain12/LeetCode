class Solution {
    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i : prices) {
            if (i < currentMin) currentMin = i;
            max = Math.max(max, i - currentMin);
        }
        return max;
    }
}