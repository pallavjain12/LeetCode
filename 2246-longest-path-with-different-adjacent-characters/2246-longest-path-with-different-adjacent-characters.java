class Solution {
    public int longestPath(int[] parent, String s) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = s.length();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            visited[i] = false;
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 1; i < n; i++) {
            adj.get(parent[i]).add(i);
            adj.get(i).add(parent[i]);
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        check(adj, s, 0, max, visited);
        return max[0];
    }
    private static int check(ArrayList<ArrayList<Integer>> adj, String s, int currentNode, int[] max, boolean[] visited) {
        visited[currentNode] = true;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < adj.get(currentNode).size(); i++) {
            if (visited[adj.get(currentNode).get(i)])   continue;
            int childLength = check(adj, s, adj.get(currentNode).get(i), max, visited);
            if (s.charAt(currentNode) != s.charAt(adj.get(currentNode).get(i))) {
                if (childLength >= max1) {
                    int temp = max1;
                    max1 = childLength;
                    if (temp > max2) {
                        max2 = temp;
                    }
                }
                else if (childLength > max2)
                    max2 = childLength;
            }
        }
        if (max1 == Integer.MIN_VALUE)  max1 = 0;
        if (max2 == Integer.MIN_VALUE)  max2 = 0;
        max[0] = Math.max(1 + max1 + max2, max[0]);
        return 1 + Math.max(max1, max2);
    }
}