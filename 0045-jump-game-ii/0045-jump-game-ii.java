class Solution {
    public int jump(int[] nums) {
        int[] dis = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                dis[i + j] = Math.min(dis[i + j], dis[i] + 1);
            }
        }
        return dis[nums.length - 1];
    }
}