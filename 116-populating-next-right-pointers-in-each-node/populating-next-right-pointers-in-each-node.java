/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        connectNodes(root);
       
        return root;       
    }

    private void connectNodes(Node root){
        if (root.left == null && root.right == null) return;

        root.left.next = root.right;
        connect(root.left);
       // root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        connect(root.right);    
    }
}