import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        Node head = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        head.next = node1;
        head.random = null;
        node1.next = node2;
        node1.random = head;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.next = null;
        node4.random = head;
        Node newHead = solution.copyRandomList(head);
        while(newHead != null){
            System.out.println("Node: " + newHead.val + " Random: " + (newHead.random == null ? "null" : newHead.random.val));
            newHead = newHead.next;
        }
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) // if the head is null, return null
            return head;
        Map<Node, Node> oldToNewNodeMap = new HashMap<>(); // map to store the mapping from old nodes to new nodes
        Node newListHead = null; // head of the new list
        Node iteratorNode = head; // iterator for the old list
        Node newListPrev = null; // previous node in the new list
        while(iteratorNode != null){
            Node newNode = new Node(iteratorNode.val); // create a new node with the same value as the old node
            oldToNewNodeMap.put(iteratorNode, newNode); // map the old node to the new node
            if(newListHead == null){
            newListHead = newNode; // set the head of the new list
            newListPrev = newNode; // set the previous node to the new node
            }
            else{
            newListPrev.next = newNode; // link the previous node to the new node
            newListPrev = newNode; // update the previous node to the new node
            }
            iteratorNode = iteratorNode.next; // move to the next node in the old list
        }
        iteratorNode = head; // reset the iterator to the head of the old list
        while(iteratorNode != null){
            Node newListNode = oldToNewNodeMap.get(iteratorNode); // get the corresponding new node
            newListNode.next = iteratorNode.next == null ? null : oldToNewNodeMap.get(iteratorNode.next); // set the next pointer
            newListNode.random = iteratorNode.random == null ? null : oldToNewNodeMap.get(iteratorNode.random); // set the random pointer
            iteratorNode = iteratorNode.next; // move to the next node in the old list
        }
        return newListHead; // return the head of the new list
    }
}