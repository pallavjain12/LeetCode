class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        
        check(target, 0, candidates, set, new ArrayList<Integer>());
        
        Iterator itr = set.iterator();
        while(itr.hasNext()) {
            lists.add((List<Integer>)itr.next());
        }
        
        return lists;
    }
    private static void check (int target, int currentSum, int[] arr, Set<List<Integer>> lists, ArrayList<Integer> list) {
        if (currentSum > target) return; 
        
        if (currentSum == target) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i : list) temp.add(i);
            Collections.sort(temp);
            lists.add(temp);
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            check(target, currentSum + arr[i], arr, lists, list);
            list.remove(list.size() - 1);
        }
    }
}