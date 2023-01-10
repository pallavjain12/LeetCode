class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] arr = new int[cost.length];
        if (cost.length == 2)   return Math.min(cost[0], cost[1]);
        Arrays.fill(arr, -1);
        return calCost(arr, cost, cost.length - 1);
    }
    private static int calCost(int[] arr, int[] cost, int currentLevel) {
        if (arr[currentLevel] != -1)    return arr[currentLevel];
        if (currentLevel == 1)  return cost[1];
        if (currentLevel == 0) return cost[0];
        if (currentLevel == cost.length - 1) {
            return Math.min(cost[currentLevel] + calCost(arr, cost, currentLevel - 2), calCost(arr, cost, currentLevel - 1));
        }
        else {
            return arr[currentLevel] = cost[currentLevel]  + Math.min(calCost(arr, cost, currentLevel - 1), calCost(arr, cost, currentLevel - 2));
        }
    }
}