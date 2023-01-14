class Solution {
    public int rob(int[] arr) {
        if (arr.length == 0)    return 0;
        if (arr.length == 1)    return arr[0];
        if (arr.length == 2)    return Math.max(arr[0], arr[1]);
        if (arr.length == 3)    return Math.max(Math.max(arr[0], arr[1]), arr[2]);
        int[] max = new int[arr.length];
        max[0] = arr[0];
        max[1] = Math.max(arr[0], arr[1]);
        int max1 = 0;
        for (int i = 2; i < arr.length - 1; i++) {
            max[i] = Math.max(arr[i] + max[i - 2], max[i - 1]);
        }
        for (int i : max)   max1 = Math.max(max1, i);
        max[0] = 0;
        max[1] = arr[1];
        max[2] = Math.max(arr[1], arr[2]);
        for (int i = 3; i < arr.length; i++) {
            max[i] = Math.max(arr[i] + max[i - 2], max[i - 1]);
        }
        for(int i : max)    max1 = Math.max(i, max1);
        return max1;
    }
}