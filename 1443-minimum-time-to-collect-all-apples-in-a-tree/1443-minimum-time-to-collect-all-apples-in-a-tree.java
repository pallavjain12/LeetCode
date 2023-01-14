class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) list.add(new ArrayList<Integer>());
        for (int[] i : edges) {
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }
        int ans = count(list, hasApple, 0, visited);
        if (ans == 0)   return 0;
        return ans - 2;
    }
    private static int count(ArrayList<ArrayList<Integer>> list, List<Boolean> hasApple, int currentNode, boolean[] visited) {
        visited[currentNode] = true;
        int sum = 0;
        for (int i : list.get(currentNode)) {
            if (visited[i]) continue;
            sum += count(list, hasApple, i, visited);
        }
        if (sum != 0) {
            sum += 2;
        }
        else if (hasApple.get(currentNode)) {
            sum += 2;
        }
        return sum;
    }
}