class Solution {
    static class pair {
        int a;
        int b;
        pair () {
            a = 0;
            b = 0;
        }
        void add(int n) {
            if (n > a) {
                b = a;
                a = n;
            }
            else if (n > b){
                b = n;
            }
        }
    }
    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public int maximumSum(int[] nums) {
        HashMap<Integer, pair> map = new HashMap<Integer, pair>();
        for (int i = 0; i < nums.length; i++) {
            int n = sumOfDigits(nums[i]);
            if (map.containsKey(n)) {
                map.get(n).add(nums[i]);
            }
            else {
                pair temp = new pair();
                temp.add(nums[i]);
                map.put(n, temp);
            }
        }
        int max = -1;
        for (Map.Entry<Integer, pair> en : map.entrySet()) {
            pair temp = en.getValue();
            max = (temp.a != 0 && temp.b != 0) ? Math.max(temp.a + temp.b, max) : max;
        }
        return max;
    }
}