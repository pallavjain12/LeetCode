class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        int[] newArr = new int[n];
        for(int i = 0; i < n; i++) {
            newArr[(i + k) % n] = arr[i];
        }
        for(int i = 0; i < n; i++) {
            arr[i] = newArr[i];
        }
    }
}