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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Post-order traversal: Right -> Left -> Root
        flatten(root.right);
        flatten(root.left);

        // Modify pointers to flatten the tree
        root.right = prev;
        root.left = null;

        // Move the prev pointer
        prev = root;
    }
}
