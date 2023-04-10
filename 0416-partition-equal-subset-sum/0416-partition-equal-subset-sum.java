class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i : nums)   sum += i;

        if (sum % 2 == 1)    return false;     
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }
        int[][] dp = new int[arr.length + 1][sum/2 + 1];
        for (int value = 0; value <= n; value++) {
            for (int wt = 0; wt <= sum/2; wt++) {
                if (wt == 0 || value == 0) {
                    dp[value][wt] = 0;
                }
                else if (arr[value] <= wt) {
                    dp[value][wt] = Math.max(arr[value] + dp[value - 1][wt - arr[value]], dp[value - 1][wt]);
                }
                else {
                    dp[value][wt] = dp[value - 1][wt];
                }
                if (dp[value][wt] == sum/2) return true;
            }    
        }
        return false;
    }
}