class Solution {
    public int maxSubArray(int[] nums) {
        int prev = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prev = Math.max(nums[i], prev + nums[i]);
            max = (prev > max) ? prev : max;
        }
        return max;
    }
}