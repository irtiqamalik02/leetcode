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

    //gobal var to store max dia 
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // Start post-order traversal to calculate diameter
         postOrderTraversal(root); 
         return maxDiameter;
    }

    private int postOrderTraversal(TreeNode root){
        if(root == null) return 0;

        // calculate height recursively
        int leftHeight = postOrderTraversal(root.left);
        int rightHeight = postOrderTraversal(root.right);

        // update the global diameter (path through this node)
        maxDiameter = Math.max(maxDiameter, leftHeight+rightHeight);

        // return height of the current subtree
        return 1 + Math.max(leftHeight,rightHeight);
    }
}