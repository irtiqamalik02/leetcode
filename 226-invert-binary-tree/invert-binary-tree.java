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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null)
                queue.offer(current.left);
            if(current.right != null) 
                queue.offer(current.right);
            swapNodes(current);
        }

        return root;
    }

    private void swapNodes(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}