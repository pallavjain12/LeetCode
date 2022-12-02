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
    public List<TreeNode> generateTrees(int n) {
        return solve(1, n);
    }
    private static ArrayList<TreeNode> solve(int start, int end) {
        if (start > end) {
            ArrayList<TreeNode> list = new ArrayList<TreeNode>();
            list.add(null);
            return list;
        }
        ArrayList<TreeNode> ans = new ArrayList<>();
        for(int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = solve(start, i-1);
            ArrayList<TreeNode> right = solve(i+1, end);
            
            for (TreeNode l:left) {
                for(TreeNode r: right) {
                    TreeNode temp = new TreeNode(i);
                    temp.left = l;
                    temp.right = r;
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    
}