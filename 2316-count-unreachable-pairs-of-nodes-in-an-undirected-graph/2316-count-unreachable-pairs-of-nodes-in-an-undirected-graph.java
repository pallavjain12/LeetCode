class Solution {
    public long countPairs(int n, int[][] edges) {
        if (n == 0) return 0;
        if (n == 1)  return 0;
        int[] visited = new int[n];
        int counter = -1;
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            lists.add(temp);
        }
        for (int[] i : edges) {
            lists.get(i[0]).add(i[1]);
            lists.get(i[1]).add(i[0]);
        }
        Arrays.fill(visited, -1);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == -1) {
                counter += 1;
                
                dfs(counter, i, visited, lists);
            }
        }
        long ans = 0;
        long calculated = 0;
        if (counter == 0)   return ans;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < visited.length; i++) {
            map.put(visited[i], map.getOrDefault(visited[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> em : map.entrySet()) {
            long k = em.getValue();
            ans += k * (n - calculated - k);
            calculated += k;
        }
        return ans;
    }
    
    private static void dfs(int counter, int index, int[] visited, ArrayList<ArrayList<Integer>> lists) {
        if (visited[index] != -1) {
            return;
        }
        visited[index] = counter;
        for (int i = 0; i < lists.get(index).size(); i++) {
            dfs(counter, lists.get(index).get(i), visited, lists);
        }
        return;
    }
}