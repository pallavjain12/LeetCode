class Solution {
    class pair{
        int val;
        int index;
        pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int maximumTop(int[] nums, int k) {
        
        if (nums.length == 1 && k % 2 == 1) return -1;
        
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (k == i || k > i + 1) {
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }
}