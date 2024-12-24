import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Node result = obj.connect(root);

        Queue<Node> q = new LinkedList<>();
        q.add(result);
        while (!q.isEmpty()) {
            Node node = q.poll();
            Node current = node;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
            if (node.left != null) q.add(node.left);
            else if (node.right != null) q.add(node.right);
        }
    }
}
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

class Solution {
    public Node connect(Node root) {
        if (root == null) // if the root is null, return null
            return root;
        Queue<Node> q = new LinkedList<>(); // create a queue to hold nodes
        q.add(root); // add the root node to the queue
        while (!q.isEmpty()) { // while the queue is not empty
            int s = q.size(); // get the size of the queue
            Node head = q.poll(); // remove the head of the queue
            if (head.left != null) // if the left child is not null, add it to the queue
            q.add(head.left);
            if (head.right != null) // if the right child is not null, add it to the queue
            q.add(head.right);
            for (int i = 1; i < s; i++) { // iterate over the remaining nodes in the current level
            Node node = q.poll(); // remove the next node from the queue
            if (node.left != null) // if the left child is not null, add it to the queue
                q.add(node.left);
            if (node.right != null) // if the right child is not null, add it to the queue
                q.add(node.right);
            head.next = node; // set the next pointer of the current node to the next node
            head = head.next; // move to the next node
            }
        }
        return root; // return the modified tree
    }
}