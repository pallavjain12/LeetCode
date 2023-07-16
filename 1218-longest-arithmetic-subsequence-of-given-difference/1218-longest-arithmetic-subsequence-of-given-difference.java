class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        int ans = 1;
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (map.containsKey(num - difference)) {
                map.put(num, map.get(num - difference) + 1);
            } else {
                map.put(num, 1);
            }
            
            ans = Math.max(ans, map.get(num));
        }
        
        return ans;
    }
}