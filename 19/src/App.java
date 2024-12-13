public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        int n = 2;
        head = obj.removeNthFromEnd(head, n);
        node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(0); // Create a new dummy node
        node.next = head; // Set the next of dummy node to head
        ListNode n_from_h = node; // Initialize n_from_h to dummy node
        ListNode n_from_l = node; // Initialize n_from_l to dummy node
        for (int i = 0; i <= n; i++) {
            n_from_h = n_from_h.next; // Move n_from_h n+1 steps ahead
        }
        while (n_from_h != null) {
            n_from_h = n_from_h.next; // Move n_from_h to the end
            n_from_l = n_from_l.next; // Move n_from_l to the (n+1)th last node
        }
        n_from_l.next = n_from_l.next.next; // Remove the nth node from the end
        return node.next; // Return the head of the modified list
    }
}