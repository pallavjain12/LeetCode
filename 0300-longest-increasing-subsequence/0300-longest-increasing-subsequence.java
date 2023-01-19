class Solution {
    public int lengthOfLIS(int[] arr) {
        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    lis[j] = Math.max(lis[j], lis[i] + 1);
                    max = Math.max(max, lis[j]);
                }
            }
        }
        return max;
    }
}