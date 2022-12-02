class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();
        solve(arr, set, stack, 0);
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
    public void solve(int[] arr, Set<List<Integer>> set, Stack<Integer> stack, int index) {
        if (index == arr.length) {
            List<Integer> l = new ArrayList<Integer>(stack);
            Collections.sort(l);
            set.add(l);
            return;
        }
        stack.push(arr[index]);
        solve(arr, set, stack, index + 1);
        stack.pop();
        solve(arr, set, stack, index + 1);
        return;
    }
}