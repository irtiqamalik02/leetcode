/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //encode to preOrder
        // separate nodes by , and rep nulls using #
        StringBuilder nodes = new StringBuilder();
        serializeHelper(root,nodes);
        return nodes.toString();
    }

    private void serializeHelper (TreeNode root, StringBuilder str) {
        if(root == null){
            str.append("#,");
            return;
        }
        // DLR traverse
        str.append(root.val).append(",");
        serializeHelper(root.left,str);
        serializeHelper(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return deserializeHelper(queue);
        
    }
    private TreeNode deserializeHelper(Queue<String> queue) {
        if(queue.isEmpty()) return null;

        String element = queue.poll();
        if(element.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(element));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));