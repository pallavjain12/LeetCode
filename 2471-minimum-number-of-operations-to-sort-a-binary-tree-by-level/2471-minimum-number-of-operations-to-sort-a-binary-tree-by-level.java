/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minimumOperations(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        iterate(0, root, lists);
        int ans = 0;
        for (ArrayList<Integer> l : lists) {
            ans += countMinimumOperations(l);
        }
        return ans;
    }
    
    private static void iterate(int level, TreeNode root, ArrayList<ArrayList<Integer>> lists) {
        if (root == null)   return;
        if (lists.size() == level) {
            lists.add(new ArrayList<Integer>());
        }
        lists.get(level).add(root.val);
        iterate(level + 1, root.left, lists);
        iterate(level + 1, root.right, lists);
    }
    
    private static int countMinimumOperations(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        ArrayList<Integer> sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != sortedList.get(i)) {
                ans += 1;
                map.put(list.get(i), map.get(sortedList.get(i)));
                Collections.swap(list, i, map.get(sortedList.get(i)));
                map.put(sortedList.get(i), i);
            }
        }
        return ans;
    }
}