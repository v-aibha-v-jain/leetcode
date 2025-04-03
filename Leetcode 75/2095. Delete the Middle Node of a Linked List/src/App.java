public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))));
        ListNode result = solution.deleteMiddle(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println();
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
    public ListNode deleteMiddle(ListNode head) {
        int count = 0; // Initialize count to determine the length of the list
        ListNode current = head; // Start traversing from the head node
        while (current != null) {
            count++; // Increment count for each node in the list
            current = current.next; // Move to the next node
        }
        current = head; // Reset current to the head of the list
        if (count == 1) return current.next; // If there's only one node, return null (delete the only node)
        int n = (count / 2) - 1; // Calculate the index of the node before the middle node
        for (int i = 0; i < n; i++) current = current.next; // Traverse to the node before the middle node
        current.next = current.next.next; // Skip the middle node by updating the next pointer
        return head; // Return the modified list
    }
}