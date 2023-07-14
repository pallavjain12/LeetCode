class Solution {
    public int maxNonDecreasingLength(int[] nums0, int[] nums1) {
        int[][] arr = new int[nums1.length][2];
        
        arr[0][1] = 1;
        arr[0][0] = 1;
        
        int max = 1;
        
        for (int i = 1; i < nums1.length; i++) {
            arr[i][0] = 1;
            arr[i][1] = 1;
            if (nums0[i] >= nums0[i - 1]) {
                arr[i][0] = Math.max(arr[i][0], arr[i - 1][0] + 1);
            }
            if (nums0[i] >= nums1[i - 1]) {
                arr[i][0] = Math.max(arr[i][0], arr[i - 1][1] + 1);
            }
            
            if (nums1[i] >= nums0[i - 1]) {
                arr[i][1] = Math.max(arr[i][1], arr[i - 1][0] + 1);
            }
            if (nums1[i] >= nums1[i - 1]) {
                arr[i][1] = Math.max(arr[i][1], arr[i - 1][1] + 1);
            }
            max = Math.max(max, Math.max(arr[i][0], arr[i][1]));
        }
        // for (int[] i : arr) {
        //     System.out.println(i[0] + " " + i[1]);
        // }
        return max;
    }
}