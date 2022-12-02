class Solution {
    public int removeDuplicates(int[] arr) {
        int with = 1;
        boolean duplicate = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                duplicate = false;
                arr[with] = arr[i];
                with += 1;
            }
            else if (duplicate && arr[i] == arr[i - 1]) {
                continue;
            }
            else if (arr[i] == arr[i - 1]) {
                duplicate = true;
                arr[with] = arr[i];
                with += 1;
            }
        }
        return with;
    }
}