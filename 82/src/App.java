public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode result = obj.deleteDuplicates(head);

        // Print the result list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode Dummy = new ListNode(); // Create a dummy node
        Dummy.next = head; // Point dummy node's next to head
        ListNode prev = Dummy; // Initialize prev to dummy
        ListNode curr = head; // Initialize curr to head
        while (curr != null) { // Traverse the list
            if (curr.next != null && curr.val == curr.next.val) { // Check for duplicates
            while (curr.next != null && curr.val == curr.next.val) curr = curr.next; // Skip all duplicates
            prev.next = curr.next; // Link prev to the node after duplicates
            } else {
            prev = prev.next; // Move prev to next node
            }
            curr = curr.next; // Move curr to next node
        }
        return Dummy.next; // Return the modified list
    }
}