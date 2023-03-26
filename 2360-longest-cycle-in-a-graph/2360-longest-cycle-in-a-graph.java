class Solution {
    public int longestCycle(int[] edges) {
        int[] visited = new int[edges.length];
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> set = new HashSet<Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (edges[i] == -1) continue;
            max = Math.max(iterateFrom(i, set, list, edges), max);
        }
        return max;
    }
    
    private static int iterateFrom(int index, Set<Integer> set, ArrayList<Integer> list, int[] edges) {
        if (set.contains(index)) {
            return findLengthOfCycle(list, index);
        }
        else if (edges[index] == -1)    return -1;
        else {
            int temp = edges[index];
            edges[index] = -1;
            set.add(index);
            list.add(index);
            return iterateFrom(temp, set, list, edges);
        }
    }
    private static int findLengthOfCycle(ArrayList<Integer> list, int index) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == index) {
                return list.size() - i;
            }
        }
        return 0;
    }
}