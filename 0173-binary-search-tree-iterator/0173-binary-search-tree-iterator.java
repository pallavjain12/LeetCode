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
import java.util.ArrayList;
class BSTIterator {
    ArrayList<Integer> list;
    int counter;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<Integer>();
        counter = 0;
        iterateOverBST(root);
    }
    
    private void iterateOverBST(TreeNode root) {
        if (root == null) {
            return;
        }
        
        iterateOverBST(root.left);
        list.add(root.val);
        iterateOverBST(root.right);
    }
    
    public int next() {
        return list.get(counter++);
    }
    
    public boolean hasNext() {
        return !(counter == list.size());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */