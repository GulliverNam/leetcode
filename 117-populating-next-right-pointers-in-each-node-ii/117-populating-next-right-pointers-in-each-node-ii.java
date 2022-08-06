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
    
    class QueueNode{
        Node node;
        int depth;
        QueueNode(Node node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        
        LinkedList<QueueNode> queue = new LinkedList<>();
        if(root.left != null){
            queue.offer(new QueueNode(root.left, 1));
        }
        if(root.right != null){
            queue.offer(new QueueNode(root.right, 1));
        }
        QueueNode prev = null;
        QueueNode now = null;
        while(!queue.isEmpty()){
            now = queue.poll();
            if(now.node.left != null){
                queue.offer(new QueueNode(now.node.left, now.depth+1));
            }
            if(now.node.right != null){
                queue.offer(new QueueNode(now.node.right, now.depth+1));
            }
            if(prev == null){
                prev = now;
                continue;
            }
            if(now.depth == prev.depth){
                prev.node.next = now.node;
            }
            prev = now;
        }
        return root;
    }
}