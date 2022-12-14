class Solution {
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        /*
            Solution 1
            Time - O(n)
            Space - O(n)
        */
        // int[] newArr = new int[n];
        // for(int i = 0; i < n; i++) {
        //     newArr[(i + k) % n] = arr[i];
        // }
        // for(int i = 0; i < n; i++) {
        //     arr[i] = newArr[i];
        // }
        
        /*
            Solution 2
            Time - O(n^2)
            Space O(1)
        */
        
        // while(k > 0) {
        //     int old = arr[0];
        //     for (int i = 0 ; i < n; i++) {
        //         int temp = arr[(i + 1) % n];
        //         arr[(i + 1) % n] = old;
        //         old = temp;
        //     }
        //     k -= 1;
        // }
        
        /*
            Solution 3
            Time - O(n)
            Space - O(1)
        */
        
        rotateBy(0, arr.length - 1, arr);
        rotateBy(0, k - 1, arr);
        rotateBy(k, arr.length - 1, arr);
    }
    private static void rotateBy(int start, int end, int[] arr) {
        while(start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}