class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i += 2) {
            arr[i] = nums[i / 2];
            arr[i + 1] = nums[i / 2 + n];
        }
        return arr;
    }
}