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
        if (root == null || root.val == x || root.val == y) return false;

        // Use a queue for level-order traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, null)); // Pair: (node, parent)

        TreeNode xParent = null, yParent = null;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Pair current = queue.poll();
                TreeNode node = current.node, parent = current.parent;

                // Check for x and y at the current level
                if (node.val == x) xParent = parent;
                if (node.val == y) yParent = parent;

                // Add children to the queue
                if (node.left != null) queue.offer(new Pair(node.left, node));
                if (node.right != null) queue.offer(new Pair(node.right, node));
            }

            // Check if both x and y are found
            if (xParent != null && yParent != null) {
                return xParent != yParent; // Different parents => cousins
            }

            // If only one is found, they can't be cousins
            if (xParent != null || yParent != null) return false;
        }

        return false; // If we exit without finding both x and y
    }

    // Helper class to store node and parent
    private static class Pair {
        TreeNode node, parent;
        Pair(TreeNode node, TreeNode parent) {
            this.node = node;
            this.parent = parent;
        }
    }
}
