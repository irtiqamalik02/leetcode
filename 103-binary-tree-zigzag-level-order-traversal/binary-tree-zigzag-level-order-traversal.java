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
    // Approach 1: reverse what's left in list
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        if (root == null)
            return answers;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            List<Integer> nodesAtLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
                nodesAtLevel.add(current.val);
            }
            if (!leftToRight) {
                Collections.reverse(nodesAtLevel);
            }
            answers.add(nodesAtLevel);
            leftToRight = !leftToRight; // Toggle direction
        }
        return answers;
    }
}