/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        // find parents and depth
        if (root == null)
            return false;
        if(root.val == x || root.val == y) return false;    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode xParent = null;
        TreeNode yParent = null;
        int level = 0;
        int xLevel = 0;
        int yLevel = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                if (xParent != null && yParent != null && xParent == yParent)
                    return false;    
                TreeNode current = queue.poll();
                if (current.left != null) {
                    if (current.left.val == x) {
                        xParent = current;
                        xLevel = level;
                    }
                    if (current.left.val == y) {
                        yParent = current;
                        yLevel = level;
                    }
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    if (current.right.val == x) {
                        xParent = current;
                        xLevel = level;
                    }
                    if (current.right.val == y) {
                        yParent = current;
                        yLevel = level;
                    }
                    queue.offer(current.right);
                }
            }

            level++;
        }

        return xParent != yParent && xLevel == yLevel;

    }

}