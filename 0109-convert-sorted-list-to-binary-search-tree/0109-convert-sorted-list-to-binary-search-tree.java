/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        ListNode itr = head;
        while(itr != null) {
            map.put(counter++, itr.val);
            itr = itr.next;
        }
        TreeNode node = buildTree(map, 0, counter - 1);
        return node;
    }
    
    static TreeNode buildTree(HashMap<Integer, Integer> map, int left, int right) {
        if (left == right) {
            TreeNode temp = new TreeNode(map.get(left));
            return temp;
        }
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode temp = new TreeNode();
        temp.val=map.get(mid);
        temp.right = buildTree(map, mid + 1, right);
        temp.left = buildTree(map, left, mid - 1);
        return temp;
        
    }
}