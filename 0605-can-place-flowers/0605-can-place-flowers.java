class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if (n == 0) return true;
        if (arr.length == 1 && (n == 1 || n == 0) && arr[0] == 0)  return true;
        if (arr.length == 1)    return false;
        for (int i = 0; i < arr.length && n > 0; i++) {
            if (arr[i] == 1)    continue;
            if (i == 0) {
                if (arr[i+1] != 1) {
                    arr[i] = 1;
                    n -= 1;
                }
            }
            else if (i == arr.length - 1) {
                if (arr[i - 1] != 1)    {
                    arr[i] = 1;
                    n -= 1;
                }
            }
            else {
                if (arr[i + 1] == arr[i - 1] && arr[i + 1] == 0) {
                    arr[i] = 1;
                    n -= 1;
                }
            }
        }
        if (n == 0) return true;
        return false;
    }
}