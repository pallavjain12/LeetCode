class Solution {
    public int compareVersion(String v1, String v2) {
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        int i;
        for (i = 0; i < arr1.length || i < arr2.length; i++) {
            int val1;
            if (i >= arr1.length) val1 = 0;
            else val1 = Integer.parseInt(arr1[i]);
            int val2;
            if (i >= arr2.length) val2 = 0;
            else val2 = Integer.parseInt(arr2[i]);   
            if (val1 < val2) return -1;
            else if (val2 < val1)   return 1;
        }
        return 0;
    }
}