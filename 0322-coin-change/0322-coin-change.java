class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] required = new int[amount + 1];
        Arrays.fill(required, Integer.MAX_VALUE);
        // for (int i = 0; i < coins.length; i++) {
        //     if (coins[i] > amount) continue;
        //     required[coins[i]] = 1;
        // }
        required[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    required[i] = Math.min(required[i], required[i - coins[j]]);
                }
            }
            if (required[i] != Integer.MAX_VALUE)   required[i] += 1;
        }
        if (required[amount] == Integer.MAX_VALUE)  return -1;
        return required[amount];
    }
}