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
        if(root == null || root.left == null || root.right == null){
            return root;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root.left);
        queue.addLast(root.right);
        int cnt = 1;
        int depth = 1;
        while(!queue.isEmpty()){
            // System.out.println("cnt: "+cnt+" depth: "+depth);
            // printQueue(queue);
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            if(cnt == 1 && n1.left != null && n1.right != null){
                queue.addLast(n1.left);
                queue.addLast(n1.right);
            }
            if(n2.left != null && n2.right != null){
                queue.addLast(n2.left);
                queue.addLast(n2.right);
            }
            n1.next = n2;
            cnt++;
            if(cnt == Math.pow(2,depth)){
                depth++;
                cnt = 1;
            } else{
                queue.addFirst(n2);
            }
        }
        return root;
    }
    
    private void printQueue(LinkedList<Node> queue){
        for(Node n : queue){
            System.out.print(n.val+" ");
        }
        System.out.println();
    }
}