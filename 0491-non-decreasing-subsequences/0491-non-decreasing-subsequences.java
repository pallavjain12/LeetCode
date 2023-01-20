class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        allSubsets(set, nums, 0, new ArrayList<Integer>());
        Iterator<ArrayList<Integer>> itr = set.iterator();
        while(itr.hasNext()) {
            lists.add(itr.next());
        }
        return lists;
    }
    private static void allSubsets(Set<ArrayList<Integer>> set, int[] arr, int index, ArrayList<Integer> list) {
        if (index == arr.length) {
            if (valid(list) && list.size() >= 2) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.addAll(list);
                set.add(temp);
            }
            return;
        }
        allSubsets(set, arr, index + 1, list);
        list.add(arr[index]);
        allSubsets(set, arr, index + 1, list);
        list.remove(list.size() - 1);
    }
    private static boolean valid(ArrayList<Integer> list) {
        if (list.size() == 0)   return false;
        int max = list.get(0);
        for (int i : list) {
            if (i >= max) {
                max = i;
            }
            else {
                return false;
            }
        }
        return true;
    }
}