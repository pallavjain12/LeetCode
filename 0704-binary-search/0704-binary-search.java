class Solution {
    public int search(int[] nums, int target) {
        int k = Arrays.binarySearch(nums, target);
        if (k < 0)  return-1;
        else return k;
    }
}