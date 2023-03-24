class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n-1)   return -1;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int count = -1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            lists.add(temp);
        }
        for (int i = 0; i < connections.length; i++) {
            lists.get(connections[i][0]).add(connections[i][1]);
            lists.get(connections[i][1]).add(connections[i][0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                count += 1;
                dfs(i, count, lists, visited);
            }
        }
        return count;
    }
    
    private static void dfs(int index, int count, ArrayList<ArrayList<Integer>> lists, int[] visited) {
        if (visited[index] != -1) {
            return;
        }
        visited[index] = count;
        for (int i = 0; i < lists.get(index).size(); i++) {
            dfs(lists.get(index).get(i), count, lists, visited);
        }
        return;
    }
}