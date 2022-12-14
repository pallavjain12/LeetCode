class Solution {
    public int minOperations(int n) {
        int count;
        if (n % 2 == 1) {
            count = ((n/2) * 2) + 1;
        }
        else {
            count = n;
        }
        int sum = 0;
        for(int i = 1; i < count; i += 2) {
            sum += (count - i);
        }
        return sum;
    }
}