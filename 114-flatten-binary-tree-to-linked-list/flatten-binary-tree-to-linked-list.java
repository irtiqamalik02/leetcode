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
    Queue<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null ) return;

        preOrder(root);
        if(queue.size()== 1) return;
        while(!queue.isEmpty()){
            root.right = queue.poll();
            root.left = null;
            root = root.right;
        }

    }
    private void preOrder(TreeNode root) {
        if(root == null) return;
        queue.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }


}