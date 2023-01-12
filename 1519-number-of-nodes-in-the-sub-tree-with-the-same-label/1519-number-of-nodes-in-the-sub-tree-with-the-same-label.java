class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int[] answers = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        getLabelsCountAt(0, labels, adj, answers, visited);
        return answers;
    }
    private static int[] getLabelsCountAt(int currentNode, String labels, ArrayList<ArrayList<Integer>> adj, int[] answers, boolean[] visited) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);
        visited[currentNode] = true;
        for (int i : adj.get(currentNode)) {
            if (visited[i]) { continue; }
            int[] temp = getLabelsCountAt(i, labels, adj, answers, visited);
            for (int j = 0; j < 26; j++) {
                charCount[j] += temp[j];
            }
        }
        charCount[labels.charAt(currentNode) - 'a'] += 1;
        answers[currentNode] = charCount[labels.charAt(currentNode) - 'a'];
        return charCount;
    }
}